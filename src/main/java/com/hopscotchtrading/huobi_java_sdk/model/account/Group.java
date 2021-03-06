package com.hopscotchtrading.huobi_java_sdk.model.account;

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
public class Group {

    Long groupId;

    Long expiryDate;

    String remainAmt;

}
