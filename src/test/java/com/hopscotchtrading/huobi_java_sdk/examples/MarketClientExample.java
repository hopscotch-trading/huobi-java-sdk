package com.hopscotchtrading.huobi_java_sdk.examples;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.MarketClient;
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
import com.hopscotchtrading.huobi_java_sdk.constant.HuobiOptions;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.CandlestickIntervalEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthLevels;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthSizeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthStepEnum;
import com.hopscotchtrading.huobi_java_sdk.model.market.Candlestick;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDepth;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetail;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketDetailMerged;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTicker;
import com.hopscotchtrading.huobi_java_sdk.model.market.MarketTrade;

public class MarketClientExample {

  public static void main(String[] args) {

    MarketClient marketClient = MarketClient.create(new HuobiOptions());

    String symbol = "btcusdt";

    List<Candlestick> list = marketClient.getCandlestick(CandlestickRequest.builder()
        .symbol(symbol)
        .interval(CandlestickIntervalEnum.MIN15)
        .size(10)
        .build());

    list.forEach(candlestick -> {
      System.out.println(candlestick.toString());
    });

    MarketDetailMerged
            marketDetailMerged = marketClient.getMarketDetailMerged(MarketDetailMergedRequest.builder().symbol(symbol).build());
    System.out.println(marketDetailMerged.toString());

    List<MarketTicker> tickerList = marketClient.getTickers();
    tickerList.forEach(marketTicker -> {
      System.out.println(marketTicker.toString());
    });

    MarketDepth marketDepth = marketClient.getMarketDepth(MarketDepthRequest.builder()
        .symbol(symbol)
        .depth(DepthSizeEnum.SIZE_5)
        .step(DepthStepEnum.STEP0)
        .build());

    System.out.println(marketDepth.toString());

    marketDepth.getBids().forEach(priceLevel -> {
      System.out.println("bid: " + priceLevel);
    });
    System.out.println("----------------------------");
    marketDepth.getAsks().forEach(priceLevel -> {
      System.out.println("asks: " + priceLevel);
    });

    List<MarketTrade> marketTradeList = marketClient.getMarketTrade(MarketTradeRequest.builder().symbol(symbol).build());
    marketTradeList.forEach(marketTrade -> {
      System.out.println(marketTrade.toString());
    });

    List<MarketTrade> marketHistoryTradeList = marketClient.getMarketHistoryTrade(MarketHistoryTradeRequest.builder().symbol(symbol).build());
    marketHistoryTradeList.forEach(marketTrade -> {
      System.out.println(marketTrade.toString());
    });

    MarketDetail marketDetail = marketClient.getMarketDetail(MarketDetailRequest.builder().symbol(symbol).build());
    System.out.println(marketDetail.toString());

    marketClient.subCandlestick(SubCandlestickRequest.builder()
        .symbol(symbol)
        .interval(CandlestickIntervalEnum.MIN15)
        .build(), (candlestick) -> {

      System.out.println(candlestick.toString());
    });

    marketClient.subMarketDetail(SubMarketDetailRequest.builder().symbol(symbol).build(), (marketDetailEvent) -> {
      System.out.println(marketDetailEvent.toString());
    });

    marketClient.subMarketDepth(SubMarketDepthRequest.builder().symbol(symbol).build(), (marketDetailEvent) -> {
      System.out.println(marketDetailEvent.toString());
    });

    marketClient.subMarketTrade(SubMarketTradeRequest.builder().symbol(symbol).build(), (marketTradeEvent) -> {

      System.out.println("ch:" + marketTradeEvent.getCh());
      System.out.println("ts:" + marketTradeEvent.getTs());

      marketTradeEvent.getList().forEach(marketTrade -> {
        System.out.println(marketTrade.toString());
      });

      System.out.println("-----------------------------");
    });

    marketClient.subMarketBBO(SubMarketBBORequest.builder().symbol(symbol).build(), (marketBBOEvent) -> {
      System.out.println(marketBBOEvent.toString());
    });

    marketClient.reqCandlestick(ReqCandlestickRequest.builder()
        .symbol(symbol)
        .interval(CandlestickIntervalEnum.MIN15)
        .build(), candlestickReq -> {

      System.out.println(candlestickReq.toString());
      candlestickReq.getCandlestickList().forEach(candlestick -> {
        System.out.println("candlestick:" + candlestick.toString());
      });
    });

    marketClient.reqMarketDepth(ReqMarketDepthRequest.builder()
        .symbol(symbol)
        .step(DepthStepEnum.STEP0)
        .build(), marketDepthReq -> {

      System.out.println(marketDepthReq.toString());
    });

    marketClient.reqMarketTrade(ReqMarketTradeRequest.builder()
        .symbol(symbol)
        .build(), marketTradeReq -> {

      System.out.println(marketTradeReq.toString());
    });

    marketClient.reqMarketDetail(ReqMarketDetailRequest.builder()
        .symbol(symbol)
        .build(), marketDetailReq -> {

      System.out.println(marketDetailReq.toString());
    });

    marketClient.subMbpRefreshUpdate(SubMbpRefreshUpdateRequest.builder().symbols(symbol).levels(DepthLevels.LEVEL_5).build(), event -> {
      System.out.println(event.toString());
    });

    marketClient.subMbpIncrementalUpdate(SubMbpIncrementalUpdateRequest.builder().symbol(symbol).build(), event->{
      System.out.println(event.toString());
    });


  }


}
