package com.education.qqmovieproject.ui.main.movie;

import com.education.qqmovieproject.entity.HotShowEntity;
import com.education.qqmovieproject.entity.MovieEntity;
import com.education.qqmovieproject.httputils.HttpUtils;
import com.education.qqmovieproject.mvp.IBaseModel;
import com.education.qqmovieproject.mvp.IBasePresenter;
import com.education.qqmovieproject.mvp.IBaseView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhonghang on 16/8/3.
 */

public class MovieContract {

    public interface View extends IBaseView {
        public void onSuccessGetMovie(List<MovieEntity> movieEntities);

        public void onFailGetMovie(String msg);
    }

    public interface Model extends IBaseModel {
        public void getMovie(HashMap<String, String> params, HttpUtils.HttpCallBack<HotShowEntity> callBack);
    }

    public interface Presenter extends IBasePresenter {
        public void initData(HashMap<String, String> params);
    }
}
