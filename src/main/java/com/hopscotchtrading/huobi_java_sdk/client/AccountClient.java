package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.utils.ResponseCallback;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountAssetValuationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountBalanceRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountFuturesTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountHistoryRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountLedgerRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.PointRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.PointTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.SubAccountUpdateRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.account.Account;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountAssetValuationResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountBalance;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountFuturesTransferResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountHistory;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountLedgerResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountTransferResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountUpdateEvent;
import com.hopscotchtrading.huobi_java_sdk.model.account.Point;
import com.hopscotchtrading.huobi_java_sdk.model.account.PointTransferResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiAccountService;

public interface AccountClient {

    /**
     * Get User Account List
     * 
     * @return
     */
    List<Account> getAccounts();

    /**
     * Get User Account Balance
     * 
     * @param request
     * 
     * @return
     */
    AccountBalance getAccountBalance(AccountBalanceRequest request);

    List<AccountHistory> getAccountHistory(AccountHistoryRequest request);

    AccountLedgerResult getAccountLedger(AccountLedgerRequest request);

    AccountTransferResult accountTransfer(AccountTransferRequest request);

    AccountFuturesTransferResult accountFuturesTransfer(AccountFuturesTransferRequest request);

    Point getPoint(PointRequest request);

    PointTransferResult pointTransfer(PointTransferRequest request);

    AccountAssetValuationResult accountAssetValuation(AccountAssetValuationRequest request);

    void subAccountsUpdate(SubAccountUpdateRequest request, ResponseCallback<AccountUpdateEvent> callback);

    static AccountClient create(Options options) {

        if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
            return new HuobiAccountService(options);
        }
        throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
    }
}
