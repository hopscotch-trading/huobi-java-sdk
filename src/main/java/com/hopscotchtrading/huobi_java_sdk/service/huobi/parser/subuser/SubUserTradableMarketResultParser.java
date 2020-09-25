package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.subuser.SubUserTradableMarketResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class SubUserTradableMarketResultParser implements HuobiModelParser<SubUserTradableMarketResult> {

    @Override
    public SubUserTradableMarketResult parse(JSONObject json) {
        return SubUserTradableMarketResult.builder()
                .list(new SubUserTradableMarketStateParser().parseArray(json.getJSONArray("data"))).build();
    }

    @Override
    public SubUserTradableMarketResult parse(JSONArray json) {
        return null;
    }

    @Override
    public List<SubUserTradableMarketResult> parseArray(JSONArray jsonArray) {
        return null;
    }
}
