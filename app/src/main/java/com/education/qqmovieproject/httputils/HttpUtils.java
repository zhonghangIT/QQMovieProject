package com.education.qqmovieproject.httputils;

import android.util.Log;

import com.education.qqmovieproject.entity.HotShowEntity;
import com.education.qqmovieproject.entity.MovieEntity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpUtils {
    private static HttpUtils instance;

    private HttpUtils() {
    }

    public static synchronized HttpUtils getInstance() {
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }

    public interface HttpCallBack<T> {
        public void onSucess(T t);

        public void onFail();
    }

    public void getMovieData(HashMap<String, String> params, final HttpCallBack<HotShowEntity> entityHttpCallBack) {
        Call<HotShowEntity> hotShowEntityCall = RetrofitHelper
                .getInstance()
                .createRetrofitService(MovieService.class)
                .getHotShowMovie(params);
        hotShowEntityCall.enqueue(new Callback<HotShowEntity>() {
            @Override
            public void onResponse(Call<HotShowEntity> call, Response<HotShowEntity> response) {
                HotShowEntity entity = response.body();
                for (MovieEntity movieEntity : entity.getList()) {
                    Log.d("-----", "" + movieEntity.getName());
                }
                entityHttpCallBack.onSucess(response.body());
            }

            @Override
            public void onFailure(Call<HotShowEntity> call, Throwable t) {
                entityHttpCallBack.onFail();
            }
        });
    }


}
