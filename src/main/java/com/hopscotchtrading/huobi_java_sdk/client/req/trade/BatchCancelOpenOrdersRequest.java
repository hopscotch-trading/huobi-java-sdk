package com.hopscotchtrading.huobi_java_sdk.client.req.trade;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.OrderSideEnum;
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
public class BatchCancelOpenOrdersRequest {

  private Long accountId;

  private String symbol;

  private OrderSideEnum side;

  private Integer size;

}
