package com.hopscotchtrading.huobi_java_sdk.client.req.account;


import java.math.BigDecimal;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.TransferMasterTypeEnum;
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
public class TransferSubuserRequest {

  private Long subUid;

  private String currency;

  private BigDecimal amount;

  private TransferMasterTypeEnum type;

}
