package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.req.crossmargin.CrossMarginApplyLoanRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.crossmargin.CrossMarginLoanOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.crossmargin.CrossMarginRepayLoanRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.crossmargin.CrossMarginTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.crossmargin.CrossMarginAccount;
import com.hopscotchtrading.huobi_java_sdk.model.crossmargin.CrossMarginCurrencyInfo;
import com.hopscotchtrading.huobi_java_sdk.model.crossmargin.CrossMarginLoadOrder;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiCrossMarginService;

public interface CrossMarginClient {

    Long transfer(CrossMarginTransferRequest request);

    Long applyLoan(CrossMarginApplyLoanRequest request);

    void repayLoan(CrossMarginRepayLoanRequest request);

    List<CrossMarginLoadOrder> getLoanOrders(CrossMarginLoanOrdersRequest request);

    CrossMarginAccount getLoanBalance();

    List<CrossMarginCurrencyInfo> getLoanInfo();

    static CrossMarginClient create(Options options) {

        if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
            return new HuobiCrossMarginService(options);
        }
        throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
    }
}
