package com.hopscotchtrading.huobi_java_sdk.constant;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.ExchangeEnum;

public interface Options {

  String getApiKey();

  String getSecretKey();

  ExchangeEnum getExchange();

  String getRestHost();

  String getWebSocketHost();

  boolean isWebSocketAutoConnect();

}
