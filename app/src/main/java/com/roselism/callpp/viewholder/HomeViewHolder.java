package com.roselism.callpp.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.roselism.callpp.adapter.HomeRecyclerAdapter;
import com.roselism.callpp.base.BaseViewHolder;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:27
 * @描述 首页的ViewHolder
 */
public class HomeViewHolder extends BaseViewHolder<RecyclerView, String> {
    public HomeViewHolder(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView initRootView() {
        return new RecyclerView(mContext);
    }

    @Override
    protected void initData() {
        RecyclerView recyclerView = getRootView();
        for (int i = 0; i < 100; i++) {
            mDatas.add("第" + i + "条数据");
        }
        recyclerView.setAdapter(new HomeRecyclerAdapter(mDatas));
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
    }
}
