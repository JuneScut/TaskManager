package com.example.taskmanager.network.apis;

import android.util.Log;

import com.example.taskmanager.network.model.BaseHttpModel;
import com.example.taskmanager.network.services.HttpUtil;
import com.example.taskmanager.network.services.Url;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 76952 on 2018/12/3.
 */

public class AddMenu {
    public static BaseHttpModel addMenu(String account, String menu){
        JSONObject params = new JSONObject();
        try{
            params = new JSONObject()
                    .put("account", account)
                    .put("menu", menu);
        } catch (JSONException e){
            e.printStackTrace();
        }
        Log.i("params----", params.toString());

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, params.toString());

        String json = HttpUtil.post(Url.createMenu, body);
        Log.i("json-----", json);
        return new Gson().fromJson(json, BaseHttpModel.class);
    }
}
