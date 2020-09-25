package com.hopscotchtrading.huobi_java_sdk.client.req.algo;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.QuerySortEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderSideEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOpenAlgoOrdersRequest {

  private Long accountId;

  private String symbol;

  private AlgoOrderSideEnum orderSide;

  private AlgoOrderTypeEnum orderType;

  private QuerySortEnum sort;

  private Integer limit;

  private Long fromId;


}
