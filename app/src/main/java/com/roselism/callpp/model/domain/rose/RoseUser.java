package com.roselism.callpp.model.domain.rose;

import android.widget.Toast;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.adapter.RoseUser2BmobUser;
import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.util.LogUtil;
import com.roselism.callpp.util.convert.Converter;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by simon on 2016/4/30.
 */
public class RoseUser extends RoseObject {

    /**
     * 用户邮箱
     */
    String email;

    /**
     * 用户密码
     */
    String password;

    /**
     * 用户的电话
     */
    String phoneNumber;

    /**
     * 用户头像的url地址
     */
    String profileUrl;

    /**
     * 用户邮箱是否验证
     */
    boolean emailVerified;


    // 用户的昵称
    String nickName;


    public RoseUser() {
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    /**
     * 用户的登陆逻辑
     */
    public void login(final OnOperatListener<Boolean> listener) {
        Converter<RoseUser, User> converter = new RoseUser2BmobUser();
        final User user = converter.convert(this);

        // bmob user 的登陆逻辑，还需要添加别的登录逻辑
        user.login(CallppApplication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() { //登陆成功
                Toast.makeText(CallppApplication.getContext(), "登陆成功", Toast.LENGTH_SHORT).show(); // 登陆成功
                listener.onSuccedd(true);
            }

            @Override
            public void onFailure(int i, String s) { // 登陆失败
                Toast.makeText(CallppApplication.getContext(), "登陆失败", Toast.LENGTH_SHORT).show(); // 登陆成功
                listener.onSuccedd(false);
                LogUtil.e(i + " " + s);
            }
        });
    }

    @Override
    public void save(final OnSaveListener<? extends RoseObject> listener) {
        // 存储策略 - bmob对象的存储
        Converter<RoseUser, User> converter = new RoseUser2BmobUser();
        final User user = converter.convert(this);
        user.signUp(CallppApplication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onFinish();
            }

            @Override
            public void onFailure(int i, String s) {
                LogUtil.e("i:" + s);
                listener.onError();
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }


}