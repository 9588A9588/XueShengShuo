package com.se7entina.xueshengshuo.view.ptr;

import android.view.View;

/**
 * Class: PtrHandler
 * Created by se7enTina on 2016/1/14.
 * Description: 下拉刷新线程接口
 */
@SuppressWarnings("ALL")
public interface PtrHandler {

    public boolean checkCanDoRefresh(final PtrFrameLayout frame, final View content, final View header);

    public void onRefreshBegin(final PtrFrameLayout frame);
}