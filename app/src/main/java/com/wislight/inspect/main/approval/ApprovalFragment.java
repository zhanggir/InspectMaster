package com.wislight.inspect.main.approval;

import android.widget.ListView;


import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created time : 2017/4/27 11:57.
 *
 * @author wislight
 */

public class ApprovalFragment extends BaseFragment {
    @BindView(R.id.lst_approval)
    protected ListView mLst;

    private ApprovalListAdapter mAdapter;
    private List<String> mDatas;

    @Override
    protected void initView() {
        initDatas();
        mAdapter = new ApprovalListAdapter();
        mAdapter.reset(mDatas);

        mLst.setAdapter(mAdapter);
    }

    private void initDatas() {
        //todo 假数据
        mDatas = new ArrayList<>();
        for (int i = 4; i <= 6; i++) {
            mDatas.add(i + "月份高新区巡查计划");
        }
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_approval;
    }

}
