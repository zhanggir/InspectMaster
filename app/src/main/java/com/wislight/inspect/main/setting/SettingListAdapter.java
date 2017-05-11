package com.wislight.inspect.main.setting;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseListAdapter;
import com.wislight.inspect.model.SettingItem;

import butterknife.BindView;

/**
 * Created time : 2017/4/28 14:12.
 *
 * @author wislight
 */

public class SettingListAdapter extends BaseListAdapter<SettingItem, SettingListAdapter.SettingViewHolder> {


    @Override
    protected int getItemViewLayout() {
        return R.layout.item_lst_setting;
    }

    @Override
    protected SettingViewHolder getItemViewHolder(View view) {
        return new SettingViewHolder(view);
    }

    class SettingViewHolder extends BaseListAdapter.ViewHolder {

        @BindView(R.id.img_setting_item)
        ImageView mImg;
        @BindView(R.id.tv_setting_title)
        TextView mTvTitle;

        public SettingViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void bind(int position) {
            SettingItem item = getItem(position);

            mTvTitle.setText(item.getTitle());
            mImg.setImageResource(item.getIcon());
        }
    }
}
