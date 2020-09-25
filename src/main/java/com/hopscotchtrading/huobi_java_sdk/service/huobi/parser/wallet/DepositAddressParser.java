package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.wallet;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.wallet.DepositAddress;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class DepositAddressParser implements HuobiModelParser<DepositAddress> {

    @Override
    public DepositAddress parse(JSONObject json) {
        return json.toJavaObject(DepositAddress.class);
    }

    @Override
    public DepositAddress parse(JSONArray json) {
        return null;
    }

    @Override
    public List<DepositAddress> parseArray(JSONArray jsonArray) {
        return jsonArray.toJavaList(DepositAddress.class);
    }
}
