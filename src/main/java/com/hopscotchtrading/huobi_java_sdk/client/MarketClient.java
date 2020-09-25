package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.utils.ResponseCallback;
import com.hopscotchtrading.huobi_java_sdk.utils.WebSocketConnection;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.CandlestickRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.MarketDepthRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.MarketDetailMergedRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.MarketDetailRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.MarketHistoryTradeRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.MarketTradeRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.ReqCandlestickRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.ReqMarketDepthRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.ReqMarketDetailRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.ReqMarketTradeRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubCandlestickRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMarketBBORequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMarketDepthRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMarketDetailRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMarketTradeRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMbpIncrementalUpdateRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.market.SubMbpRefreshUpdateRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.Options;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;
import com.hopscotchtrading.huobi_java_sdk.exception.SDKException;
import com.hopscotchtrading.huobi_java_sdk.model.market.Candlestick;
import com.hopscotchtrading.huobi_java_sdk.model.market.CandlestickEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.CandlestickReq;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketBBOEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDepth;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDepthEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDepthReq;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetail;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetailEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetailMerged;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetailReq;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTicker;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTrade;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTradeEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTradeReq;
import com.hopscotchtrading.huobi_java_sdk.model.market.MbpIncrementalUpdateEvent;
import com.hopscotchtrading.huobi_java_sdk.model.market.MbpRefreshUpdateEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.HuobiMarketService;

public interface MarketClient {

  List<Candlestick> getCandlestick(CandlestickRequest request);

  MarketDetailMerged getMarketDetailMerged(MarketDetailMergedRequest request);

  MarketDetail getMarketDetail(MarketDetailRequest request);

  List<MarketTicker> getTickers();

  MarketDepth getMarketDepth(MarketDepthRequest request);

  List<MarketTrade> getMarketTrade(MarketTradeRequest request);

  List<MarketTrade> getMarketHistoryTrade(MarketHistoryTradeRequest request);

  void subCandlestick(SubCandlestickRequest request, ResponseCallback<CandlestickEvent> callback);

  void subMarketDetail(SubMarketDetailRequest request, ResponseCallback<MarketDetailEvent> callback);

  void subMarketDepth(SubMarketDepthRequest request, ResponseCallback<MarketDepthEvent> callback);

  void subMarketTrade(SubMarketTradeRequest request, ResponseCallback<MarketTradeEvent> callback);

  void subMarketBBO(SubMarketBBORequest request, ResponseCallback<MarketBBOEvent> callback);

  void subMbpRefreshUpdate(SubMbpRefreshUpdateRequest request, ResponseCallback<MbpRefreshUpdateEvent> callback);

  WebSocketConnection subMbpIncrementalUpdate(SubMbpIncrementalUpdateRequest request, ResponseCallback<MbpIncrementalUpdateEvent> callback);

  WebSocketConnection reqMbpIncrementalUpdate(SubMbpIncrementalUpdateRequest request, WebSocketConnection connection);

  void reqCandlestick(ReqCandlestickRequest request, ResponseCallback<CandlestickReq> callback);

  void reqMarketDepth(ReqMarketDepthRequest request, ResponseCallback<MarketDepthReq> callback);

  void reqMarketTrade(ReqMarketTradeRequest request, ResponseCallback<MarketTradeReq> callback);

  void reqMarketDetail(ReqMarketDetailRequest request, ResponseCallback<MarketDetailReq> callback);

  static MarketClient create(Options options) {

    if (options.getExchange().equals(ExchangeEnum.HUOBI)) {
      return new HuobiMarketService(options);
    }
    throw new SDKException(SDKException.INPUT_ERROR, "Unsupport Exchange.");
  }


}
