package com.yeohe.proceeds.ui.tranrecords;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.ccj.base.base.BaseActivity;
import com.flyco.roundview.RoundTextView;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.utils.ToastUtil;
import com.yeohe.proceeds.widgets.TrandViewGroup;

import org.xutils.common.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/11/2.
 */

public class TranRecordsActivity extends BaseActivity implements TrandViewGroup.OnGroupItemClickListener{

    @BindView(R.id.title_tv2)
    TextView title_tv2;

    @BindViews({R.id.cleaning_viewGroup,R.id.trand_viewGroup,R.id.status_viewGroup})
    TrandViewGroup<TextView>[] mGroups;

    @BindViews({R.id.start_time_tv,R.id.over_time_tv})
    TextView[] times;


    @BindViews({R.id.reset_rtv,R.id.make_sure_rtv})
    RoundTextView[] rtvs;

    private ArrayList<String> viewtexts = new ArrayList<>();

    private int chooseID1 = -1;
    private int chooseID2=-1;
    private int chooseID3=-1;

    private String chooseText;


    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_tranrecords);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    public void initView(){

        title_tv2.setText("交易记录");

        initCleaningData();
        initStatusData();
        initStyleData();
    }

    private void initCleaningData(){
        viewtexts.clear();
        String text;
        text = "T0结算";
        viewtexts.add(text);
        text="T1结算";
        viewtexts.add(text);
        mGroups[0].addItemViews(viewtexts, TrandViewGroup.TEV_MODE);
        mGroups[0].setGroupClickListener(this,mGroups[0].getId());
    }

    private void initStyleData(){
        viewtexts.clear();
        String text;
        text = "刷卡";
        viewtexts.add(text);
        text="二维码";
        viewtexts.add(text);
        text="快捷收款";
        viewtexts.add(text);
        mGroups[1].addItemViews(viewtexts, TrandViewGroup.TEV_MODE);
        mGroups[1].setGroupClickListener(this,mGroups[1].getId());
    }

    private void initStatusData(){
        viewtexts.clear();
        String text;
        text = "结算中";
        viewtexts.add(text);
        text="未结算";
        viewtexts.add(text);
        text="结算成功";
        viewtexts.add(text);
        mGroups[2].addItemViews(viewtexts, TrandViewGroup.TEV_MODE);
        mGroups[2].setGroupClickListener(this,mGroups[2].getId());
    }


    @OnClick({R.id.start_time_tv,R.id.over_time_tv,R.id.reset_rtv,R.id.make_sure_rtv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.start_time_tv:
                pvTimeShow(times[0]);
                break;

            case R.id.over_time_tv:
                pvTimeShow(times[1]);
                break;

            case R.id.reset_rtv://重置
                times[0].setText("");
                times[1].setText("");
                break;

            case R.id.make_sure_rtv://确定
                LogUtil.i("确定:"+chooseID1+"\n"+chooseID2+"\n"+chooseID3);
                break;
        }
    }



    private void pvTimeShow(TextView time_tv){
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(TranRecordsActivity.this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                ToastUtil.showMessage(TranRecordsActivity.this, getTime(date));

                time_tv.setText(""+getTime(date));
            }
        }).setType(new boolean[]{true, true, true, false, false, false})
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Override
    public void onGroupItemClick(int item,int viewId) {
        if(viewId==mGroups[0].getId()) {
            chooseID1 = item;
        }else if(viewId==mGroups[0].getId()){
            chooseID2=item;
        }else if(viewId==mGroups[0].getId()){
            chooseID3=item;
        }
    }
}
