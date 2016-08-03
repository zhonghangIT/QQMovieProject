package com.education.qqmovieproject.ui.main.movie;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.education.qqmovieproject.R;
import com.education.qqmovieproject.entity.MovieEntity;

import java.util.List;

/**
 * Created by zhonghang on 16/8/3.
 */

public class MovieAdapter extends BaseQuickAdapter<MovieEntity> {
    public MovieAdapter(int layoutResId, List<MovieEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MovieEntity movieEntity) {
        baseViewHolder.setText(R.id.textview_movie_name, movieEntity.getName())
                .setText(R.id.textview_movie_content, movieEntity.getHighlight())
                .setText(R.id.textview_movie_actor, movieEntity.getActors());
        Glide.with(baseViewHolder.convertView.getContext())
                .load(movieEntity.getLogo())
                .into((ImageView) baseViewHolder.getView(R.id.imageview_movie));
    }
}
