package com.hopscotchtrading.huobi_java_sdk.client.req.subuser;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.SubUserManagementActionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserManagementRequest {

    private Long subUid;

    private SubUserManagementActionEnum action;

}
