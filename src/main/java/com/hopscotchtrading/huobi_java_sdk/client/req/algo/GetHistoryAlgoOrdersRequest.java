package com.hopscotchtrading.huobi_java_sdk.client.req.algo;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.QuerySortEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderSideEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderStatusEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetHistoryAlgoOrdersRequest {

  private Long accountId;

  private String symbol;

  private AlgoOrderSideEnum orderSide;

  private AlgoOrderTypeEnum orderType;

  private AlgoOrderStatusEnum orderStatus;

  private Long startTime;

  private Long endTime;

  private QuerySortEnum sort;

  private Integer limit;

  private Long fromId;


}
