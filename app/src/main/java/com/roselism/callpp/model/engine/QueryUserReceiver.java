package com.roselism.callpp.model.engine;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.QueryUserByEmailStragegy;
import com.roselism.callpp.model.engine.stragegy.StragegyContent;


/**
 * 查询user的接收器
 * 里面封装的都是查询User的方法
 * Created by simon on 2016/4/30.
 *
 * @param <R> 返回值类型
 */
public class QueryUserReceiver<R> {

    OnOperatListener listener;

    /**
     * @param listener 监听器
     */
    public QueryUserReceiver(OnOperatListener<R> listener) {
        this.listener = listener;
    }

    /**
     * 通过邮箱查询User
     */
    void queryUserByEmail(String email) {
        StragegyContent<RoseUser> content = new StragegyContent();
        content.setStragegy(new QueryUserByEmailStragegy(email));
        content.run(new OnOperatListener<RoseUser>() {
            @Override
            public void onSuccedd(RoseUser user) {
                listener.onSuccedd(user);
            }

            @Override
            public void onError(Throwable error) {
                listener.onError(error);
            }
        });
    }
}