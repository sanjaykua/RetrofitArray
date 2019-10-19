package com.example.retrofitarray;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.retrofitarray.databinding.ActivityMainBinding;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("action","get_all_apps");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://androindian.com/apps/my_apps/").addConverterFactory(GsonConverterFactory.create()).build();

        ListInterface listInterface=retrofit.create(ListInterface.class);

        JsonObject object=new JsonParser().parse(jsonObject.toString()).getAsJsonObject();

        Call<ListResponse> listResponseCall=listInterface.loadData(object);

        listResponseCall.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                String res=response.body().getResponse();

                if (res.equalsIgnoreCase("success")){
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL,false);
                    binding.rec.setLayoutManager(linearLayoutManager);
                    binding.rec.setAdapter(new Recycleadp(MainActivity.this,response.body().getData()));
                }else {
                    binding.tv.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {

            }
        });
    }
}
