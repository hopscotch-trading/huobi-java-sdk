package com.hopscotchtrading.huobi_java_sdk.utils;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.ConnectionStateEnum;

public interface WebSocketConnection {

  ConnectionStateEnum getState();

  Long getConnectionId();

  void reConnect();

  void reConnect(int delayInSecond);

  long getLastReceivedTime();

  void send(String str);
}
