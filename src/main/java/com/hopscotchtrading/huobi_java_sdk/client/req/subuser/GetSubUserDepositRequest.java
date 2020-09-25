package com.hopscotchtrading.huobi_java_sdk.client.req.subuser;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.QuerySortEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSubUserDepositRequest {

  private Long subUid;

  private String currency;

  private Long startTime;

  private Long endTime;

  private QuerySortEnum sort;

  private Integer limit;

  private Long fromId;

}
