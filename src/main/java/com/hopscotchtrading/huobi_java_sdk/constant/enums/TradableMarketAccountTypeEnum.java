package com.hopscotchtrading.huobi_java_sdk.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradableMarketAccountTypeEnum {

    ISOLATED_MARGIN("isolated-margin"),

    CROSS_MARGIN("cross-margin"),;

    private final String accountType;

}
