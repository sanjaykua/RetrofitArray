package com.example.retrofitarray;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("results")
    @Expose
    private Integer results;
    @SerializedName("data")
    @Expose
    private List<ListResArray> data = null;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<ListResArray> getData() {
        return data;
    }

    public void setData(List<ListResArray> data) {
        this.data = data;
    }

}
