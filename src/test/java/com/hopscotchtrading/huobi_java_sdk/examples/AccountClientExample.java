package com.hopscotchtrading.huobi_java_sdk.examples;

import java.math.BigDecimal;
import java.util.List;

import com.hopscotchtrading.huobi_java_sdk.client.AccountClient;
import com.hopscotchtrading.huobi_java_sdk.Constants;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountAssetValuationRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountBalanceRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountFuturesTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountHistoryRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountLedgerRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.AccountTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.PointRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.PointTransferRequest;
import com.hopscotchtrading.huobi_java_sdk.client.req.account.SubAccountUpdateRequest;
import com.hopscotchtrading.huobi_java_sdk.constant.HuobiOptions;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountFuturesTransferTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountTransferAccountTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountTypeEnum;
import com.hopscotchtrading.huobi_java_sdk.constant.enums.AccountUpdateModeEnum;
import com.hopscotchtrading.huobi_java_sdk.model.account.Account;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountAssetValuationResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountBalance;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountFuturesTransferResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountHistory;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountLedgerResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.AccountTransferResult;
import com.hopscotchtrading.huobi_java_sdk.model.account.Point;
import com.hopscotchtrading.huobi_java_sdk.model.account.PointTransferResult;

public class AccountClientExample {

  public static void main(String[] args) {

    Long accountId = 123L;
    AccountClient accountService = AccountClient.create(HuobiOptions.builder()
        .apiKey(Constants.API_KEY)
        .secretKey(Constants.SECRET_KEY)
        .build());

    List<Account> accountList = accountService.getAccounts();
    accountList.forEach(account -> {
      System.out.println(account.toString());
    });


    AccountBalance accountBalance = accountService.getAccountBalance(AccountBalanceRequest.builder()
        .accountId(accountId)
        .build());

    System.out.println(accountBalance.getId());
    System.out.println(accountBalance.getType());
    System.out.println(accountBalance.getState());
    accountBalance.getList().forEach(balance -> {
      System.out.println(balance.toString());
    });

    List<AccountHistory> historyList = accountService.getAccountHistory(AccountHistoryRequest.builder().accountId(accountId).build());
    historyList.forEach(history->{
      System.out.println(history);
    });

    AccountLedgerResult accountLedgerResult = accountService.getAccountLedger(AccountLedgerRequest.builder()
        .accountId(accountId)
        .limit(2)
        .build());
    System.out.println("leger nextId: " + accountLedgerResult.getNextId());
    accountLedgerResult.getLedgerList().forEach(ledger -> {
      System.out.println(ledger);
    });


    accountService.subAccountsUpdate(SubAccountUpdateRequest.builder()
        .accountUpdateMode(AccountUpdateModeEnum.ACCOUNT_CHANGE).build(), event -> {
      System.out.println(event.toString());
    });


    AccountTransferResult accountTransferResult = accountService.accountTransfer(AccountTransferRequest.builder()
        .fromUser(123L)
        .fromAccount(456L)
        .fromAccountType(AccountTransferAccountTypeEnum.SPOT)
        .toUser(678L)
        .toAccount(789L)
        .toAccountType(AccountTransferAccountTypeEnum.MARGIN)
        .currency("usdt")
        .amount(new BigDecimal("10"))
        .build());

    System.out.println("account transfer result:"+accountTransferResult.toString());

    AccountFuturesTransferResult accountFuturesTransferResult = accountService.accountFuturesTransfer(AccountFuturesTransferRequest.builder()
        .currency("xrp")
        .amount(new BigDecimal("5"))
        .type(AccountFuturesTransferTypeEnum.PRO_TO_FUTURES)
        .build());

    System.out.println("account futures result:"+accountFuturesTransferResult.toString());

    Point point = accountService.getPoint(PointRequest.builder().build());
    System.out.println("get point: " + point);


    PointTransferResult pointTransferResult = accountService.pointTransfer(PointTransferRequest.builder()
      .fromUid(123L)
      .toUid(123L)
      .groupId(123L)
      .amount(BigDecimal.ONE)
      .build());
    System.out.println(pointTransferResult);

    AccountAssetValuationResult accountAssetValuationResult = accountService.accountAssetValuation(AccountAssetValuationRequest.builder().accountType(AccountTypeEnum.SPOT).build());
    System.out.println(accountAssetValuationResult);
  }

}
