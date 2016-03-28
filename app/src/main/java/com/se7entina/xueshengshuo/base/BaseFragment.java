package com.se7entina.xueshengshuo.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    public static final String TAG = "BaseFragment";

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), null);
            rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            ButterKnife.inject(this, rootView);
            onFirst(rootView);
        }
        try {
            onAgain(rootView);
        }catch (Exception e){
            ButterKnife.inject(this, rootView);
            onAgain(rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        if (rootView != null) {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            viewGroup.removeAllViews();
        }
    }

    public View getRootView() {
        return rootView;
    }

    /**
     * 资源id
     */
    public abstract int getLayoutId();

    /**
     * 第一次加载
     */
    public abstract void onFirst(View rootView);

    /**
     * 再一次加载
     */
    public abstract void onAgain(View rootView);
}

