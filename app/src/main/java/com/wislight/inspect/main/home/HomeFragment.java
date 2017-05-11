package com.wislight.inspect.main.home;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;
import com.wislight.inspect.model.HomeItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created time : 2017/4/27 11:27.
 * 首页
 *
 * @author wisligt
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.lst_main)
    protected ListView mLstMain;
    @BindArray(R.array.item_main_title)
    protected String[] mTitles;

    private List<HomeItem> mDatas;
    private HomeListAdapter mAdapter;

    protected int[] mResIds = {
            R.drawable.ic_check,
            R.drawable.ic_wait,
            R.drawable.ic_approval
    };

    @Override
    protected void initView() {
        initData();
        mAdapter =new HomeListAdapter();
        mAdapter.reset(mDatas);

        mLstMain.setAdapter(mAdapter);
        initEvent();
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HomeItem item = new HomeItem();
            item.setIcon(mResIds[i]);
            item.setTitle(mTitles[i]);
            item.setCount(String.valueOf(i + 1));
            mDatas.add(item);
        }
    }
    //lsitview的点击事件
    private void initEvent(){
        mLstMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 2017/5/11 跳转到执行的任务界面
                Toast.makeText(parent.getContext(),"跳转到执行的任务界面 ",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

}
