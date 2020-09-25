package com.hopscotchtrading.huobi_java_sdk.client.req.subuser;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.TradableMarketAccountTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.TradableMarketActivationEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserTradableMarketRequest {

    private String subUids;

    private TradableMarketAccountTypeEnum accountType;

    private TradableMarketActivationEnums activation;

}
