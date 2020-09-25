package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.utils.ResponseCallback;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.BatchCancelOpenOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.CreateOrderRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.FeeRateRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.MatchResultRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.OpenOrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.OrderHistoryRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.OrdersRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.SubOrderUpdateV2Request;
import com.hopscotchtrading.huobi_java_sdk.client.req.trade.SubTradeClearingRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.trade.BatchCancelOpenOrdersResult;
import com.hopscotchtrading.huobi_java_sdk.model.trade.BatchCancelOrderResult;
import com.hopscotchtrading.huobi_java_sdk.model.trade.FeeRate;
import com.hopscotchtrading.huobi_java_sdk.model.trade.MatchResult;
import com.hopscotchtrading.huobi_java_sdk.model.trade.Order;
import com.hopscotchtrading.huobi_java_sdk.model.trade.OrderUpdateV2Event;
import com.hopscotchtrading.huobi_java_sdk.model.trade.TradeClearingEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiTradeService;

public interface TradeClient {

    Long createOrder(CreateOrderRequest request);

    Long cancelOrder(Long orderId);

    Integer cancelOrder(String clientOrderId);

    BatchCancelOpenOrdersResult batchCancelOpenOrders(BatchCancelOpenOrdersRequest request);

    BatchCancelOrderResult batchCancelOrder(List<Long> ids);

    List<Order> getOpenOrders(OpenOrdersRequest request);

    Order getOrder(Long orderId);

    Order getOrder(String clientOrderId);

    List<Order> getOrders(OrdersRequest request);

    List<Order> getOrdersHistory(OrderHistoryRequest request);

    List<MatchResult> getMatchResult(Long orderId);

    List<MatchResult> getMatchResults(MatchResultRequest request);

    List<FeeRate> getFeeRate(FeeRateRequest request);

    void subOrderUpdateV2(SubOrderUpdateV2Request request, ResponseCallback<OrderUpdateV2Event> callback);

    void subTradeClearing(SubTradeClearingRequest request, ResponseCallback<TradeClearingEvent> callback);

    static TradeClient create(Options options) {

        if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
            return new HuobiTradeService(options);
        }
        throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
    }

}
