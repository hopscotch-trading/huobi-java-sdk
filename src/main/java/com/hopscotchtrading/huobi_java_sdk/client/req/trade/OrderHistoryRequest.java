package com.hopscotchtrading.huobi_java_sdk.client.req.trade;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.QueryDirectionEnum;
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
public class OrderHistoryRequest {

  private String symbol;

  private Long startTime;

  private Long endTime;

  private QueryDirectionEnum direction;

  private Integer size;

}
