package com.hopscotchtrading.huobi_java_sdk.constant.enums.algo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlgoOrderSideEnum {

    BUY("buy"), SELL("sell"),

    ;

    private final String side;
}
