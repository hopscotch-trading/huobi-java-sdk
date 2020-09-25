package com.hopscotchtrading.huobi_java_sdk.client.req.market;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.CandlestickIntervalEnum;
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
public class CandlestickRequest {

  private String symbol;

  private CandlestickIntervalEnum interval;

  private Integer size;

}
