package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.subuser.GetSubUserDepositResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class GetSubUserDepositResultParser implements HuobiModelParser<GetSubUserDepositResult> {

    @Override
    public GetSubUserDepositResult parse(JSONObject json) {
        return GetSubUserDepositResult.builder().nextId(json.getLong("nextId"))
                .list(new SubUserDepositParser().parseArray(json.getJSONArray("data"))).build();
    }

    @Override
    public GetSubUserDepositResult parse(JSONArray json) {
        return null;
    }

    @Override
    public List<GetSubUserDepositResult> parseArray(JSONArray jsonArray) {
        return null;
    }
}
