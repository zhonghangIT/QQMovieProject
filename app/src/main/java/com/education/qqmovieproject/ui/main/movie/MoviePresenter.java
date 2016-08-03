package com.education.qqmovieproject.ui.main.movie;

import com.education.qqmovieproject.entity.HotShowEntity;
import com.education.qqmovieproject.httputils.HttpUtils;
import com.education.qqmovieproject.ui.main.MainContract;

import java.util.HashMap;

/**
 * Created by zhonghang on 16/8/3.
 */

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View view;
    private MovieContract.Model model;

    public MoviePresenter(MovieContract.View view, MovieContract.Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void initData(HashMap<String, String> params) {

        model.getMovie(params, new HttpUtils.HttpCallBack<HotShowEntity>() {
            @Override
            public void onSucess(HotShowEntity hotShowEntity) {
                view.onSuccessGetMovie(hotShowEntity.getList());
            }

            @Override
            public void onFail() {
                view.onFailGetMovie("网络连接错误");
            }
        });
    }
}
