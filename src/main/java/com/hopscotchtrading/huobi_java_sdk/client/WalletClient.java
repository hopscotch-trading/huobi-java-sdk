package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.CreateWithdrawRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.DepositAddressRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.DepositWithdrawRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.WithdrawAddressRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.wallet.WithdrawQuotaRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositAddress;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositWithdraw;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.WithdrawAddressResult;
import com.hopscotchtrading.huobi_java_sdk.model.wallet.WithdrawQuota;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiWalletService;

public interface WalletClient {

    List<DepositAddress> getDepositAddress(DepositAddressRequest request);

    WithdrawQuota getWithdrawQuota(WithdrawQuotaRequest request);

    WithdrawAddressResult getWithdrawAddress(WithdrawAddressRequest request);

    Long createWithdraw(CreateWithdrawRequest request);

    Long cancelWithdraw(Long withdrawId);

    List<DepositWithdraw> getDepositWithdraw(DepositWithdrawRequest request);

    static WalletClient create(Options options) {

        if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
            return new HuobiWalletService(options);
        }
        throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
    }
}
