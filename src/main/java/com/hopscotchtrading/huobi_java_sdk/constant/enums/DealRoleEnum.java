package com.hopscotchtrading.huobi_java_sdk.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DealRoleEnum {

  /**
   * TAKER,MAKER
   */

  TAKER("taker"),
  MAKER("maker")
  ;

  private final String role;

  public static DealRoleEnum find(String role) {
    for (DealRoleEnum fr : DealRoleEnum.values()) {
      if (fr.getRole().equals(role)) {
        return fr;
      }
    }
    return null;
  }
}
