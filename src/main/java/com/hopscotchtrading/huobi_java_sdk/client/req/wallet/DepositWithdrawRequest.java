package com.hopscotchtrading.huobi_java_sdk.client.req.wallet;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepositWithdrawTypeEnum;
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
public class DepositWithdrawRequest {

  private DepositWithdrawTypeEnum type;

  private String currency;

  private Long from;

  private Integer size;

  private QueryDirectionEnum direction;

}
