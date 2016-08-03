package com.education.qqmovieproject.httputils;

import com.education.qqmovieproject.config.UrlConfig;
import com.education.qqmovieproject.entity.HotShowEntity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zhonghang on 16/8/3.
 * <p>
 * 使用retrofit连接网络的接口
 */

public interface MovieService {
    @GET(UrlConfig.Path.MOVIE_URL)
    Call<HotShowEntity> getHotShowMovie(@QueryMap() HashMap<String, String> params);
}
