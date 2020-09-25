package com.hopscotchtrading.huobi_java_sdk.client.req.account;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountAssetValuationRequest {

  AccountTypeEnum accountType;

  String valuationCurrency;

  Long subUid;

}
