package com.education.qqmovieproject.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.education.qqmovieproject.R;
import com.education.qqmovieproject.base.BaseActivity;
import com.education.qqmovieproject.ui.main.discover.DiscoverFragment;
import com.education.qqmovieproject.ui.main.mine.MineFragment;
import com.education.qqmovieproject.ui.main.movie.MovieFragment;
import com.education.qqmovieproject.ui.main.show.ShowFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {
    @BindView(R.id.fragme_container)
    FrameLayout fragmeContainer;
    @BindView(R.id.imageview_main_bottom_movie)
    ImageView imageviewMainBottomMovie;
    @BindView(R.id.textview_main_bottom_movie)
    TextView textviewMainBottomMovie;
    @BindView(R.id.imageview_main_bottom_show)
    ImageView imageviewMainBottomShow;
    @BindView(R.id.textview_main_bottom_show)
    TextView textviewMainBottomShow;
    @BindView(R.id.imageview_main_bottom_discover)
    ImageView imageviewMainBottomDiscover;
    @BindView(R.id.textview_main_bottom_discover)
    TextView textviewMainBottomDiscover;
    @BindView(R.id.imageview_main_bottom_mine)
    ImageView imageviewMainBottomMine;
    @BindView(R.id.textview_main_bottom_mine)
    TextView textviewMainBottomMine;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.relativie_movie)
    RelativeLayout relativieMovie;
    @BindView(R.id.relativie_show)
    RelativeLayout relativieShow;
    @BindView(R.id.relativie_discover)
    RelativeLayout relativieDiscover;
    @BindView(R.id.relativie_mine)
    RelativeLayout relativieMine;
    private MovieFragment movieFragment;
    private ShowFragment showFragment;
    private MineFragment mineFragment;
    private DiscoverFragment discoverFragment;
    private FragmentManager fragmentManager;
    public static final int SELECTED_MOVIE = 0;
    public static final int SELECTED_SHOW = 1;
    public static final int SELECTED_DISCOVER = 2;
    public static final int SELECTED_MINE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        selectFragment(SELECTED_MOVIE);
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        movieFragment = new MovieFragment();
        showFragment = new ShowFragment();
        mineFragment = new MineFragment();
        discoverFragment = new DiscoverFragment();
        transaction.add(R.id.fragme_container, movieFragment);
        transaction.add(R.id.fragme_container, showFragment);
        transaction.add(R.id.fragme_container, mineFragment);
        transaction.add(R.id.fragme_container, discoverFragment);
        transaction.commit();
    }

    /**
     * 选中postion的fragment显示
     *
     * @param position
     */
    public void selectFragment(int position) {
        setBottonSelected();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(movieFragment).hide(showFragment).hide(mineFragment).hide(discoverFragment);
        switch (position) {
            case SELECTED_MOVIE:
                transaction.show(movieFragment);
                imageviewMainBottomMovie.setSelected(true);
                textviewMainBottomMovie.setSelected(true);
                break;
            case SELECTED_SHOW:
                transaction.show(showFragment);
                imageviewMainBottomShow.setSelected(true);
                textviewMainBottomShow.setSelected(true);
                break;
            case SELECTED_DISCOVER:
                transaction.show(discoverFragment);
                imageviewMainBottomDiscover.setSelected(true);
                textviewMainBottomDiscover.setSelected(true);
                break;
            case SELECTED_MINE:
                transaction.show(mineFragment);
                imageviewMainBottomMine.setSelected(true);
                textviewMainBottomMine.setSelected(true);
                break;
        }
        transaction.commit();
    }

    public void setBottonSelected() {
        imageviewMainBottomDiscover.setSelected(false);
        imageviewMainBottomMine.setSelected(false);
        imageviewMainBottomMovie.setSelected(false);
        imageviewMainBottomShow.setSelected(false);
        textviewMainBottomDiscover.setSelected(false);
        textviewMainBottomMine.setSelected(false);
        textviewMainBottomMovie.setSelected(false);
        textviewMainBottomShow.setSelected(false);
    }

    @OnClick({R.id.relativie_movie, R.id.relativie_show, R.id.relativie_discover, R.id.relativie_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relativie_movie:
                selectFragment(SELECTED_MOVIE);
                break;
            case R.id.relativie_show:
                selectFragment(SELECTED_SHOW);
                break;
            case R.id.relativie_discover:
                selectFragment(SELECTED_DISCOVER);
                break;
            case R.id.relativie_mine:
                selectFragment(SELECTED_MINE);
                break;
        }
    }
}
