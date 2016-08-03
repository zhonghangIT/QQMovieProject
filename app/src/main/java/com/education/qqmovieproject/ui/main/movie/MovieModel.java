package com.education.qqmovieproject.ui.main.movie;

import com.education.qqmovieproject.entity.HotShowEntity;
import com.education.qqmovieproject.httputils.HttpUtils;
import com.education.qqmovieproject.httputils.MovieService;
import com.education.qqmovieproject.httputils.RetrofitHelper;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zhonghang on 16/8/3.
 */

public class MovieModel implements MovieContract.Model {
    @Override
    public void getMovie(HashMap<String, String> params, HttpUtils.HttpCallBack<HotShowEntity> callBack) {
        HttpUtils.getInstance().getMovieData(params,callBack);
    }
}
