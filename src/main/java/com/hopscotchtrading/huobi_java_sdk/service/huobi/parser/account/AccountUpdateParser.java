package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.account.AccountUpdate;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class AccountUpdateParser implements HuobiModelParser<AccountUpdate> {

    @Override
    public AccountUpdate parse(JSONObject json) {
        AccountUpdate update = json.toJavaObject(AccountUpdate.class);
        return update;
    }

    @Override
    public AccountUpdate parse(JSONArray json) {
        return null;
    }

    @Override
    public List<AccountUpdate> parseArray(JSONArray jsonArray) {
        return null;
    }
}
