package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.account.AccountChangeEvent;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class AccountChangeEventParser implements HuobiModelParser<AccountChangeEvent> {

    @Override
    public AccountChangeEvent parse(JSONObject json) {

        JSONObject data = json.getJSONObject("data");

        return AccountChangeEvent.builder().event(data.getString("event"))
                .list(new AccountChangeParser().parseArray(data.getJSONArray("list"))).build();
    }

    @Override
    public AccountChangeEvent parse(JSONArray json) {
        return null;
    }

    @Override
    public List<AccountChangeEvent> parseArray(JSONArray jsonArray) {
        return null;
    }
}
