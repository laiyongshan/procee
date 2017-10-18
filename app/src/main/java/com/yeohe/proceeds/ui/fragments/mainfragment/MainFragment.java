package com.yeohe.proceeds.ui.fragments.mainfragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.gesture.GestureActivity;
import com.yeohe.proceeds.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGAStickinessRefreshViewHolder;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MainFragment extends BaseFragment implements BGARefreshLayout.BGARefreshLayoutDelegate,BGABanner.Delegate<ImageView, String>, BGABanner.Adapter<ImageView, String>{
    private View view;

    private static final String TAG = MainFragment.class.getSimpleName();

    @BindView(R.id.rl_normalview_refresh)
    BGARefreshLayout mRefreshLayout;

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.banner_main_default)
    BGABanner mDefaultBanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 避免多次从xml中加载布局文件
        if (view == null) {
            view=inflater.inflate(R.layout.fragment_main,null);
            ButterKnife.bind(this,view);

            initView();
            setListener();
            processLogic(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }

        return view;
    }

    @OnClick({R.id.btn1})
    public void click(View v){
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(getActivity(), GestureActivity.class));
                break;
        }
    }

    @Override
    public void initView() {
//        mRefreshLayout = (BGARefreshLayout) view.findViewById(R.id.rl_normalview_refresh);
        loadBannerData(mDefaultBanner,imgURLs.size());

    }


    /*
    * 加载Banner数据
    * */
    List<String> imgURLs=new ArrayList<String>();
    List<String> tips=new ArrayList<String>();
    private void loadBannerData( BGABanner banner,  int count){
        banner.setAdapter(this);
        imgURLs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508326257455&di=7454fc4c785176524a165d08174abecd&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F16%2F41%2F06G58PICfVz_1024.jpg");
        imgURLs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508326257455&di=3873b26a230ccfdf90d9264040fdeba2&imgtype=0&src=http%3A%2F%2Fwww.xingzuo360.cn%2Fuploads%2Fallimg%2F141104%2F1_141104180811_1.jpg");
        imgURLs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508326257454&di=ac0f1a6cf85595937b67cfbba07bdaf4&imgtype=0&src=http%3A%2F%2Fscimg.jb51.net%2Fallimg%2F150715%2F14-150G5152ZO48.jpg");
        banner.setData(imgURLs, tips);
    }

    protected void setListener() {
        mDefaultBanner.setDelegate(this);
        mRefreshLayout.setDelegate(this);
    }

    protected void processLogic(Bundle savedInstanceState) {
        BGAStickinessRefreshViewHolder stickinessRefreshViewHolder = new BGAStickinessRefreshViewHolder(getActivity(), true);
        stickinessRefreshViewHolder.setStickinessColor(R.color.colorPrimary);
        stickinessRefreshViewHolder.setRotateImage(R.mipmap.bga_refresh_stickiness);
        mRefreshLayout.setRefreshViewHolder(stickinessRefreshViewHolder);

//        mRefreshLayout.setCustomHeaderView(DataEngine.getCustomHeaderView(getActivity()), false);
    }


    public static final int LOADING_DURATION = 2000;
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {

        ToastUtil.showMessage(getContext(),"下拉刷新数据.....");

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(LOADING_DURATION);
                    Log.i(TAG,"执行下拉刷新任务......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                ToastUtil.getShortToastByString(getContext(),"执行下拉刷新任务......");

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                mRefreshLayout.endRefreshing();
            }
        }.execute();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {

                    Log.i(TAG,"执行下拉刷新任务......");

                    Thread.sleep(LOADING_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                ToastUtil.getLongToastByString(getContext(),"执行上拉加载任务......");

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                mRefreshLayout.endLoadingMore();
                Log.i(TAG, "上拉加载更多完成");
            }
        }.execute();
        return true;
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, String model, int position) {
        Glide.with(itemView.getContext())
                .load(model)
                .placeholder(R.drawable.holder)
                .error(R.drawable.holder)
                .dontAnimate()
                .fitCenter()
                .into(itemView);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, ImageView itemView, String model, int position) {
        Toast.makeText(banner.getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
    }
}
