package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.algo;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.algo.CreateAlgoOrderResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class CreateAlgoOrderResultParser implements HuobiModelParser<CreateAlgoOrderResult> {

    @Override
    public CreateAlgoOrderResult parse(JSONObject json) {
        return CreateAlgoOrderResult.builder().clientOrderId(json.getString("clientOrderId")).build();
    }

    @Override
    public CreateAlgoOrderResult parse(JSONArray json) {
        return null;
    }

    @Override
    public List<CreateAlgoOrderResult> parseArray(JSONArray jsonArray) {
        return null;
    }
}
