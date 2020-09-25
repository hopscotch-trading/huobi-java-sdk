package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.model.isolatedmargin.IsolatedMarginAccount;
import com.hopscotchtrading.huobi_java_sdk.model.isolatedmargin.IsolatedMarginLoadOrder;
import com.hopscotchtrading.huobi_java_sdk.model.isolatedmargin.IsolatedMarginSymbolInfo;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginAccountRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginApplyLoanRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginLoanInfoRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginLoanOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginRepayLoanRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.margin.IsolatedMarginTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiIsolatedMarginService;

public interface IsolatedMarginClient {

  Long transfer(IsolatedMarginTransferRequest request);

  Long applyLoan(IsolatedMarginApplyLoanRequest request);

  Long repayLoan(IsolatedMarginRepayLoanRequest request);

  List<IsolatedMarginLoadOrder> getLoanOrders(IsolatedMarginLoanOrdersRequest request);

  List<IsolatedMarginAccount> getLoanBalance(IsolatedMarginAccountRequest request);

  List<IsolatedMarginSymbolInfo> getLoanInfo(IsolatedMarginLoanInfoRequest request);

  static IsolatedMarginClient create(Options options) {

    if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
      return new HuobiIsolatedMarginService(options);
    }
    throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
  }
}
