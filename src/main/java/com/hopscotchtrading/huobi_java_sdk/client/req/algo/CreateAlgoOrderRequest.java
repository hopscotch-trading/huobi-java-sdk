package com.hopscotchtrading.huobi_java_sdk.client.req.algo;

import java.math.BigDecimal;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderSideEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderTimeInForceEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.algo.AlgoOrderTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAlgoOrderRequest {

  private String clientOrderId;

  private Long accountId;

  private String symbol;

  private AlgoOrderSideEnum orderSide;

  private AlgoOrderTypeEnum orderType;

  private AlgoOrderTimeInForceEnum timeInForce;

  private BigDecimal orderPrice;

  private BigDecimal orderSize;

  private BigDecimal orderValue;

  private BigDecimal stopPrice;

  private BigDecimal trailingRate;

}
