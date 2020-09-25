package com.hopscotchtrading.huobi_java_sdk.client.req.account;

import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountHistoryTransactTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.QuerySortEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountHistoryRequest {

    private Long accountId;

    private String currency;

    private List<AccountHistoryTransactTypeEnum> types;

    private Long startTime;

    private Long endTime;

    private QuerySortEnum sort;

    private Integer size;

    public String getTypesString() {
        String typeString = null;
        if (this.getTypes() != null && this.getTypes().size() > 0) {
            typeString = StringUtils.join(types, ",");
        }
        return typeString;
    }

}
