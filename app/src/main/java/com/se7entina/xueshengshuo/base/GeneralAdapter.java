package com.se7entina.xueshengshuo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.List;

import cc.rengu.cpspay.util.ViewUtil;
import cc.rengu.cpspay.view.showview.ShowDataView;

/**
 * Class: GeneralAdapter
 * Created by se7enTina on 2015/11/28.
 * Description: 通用适配器
 */
public class GeneralAdapter<T extends List<K>, K> extends BaseAdapter {

    public static final String TAG = "GeneralAdapter";

    private T data;
    private ShowDataView<K> showDataView;
    private int layoutId;

    public GeneralAdapter(ShowDataView<K> showDataView, int layoutId) {
        this.showDataView = showDataView;
        this.layoutId = layoutId;
    }

    public void setData(T data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public T getData() {
        return data;
    }

    @Override
    public int getCount() {

        if (data == null) return 0;

        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public AbsListView.LayoutParams getLayoutParams(float density) {

        return new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

    }

    public int[] getIds() {
        return null;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);
            convertView.setLayoutParams(getLayoutParams(parent.getContext().getResources().getDisplayMetrics().density));

            if (getIds() != null)
                for (int id : getIds())
                    convertView.setTag(id, convertView.findViewById(id));
            else
                ViewUtil.setViewChildToTag(convertView);
        }

        showDataView.showDataView(convertView, data.get(position),position);

        return convertView;
    }
}
