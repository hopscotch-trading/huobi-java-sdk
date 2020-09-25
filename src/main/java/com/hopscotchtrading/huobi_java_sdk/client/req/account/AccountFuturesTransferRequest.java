package com.hopscotchtrading.huobi_java_sdk.client.req.account;

import java.math.BigDecimal;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountFuturesTransferTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountFuturesTransferRequest {

  private String currency;

  private BigDecimal amount;

  private AccountFuturesTransferTypeEnum type;
}
