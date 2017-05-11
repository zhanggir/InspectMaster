package com.wislight.inspect.login;

import android.widget.EditText;

import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;

import butterknife.BindView;


/**
 * Created time : 2017/4/26 13:16.
 *
 * @author wislight
 */

public class LoginFragment extends BaseFragment {
    @BindView(R.id.edt_login_username)
    protected EditText mEdtUsername;
    @BindView(R.id.edt_login_password)
    protected EditText mEdtPwd;

    @Override
    protected void initView() {
    }

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_login;
    }

    public String getUsername() {
        return mEdtUsername.getText().toString();
    }

    public String getPassword() {
        return mEdtPwd.getText().toString();
    }
}
