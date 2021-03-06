package com.example.taskmanager.network.apis;

import android.util.Log;

import com.example.taskmanager.network.model.BaseHttpModel;
import com.example.taskmanager.network.services.HttpUtil;
import com.example.taskmanager.network.services.Url;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 76952 on 2018/12/4.
 */

public class ChangeUserName {
    public static BaseHttpModel changeUserName(String account, String newName){
        JSONObject params = new JSONObject();
        try{
            params = new JSONObject()
                    .put("account", account)
                    .put("newName", newName);
        } catch (JSONException e){
            e.printStackTrace();
        }
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, params.toString());

        String json = HttpUtil.post(Url.changeUserName, body);
        Log.i("json", json);
        return new Gson().fromJson(json, BaseHttpModel.class);
    }
}
