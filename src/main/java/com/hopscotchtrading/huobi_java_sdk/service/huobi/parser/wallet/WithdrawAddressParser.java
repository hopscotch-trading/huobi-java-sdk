package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.wallet.WithdrawAddress;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class WithdrawAddressParser implements HuobiModelParser<WithdrawAddress> {

    @Override
    public WithdrawAddress parse(JSONObject json) {
        return null;
    }

    @Override
    public WithdrawAddress parse(JSONArray json) {
        return null;
    }

    @Override
    public List<WithdrawAddress> parseArray(JSONArray jsonArray) {
        return jsonArray.toJavaList(WithdrawAddress.class);
    }
}
