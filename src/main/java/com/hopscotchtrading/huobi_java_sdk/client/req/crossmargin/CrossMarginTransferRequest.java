package com.hopscotchtrading.huobi_java_sdk.client.req.crossmargin;

import java.math.BigDecimal;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.MarginTransferDirectionEnum;
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
public class CrossMarginTransferRequest {

  private MarginTransferDirectionEnum direction;

  private String currency;

  private BigDecimal amount;

}
