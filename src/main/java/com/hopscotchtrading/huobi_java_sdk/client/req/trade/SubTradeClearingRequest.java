package com.hopscotchtrading.huobi_java_sdk.client.req.trade;

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
public class SubTradeClearingRequest {

    private String symbols;

}
