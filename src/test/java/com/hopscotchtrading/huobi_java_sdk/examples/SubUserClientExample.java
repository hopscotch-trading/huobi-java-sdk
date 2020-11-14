package com.hopscotchtrading.huobi_java_sdk.examples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import com.hopscotchtrading.huobi_java_sdk.client.SubUserClient;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountBalance;
import com.hopscotchtrading.huobi_java_sdk.model.account.SubuserAggregateBalance;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositAddress;
import com.hopscotchtrading.huobi_java_sdk.Constants;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.TransferSubuserRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetApiKeyListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserAccountListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserDepositRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.GetSubUserListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyDeletionRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyGenerationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserApiKeyModificationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserCreationParam;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserCreationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserManagementRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserTradableMarketRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.subuser.SubUserTransferabilityRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.HuobiOptions;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.SubUserApiKeyPermissionEnums;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.SubUserManagementActionEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.TradableMarketAccountTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.TradableMarketActivationEnums;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.TransferMasterTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.TransferabilityAccountTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetApiKeyListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserAccountListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserDepositResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserListResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserApiKeyGenerationResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserApiKeyModificationResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserCreationInfo;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserManagementResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserState;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTradableMarketResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTradableMarketState;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTransferabilityResult;
import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTransferabilityState;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.utils.GoogleAuthHelper;

public class SubUserClientExample {

