package com.hopscotchtrading.huobi_java_sdk.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradableMarketActivationEnums {

    ACTIVATED("activated"), DEACTIVATED("deactivated"),;

    private final String activation;

}
