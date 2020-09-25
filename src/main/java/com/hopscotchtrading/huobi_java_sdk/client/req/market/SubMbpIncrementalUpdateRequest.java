package com.hopscotchtrading.huobi_java_sdk.client.req.market;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.DepthLevels;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubMbpIncrementalUpdateRequest {

    private String symbol;

    private DepthLevels levels;

}
