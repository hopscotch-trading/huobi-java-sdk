package com.hopscotchtrading.huobi_java_sdk.service.huobi;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.client.WalletClient;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositAddress;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositWithdraw;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.WithdrawAddressResult;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.WithdrawQuota;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.connection.HuobiRestConnection;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet.DepositAddressParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet.DepositWithdrawParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet.WithdrawAddressParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet.WithdrawQuotaParser;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.signature.UrlParamsBuilder;
import com.hopscotchtrading.huobi_java_sdk.utils.InputChecker;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.CreateWithdrawRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.DepositAddressRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.DepositWithdrawRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.WithdrawAddressRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.WithdrawQuotaRequest;

public class HuobiWalletService implements WalletClient {


  public static final String GET_DEPOSIT_ADDRESS_PATH = "/v2/account/deposit/address";
  public static final String GET_WITHDRAW_ADDRESS_PATH = "/v2/account/withdraw/address";
  public static final String GET_WITHDRAW_QUOTA_PATH = "/v2/account/withdraw/quota";
  public static final String CREATE_WITHDRAW_PATH = "/v1/dw/withdraw/api/create";
  public static final String CANCEL_WITHDRAW_PATH = "/v1/dw/withdraw-virtual/{withdraw-id}/cancel";
  public static final String DEPOSIT_WITHDRAW_PATH = "/v1/query/deposit-withdraw";

  private Options options;

  private HuobiRestConnection restConnection;

  public HuobiWalletService(Options options) {
    this.options = options;
    this.restConnection = new HuobiRestConnection(options);
  }

  @Override
  public List<DepositAddress> getDepositAddress(DepositAddressRequest request) {

    // 验证参数
    InputChecker.checker()
        .shouldNotNull(request.getCurrency(), "currency");

    UrlParamsBuilder builder = UrlParamsBuilder.build()
        .putToUrl("currency", request.getCurrency());

    JSONObject jsonObject = restConnection.executeGetWithSignature(GET_DEPOSIT_ADDRESS_PATH, builder);
    JSONArray array = jsonObject.getJSONArray("data");
    return new DepositAddressParser().parseArray(array);
  }

  @Override
  public WithdrawQuota getWithdrawQuota(WithdrawQuotaRequest request) {
    // 验证参数
    InputChecker.checker()
        .shouldNotNull(request.getCurrency(), "currency");

    UrlParamsBuilder builder = UrlParamsBuilder.build()
        .putToUrl("currency", request.getCurrency());

    JSONObject jsonObject = restConnection.executeGetWithSignature(GET_WITHDRAW_QUOTA_PATH, builder);
    JSONObject data = jsonObject.getJSONObject("data");
    return new WithdrawQuotaParser().parse(data);
  }

  public WithdrawAddressResult getWithdrawAddress(WithdrawAddressRequest request) {

    // 验证参数
    InputChecker.checker()
        .shouldNotNull(request.getCurrency(), "currency");

    UrlParamsBuilder builder = UrlParamsBuilder.build()
        .putToUrl("currency", request.getCurrency())
        .putToUrl("chain", request.getChain())
        .putToUrl("note", request.getNote())
        .putToUrl("limit", request.getLimit())
        .putToUrl("fromId", request.getFromId());

    JSONObject jsonObject = restConnection.executeGetWithSignature(GET_WITHDRAW_ADDRESS_PATH, builder);
    JSONArray array = jsonObject.getJSONArray("data");

    return WithdrawAddressResult.builder()
        .nextId(jsonObject.getLong("next-id"))
        .withdrawAddressList(new WithdrawAddressParser().parseArray(array))
        .build();
  }

  @Override
  public Long createWithdraw(CreateWithdrawRequest request) {

    InputChecker.checker()
        .shouldNotNull(request.getAddress(), "address")
        .shouldNotNull(request.getAmount(), "amount")
        .shouldNotNull(request.getCurrency(), "currency")
        .shouldNotNull(request.getFee(), "fee");

    UrlParamsBuilder builder = UrlParamsBuilder.build()
        .putToPost("address", request.getAddress())
        .putToPost("amount", request.getAmount())
        .putToPost("currency", request.getCurrency())
        .putToPost("fee", request.getFee())
        .putToPost("addr-tag", request.getAddrTag())
        .putToPost("chain", request.getChain());

    JSONObject jsonObject = restConnection.executePostWithSignature(CREATE_WITHDRAW_PATH, builder);
    return jsonObject.getLong("data");
  }

  @Override
  public Long cancelWithdraw(Long withdrawId) {

    InputChecker.checker()
        .shouldNotNull(withdrawId, "withdraw-id");

    String path = CANCEL_WITHDRAW_PATH.replace("{withdraw-id}", withdrawId + "");

    JSONObject jsonObject = restConnection.executePostWithSignature(path, UrlParamsBuilder.build());
    return jsonObject.getLong("data");
  }

  @Override
  public List<DepositWithdraw> getDepositWithdraw(DepositWithdrawRequest request) {

    InputChecker.checker()
        .shouldNotNull(request.getType(), "type");
    UrlParamsBuilder builder = UrlParamsBuilder.build()
        .putToUrl("type", request.getType().getType())
        .putToUrl("currency", request.getCurrency())
        .putToUrl("from", request.getFrom())
        .putToUrl("size", request.getSize())
        .putToUrl("direct", request.getDirection() == null ? null : request.getDirection().getCode());

    JSONObject jsonObject = restConnection.executeGetWithSignature(DEPOSIT_WITHDRAW_PATH, builder);
    JSONArray data = jsonObject.getJSONArray("data");
    return new DepositWithdrawParser().parseArray(data);
  }


}
