package com.hopscotchtrading.huobi_java_sdk.model.subuser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserManagementResult {

    private Long subUid;

    private String userState;

}
