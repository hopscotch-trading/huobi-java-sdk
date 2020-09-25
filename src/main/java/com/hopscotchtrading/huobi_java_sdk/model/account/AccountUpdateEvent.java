package com.hopscotchtrading.huobi_java_sdk.model.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateEvent {

  private String action;

  private String topic;

  private AccountUpdate accountUpdate;

}