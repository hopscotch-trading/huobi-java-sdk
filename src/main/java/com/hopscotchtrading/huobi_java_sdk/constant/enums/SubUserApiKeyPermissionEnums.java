package com.hopscotchtrading.huobi_java_sdk.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubUserApiKeyPermissionEnums {

  READ_ONLY("readOnly"),
  TRADE("trade"),

  ;
  private final String permission;

}
