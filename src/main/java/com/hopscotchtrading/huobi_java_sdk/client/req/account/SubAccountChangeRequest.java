package com.hopscotchtrading.huobi_java_sdk.client.req.account;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.BalanceModeEnum;
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
public class SubAccountChangeRequest {

    private BalanceModeEnum balanceMode;

}
