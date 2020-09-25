package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserApiKeyGenerationResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class SubUserApiKeyGenerationResultParser implements HuobiModelParser<SubUserApiKeyGenerationResult> {

    @Override
    public SubUserApiKeyGenerationResult parse(JSONObject json) {
        return json.toJavaObject(SubUserApiKeyGenerationResult.class);
    }

    @Override
    public SubUserApiKeyGenerationResult parse(JSONArray json) {
        return null;
    }

    @Override
    public List<SubUserApiKeyGenerationResult> parseArray(JSONArray jsonArray) {
        return null;
    }
}
