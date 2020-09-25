package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.account.PointTransferResult;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class PointTransferResultParser implements HuobiModelParser<PointTransferResult> {

    @Override
    public PointTransferResult parse(JSONObject json) {
        return json.toJavaObject(PointTransferResult.class);
    }

    @Override
    public PointTransferResult parse(JSONArray json) {
        return null;
    }

    @Override
    public List<PointTransferResult> parseArray(JSONArray jsonArray) {
        return null;
    }

}
