package com.education.qqmovieproject.ui.main.movie;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.education.qqmovieproject.R;
import com.education.qqmovieproject.base.BaseFragment;
import com.education.qqmovieproject.config.UrlConfig;
import com.education.qqmovieproject.entity.MovieEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhonghang on 16/8/3.
 */

public class MovieFragment extends BaseFragment implements MovieContract.View {

    @BindView(R.id.recycler_movie)
    RecyclerView recyclerMovie;
    private MovieAdapter movieAdapter;
    private List<MovieEntity> list;
    private LinearLayoutManager layoutManager;
    private MovieContract.Presenter presenter;
    private MovieContract.Model model;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_movie, container, false);
        ButterKnife.bind(this, fragmentView);

        initView();
        model = new MovieModel();
        presenter = new MoviePresenter(this, model);
        presenter.initData(initParams());
        return fragmentView;
    }

    public HashMap<String, String> initParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UrlConfig.Key.API_VER, "11");
        params.put(UrlConfig.Key.APP_ID, "2");
        params.put(UrlConfig.Key.CHANNEL, "lede");
        params.put(UrlConfig.Key.CITY, "110000");
        params.put(UrlConfig.Key.DEVICE_ID, "C1985DD9-0125-4AB5-B66B-B91A85824BBA");
        params.put(UrlConfig.Key.MOBILE_TYPE, "iPhone");
        params.put(UrlConfig.Key.VER, "2.5");
        return params;
    }

    private void initView() {
        list = new ArrayList<>();
        movieAdapter = new MovieAdapter(R.layout.item_movie, list);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerMovie.setLayoutManager(layoutManager);
        recyclerMovie.setAdapter(movieAdapter);
    }


    @Override
    public void onSuccessGetMovie(final List<MovieEntity> movieEntities) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                list.addAll(movieEntities);
                movieAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onFailGetMovie(String msg) {
        Toast.makeText(getContext(), "" + msg, Toast.LENGTH_SHORT).show();

    }
}
