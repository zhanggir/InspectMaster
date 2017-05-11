package com.wislight.inspect.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wislight.inspect.MainActivity;
import com.wislight.inspect.R;
import com.wislight.inspect.base.BaseFragment;
import com.wislight.inspect.dao.LogWrapper;
import com.wislight.inspect.widget.TimeButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

/**
 * Created time : 2017/4/26 14:27.
 *
 * @author wislight
 */

public class RegisterFragment extends BaseFragment {
    @BindView(R.id.edt_register_username)
    protected EditText mEdtUsername;
    @BindView(R.id.edt_register_code)
    protected EditText mEdtCode;
    @BindView(R.id.edt_register_password)
    protected EditText mEdtPwd;
    @BindView(R.id.time_btn)
    protected TimeButton mTimeBtn;
    @BindView(R.id.img_check)
    protected ImageView mImgCheck;
    public EventHandler eh; //事件接收器

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTimeBtn.onCreate();
        init();

    }


    @Override
    protected void initView() {
        mImgCheck.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN://显示密码
                        mEdtPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        mEdtPwd.setSelection(mEdtPwd.getText().length());
                        return true;
                    case MotionEvent.ACTION_UP://隐藏密码
                        mEdtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        mEdtPwd.setSelection(mEdtPwd.getText().length());
                        return true;
                }
                return false;
            }
        });
    }



    @Override
    protected int getContentLayout() {
        return R.layout.fragment_register;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTimeBtn.onDestroy();
    }

    public String getUsername() {
        return mEdtUsername.getText().toString();
    }

    public String getPassword() {
        return mEdtPwd.getText().toString();
    }

    public String getCode() {
        return mEdtCode.getText().toString();
    }

    /**
     * 初始化事件接收器
     */
    private void init() {
        eh = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                LogWrapper.e("TAG","--------"+result);
                if (result == SMSSDK.RESULT_COMPLETE) { //回调完成

                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) { //提交验证码成功

                        toActivity(LoginFragment.class); //页面跳转

                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) { //获取验证码成功

                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) { //返回支持发送验证码的国家列表

                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eh);
    }
}