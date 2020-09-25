package com.hopscotchtrading.huobi_java_sdk.client;

import com.hopscotchtrading.huobi_java_sdk.client.req.algo.CancelAlgoOrderRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.algo.CreateAlgoOrderRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.algo.GetHistoryAlgoOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.algo.GetOpenAlgoOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.algo.AlgoOrder;
import com.hopscotchtrading.huobi_java_sdk.model.algo.CancelAlgoOrderResult;
import com.hopscotchtrading.huobi_java_sdk.model.algo.CreateAlgoOrderResult;
import com.hopscotchtrading.huobi_java_sdk.model.algo.GetHistoryAlgoOrdersResult;
import com.hopscotchtrading.huobi_java_sdk.model.algo.GetOpenAlgoOrdersResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiAlgoService;

public interface AlgoClient {

  CreateAlgoOrderResult createAlgoOrder(CreateAlgoOrderRequest request);

  CancelAlgoOrderResult cancelAlgoOrder(CancelAlgoOrderRequest request);

  GetOpenAlgoOrdersResult getOpenAlgoOrders(GetOpenAlgoOrdersRequest request);

  GetHistoryAlgoOrdersResult getHistoryAlgoOrders(GetHistoryAlgoOrdersRequest request);

  AlgoOrder getAlgoOrdersSpecific(String clientOrderId);


  static AlgoClient create(Options options) {

    if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
      return new HuobiAlgoService(options);
    }
    throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
  }
}
