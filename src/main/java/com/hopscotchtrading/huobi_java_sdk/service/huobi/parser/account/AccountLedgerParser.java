package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.account.AccountLedger;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class AccountLedgerParser implements HuobiModelParser<AccountLedger> {

    @Override
    public AccountLedger parse(JSONObject json) {
        return null;
    }

    @Override
    public AccountLedger parse(JSONArray json) {
        return null;
    }

    @Override
    public List<AccountLedger> parseArray(JSONArray jsonArray) {
        return jsonArray.toJavaList(AccountLedger.class);
    }
}
