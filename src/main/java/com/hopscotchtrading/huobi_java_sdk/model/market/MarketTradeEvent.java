package com.hopscotchtrading.huobi_java_sdk.model.market;

import java.util.List;

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
public class MarketTradeEvent {

    private String ch;

    private Long ts;

    private List<MarketTrade> list;
}
