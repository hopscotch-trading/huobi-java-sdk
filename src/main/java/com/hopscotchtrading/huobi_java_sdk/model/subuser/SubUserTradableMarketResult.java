package com.hopscotchtrading.huobi_java_sdk.model.subuser;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserTradableMarketResult {

    private List<SubUserTradableMarketState> list;

}
