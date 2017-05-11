package com.wislight.inspect.main.setting;

import android.widget.ListView;

import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;
import com.wislight.inspect.model.SettingItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created time : 2017/4/27 12:01.
 *
 * @author wislight
 */

public class SettingFragment extends BaseFragment {
    @BindView(R.id.lst_setting)
    protected ListView mLst;

    @BindArray(R.array.item_setting_title)
    protected String[] mTitles;

    private int[] mIcons = {
            R.drawable.ic_clear,
            R.drawable.ic_check_update,
            R.drawable.ic_lock_open,
    };

    private List<SettingItem> mDatas;
    private SettingListAdapter mAdapter;

    @Override
    protected void initView() {
        initData();
        mAdapter = new SettingListAdapter();
        mAdapter.reset(mDatas);

        mLst.setAdapter(mAdapter);
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            SettingItem item = new SettingItem();
            item.setIcon(mIcons[i]);
            item.setTitle(mTitles[i]);
            mDatas.add(item);
        }
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_setting;
    }


    @OnClick(R.id.btn_logoff)
    public void onClick() {
        // TODO: 2017/4/28
    }
}
