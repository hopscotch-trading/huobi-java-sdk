package com.hopscotchtrading.huobi_java_sdk.client.req.trade;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.OrderSideEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.QueryDirectionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenOrdersRequest {

  private  String symbol;

  private Long accountId;

  private Integer size;

  private OrderSideEnum side;

  private QueryDirectionEnum direct;

  private Long from;

}
