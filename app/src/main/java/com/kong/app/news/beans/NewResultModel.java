package com.kong.app.news.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by whiskeyfei on 16-1-27.
 */
public class NewResultModel implements Serializable {

    @SerializedName("code")
    public int resultCode;

    @SerializedName("msg")
    public String resultMsg;

    @SerializedName("newslist")
    public List<NewModel> newModellist;

    @Override
    public String toString() {
        return "NewResultModel{" +
                "resultCode=" + resultCode +
                ", resultMsg='" + resultMsg + '\'' +
                ", newModellist=" + newModellist +
                '}';
    }
}
