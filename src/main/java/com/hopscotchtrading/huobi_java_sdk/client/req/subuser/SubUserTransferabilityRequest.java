package com.hopscotchtrading.huobi_java_sdk.client.req.subuser;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.TransferabilityAccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserTransferabilityRequest {

    private String subUids;

    private TransferabilityAccountTypeEnum accountType;

    private String transferrable;

}
