package com.example.retrofitarray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListResArray {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("app_name")
    @Expose
    private String appName;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("url")
    @Expose
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