  public static void main(String[] args) {

    Long subUid = 120491258L;
    SubUserClient subUserClient = SubUserClient.create(HuobiOptions.builder()
        .apiKey(Constants.API_KEY)
        .secretKey(Constants.SECRET_KEY)
        .build());

    System.out.println("===========transfer to subuser ===============");
    long outTransferId = subUserClient.transferSubuser(TransferSubuserRequest.builder()
        .subUid(subUid)
        .currency("usdt")
        .amount(new BigDecimal("10"))
        .type(TransferMasterTypeEnum.MASTER_TRANSFER_OUT)
        .build());
    System.out.println("===========transfer to subuser  result:" + outTransferId + "===============");

    List<AccountBalance> subAccountBalanceList = subUserClient.getSubuserAccountBalance(subUid);
    System.out.println(subAccountBalanceList);

    List<SubuserAggregateBalance> aggBalanceList = subUserClient.getSubuserAggregateBalance();
    System.out.println("agg balance list:" + aggBalanceList.toString());

    System.out.println("===========transfer to master ===============");
    long inTransferId = subUserClient.transferSubuser(TransferSubuserRequest.builder()
        .subUid(subUid)
        .currency("usdt")
        .amount(new BigDecimal("10"))
        .type(TransferMasterTypeEnum.MASTER_TRANSFER_IN)
        .build());
    System.out.println("===========transfer to subuser  result:" + inTransferId + "===============");

    List<AccountBalance> subAccountBalanceList1 = subUserClient.getSubuserAccountBalance(subUid);
    System.out.println(subAccountBalanceList1);

    List<SubUserCreationParam> creationParamList = new ArrayList<>();
    creationParamList.add(SubUserCreationParam.builder()
        .userName("test"+System.nanoTime()+"1")
        .build());
    creationParamList.add(SubUserCreationParam.builder()
        .userName("test"+System.nanoTime()+"2")
        .build());

    List<SubUserCreationInfo> creationInfoList = subUserClient.subuserCreation(SubUserCreationRequest.builder()
        .userList(creationParamList)
        .build());

    creationInfoList.forEach(info->{
      System.out.println(info.toString());
    });

    GetSubUserListResult getSubUserListResult = subUserClient.getSubUserList(GetSubUserListRequest.builder().build());
    System.out.println("get sub user list nextId:" + getSubUserListResult);
    getSubUserListResult.getUserList().forEach(subUserState -> {
      System.out.println(subUserState.toString());
    });

    SubUserState subUserState = subUserClient.getSubuserState(subUid);
    System.out.println(subUserState);

    SubUserManagementResult subUserManagementResult = subUserClient.subuserManagement(SubUserManagementRequest.builder()
        .subUid(subUid)
        .action(SubUserManagementActionEnum.UNLOCK)
        .build());

    System.out.println(subUserManagementResult);

    GetSubUserAccountListResult getSubUserAccountListResult = subUserClient.getSubuserAccountList(GetSubUserAccountListRequest.builder()
        .subUid(subUid)
        .build());

    System.out.println(getSubUserAccountListResult);

    // set subuser transferrable state
    SubUserTransferabilityRequest transferabilityRequest = new SubUserTransferabilityRequest();
    transferabilityRequest.setSubUids(subUid + "");
    transferabilityRequest.setTransferrable(Boolean.TRUE.toString());
    transferabilityRequest.setAccountType(TransferabilityAccountTypeEnum.SPOT);
    SubUserTransferabilityResult transferabilityResult = subUserClient.subuserTransferability(transferabilityRequest);
    if (transferabilityResult != null) {
      for (SubUserTransferabilityState transferabilityState : transferabilityResult.getList()) {
        System.out.println("transferabilityState:  "
            + "subUid:" + transferabilityState.getSubUid()
            + "  accountType:" + transferabilityState.getAccountType()
            + "   transferrable: " + transferabilityState.getTransferrable());
      }
    }

//     set sub user tradable market
    SubUserTradableMarketRequest tradableMarketRequest = new SubUserTradableMarketRequest();
    tradableMarketRequest.setSubUids(subUid+"");
    tradableMarketRequest.setAccountType(TradableMarketAccountTypeEnum.ISOLATED_MARGIN);
    tradableMarketRequest.setActivation(TradableMarketActivationEnums.ACTIVATED);
    SubUserTradableMarketResult tradableMarketResult = subUserClient.subuserTradableMarket(tradableMarketRequest);
    if (tradableMarketResult != null) {
      for (SubUserTradableMarketState marketState : tradableMarketResult.getList()) {
        System.out.println("tradable market State:  "
            + "subUid:" + marketState.getSubUid()
            + "  accountType:" + marketState.getAccountType()
            + "   activation: " + marketState.getActivation());
      }
    }

    String googleAuthKey = "";
    String optToken = GoogleAuthHelper.getVercodeTime(googleAuthKey) + "";
    String permission = SubUserApiKeyPermissionEnums.READ_ONLY.getPermission() + "," + SubUserApiKeyPermissionEnums.TRADE.getPermission();
    SubUserApiKeyGenerationRequest apiKeyGenerationRequest = new SubUserApiKeyGenerationRequest();
    apiKeyGenerationRequest.setOtpToken(optToken);
    apiKeyGenerationRequest.setSubUid(subUid);
    apiKeyGenerationRequest.setNote("test_2");
    apiKeyGenerationRequest.setPermission(permission);
    apiKeyGenerationRequest.setIpAddresses("");

    SubUserApiKeyGenerationResult apiKeyGenerationResult = subUserClient.subuserApiKeyGeneration(apiKeyGenerationRequest);
    if (apiKeyGenerationResult != null) {
      System.out.println("api key generation ::" + JSON.toJSONString(apiKeyGenerationResult));
    }

    GetApiKeyListResult getApiKeyListResult = subUserClient.getApiKeyList(GetApiKeyListRequest.builder()
        .uid(subUid)
        .build());
    getApiKeyListResult.getList().forEach(info->{
      System.out.println(info);
    });

    String newApiKey = apiKeyGenerationResult.getAccessKey();

    // modify sub user api key
    SubUserApiKeyModificationRequest apiKeyModificationRequest = new SubUserApiKeyModificationRequest();
    apiKeyModificationRequest.setSubUid(subUid);
    apiKeyModificationRequest.setAccessKey(newApiKey);
    apiKeyModificationRequest.setNote("test_m_2");
    apiKeyModificationRequest.setPermission(SubUserApiKeyPermissionEnums.READ_ONLY.getPermission());
    apiKeyModificationRequest.setIpAddresses("127.0.0.2");

    SubUserApiKeyModificationResult apiKeyModificationResult = subUserClient.subuserApiKeyModification(apiKeyModificationRequest);
    if (apiKeyModificationResult != null) {
      System.out.println("api key modification ::" + JSON.toJSONString(apiKeyModificationResult));
    }

    getApiKeyListResult = subUserClient.getApiKeyList(GetApiKeyListRequest.builder()
        .uid(subUid)
        .accessKey(newApiKey)
        .build());
    getApiKeyListResult.getList().forEach(info -> {
      System.out.println(info);
    });

    subUserClient.subuserApiKeyDeletion(SubUserApiKeyDeletionRequest.builder()
        .subUid(subUid)
        .accessKey(newApiKey)
        .build());

    List<DepositAddress> addressList = subUserClient.getSubUserDepositAddress(subUid,"usdt");
    addressList.forEach(depositAddress -> {
      System.out.println(depositAddress);
    });

    GetSubUserDepositResult getSubUserDepositResult = subUserClient.getSubUserDeposit(GetSubUserDepositRequest.builder()
        .subUid(subUid)
        .build());

    System.out.println("get subuser deposit nextId:" + getSubUserDepositResult.getNextId());
    getSubUserDepositResult.getList().forEach(deposit -> {
      System.out.println(deposit);
    });

  }

}
