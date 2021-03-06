package com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.hopscotchtrading.huobi_java_sdk.model.account.Point;
import com.hopscotchtrading.huobi_java_sdk.service.huobi.parser.HuobiModelParser;

public class PointParser implements HuobiModelParser<Point> {

    @Override
    public Point parse(JSONObject json) {
        return json.toJavaObject(Point.class);
    }

    @Override
    public Point parse(JSONArray json) {
        return null;
    }

    @Override
    public List<Point> parseArray(JSONArray jsonArray) {
        return null;
    }

}
