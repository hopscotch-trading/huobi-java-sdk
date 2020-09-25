package com.hopscotchtrading.huobi_java_sdk.client.req.market;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthSizeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthStepEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MarketDepthRequest {

    private String symbol;

    private DepthSizeEnum depth;

    private DepthStepEnum step;

}
