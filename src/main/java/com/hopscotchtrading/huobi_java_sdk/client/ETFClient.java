package com.hopscotchtrading.huobi_java_sdk.client;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.req.etf.ETFSwapListRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.etf.ETFSwapRequest;
import com.hopscotchtrading.huobi_java_sdk.model.etf.ETFConfig;
import com.hopscotchtrading.huobi_java_sdk.model.etf.ETFSwapRecord;

public interface ETFClient {

  ETFConfig getConfig(String etfName);

  void etfSwap(ETFSwapRequest request);

  List<ETFSwapRecord> getEtfSwapList(ETFSwapListRequest request);

}
