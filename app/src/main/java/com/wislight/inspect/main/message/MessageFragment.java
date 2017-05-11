package com.wislight.inspect.main.message;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;
import com.wislight.inspect.model.MessageInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created time : 2017/4/27 11:59.
 *
 * @author wislight
 */

public class MessageFragment extends BaseFragment {
    @BindView(R.id.lst_msg_list)
    protected ListView mLstMsg;

    private String[] titles = {
            "4月份高新区巡查计划",
            "巡检任务的异常报告",
            "巡检任务的异常报告"
    };

    private String[] explains = {
            "这是针对高新区供电设备的巡检计划，要全全体施工人员佩戴好安全头盔，随身携带防触电装备...",
            "4月23号的巡检任务出现了异常操作，这是一条反馈...",
            "4月20号的巡检任务出现了异常操作，这是一条反馈..."
    };
    private String[] charges = {"王某某", "刘某某", "张某某"};


    private List<MessageInfo> mDatas;

    private MessageListAdapter mAdapter;

    @Override
    protected void initView() {
        initData();
        mAdapter = new MessageListAdapter();
        mAdapter.reset(mDatas);

        mLstMsg.setAdapter(mAdapter);
        initEvent();
    }
    private void initEvent(){
        mLstMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 2017/5/11 点击跳转到 消息详情页
                Toast.makeText(parent.getContext(),"巡查计划详情"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        //假数据
        mDatas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MessageInfo info = new MessageInfo();
            info.setTitle(titles[i]);
            info.setStatus(i % 3);
            info.setExplain(explains[i]);
            info.setCharge(charges[i]);
            info.setStamp("2017-04-" + (i + 20));

            mDatas.add(info);
        }
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_message;
    }


}
