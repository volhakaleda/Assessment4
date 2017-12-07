package com.volha.assessment4;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by yuliya-k on 12/6/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
  private List<CustomObject> list;
  private Activity activity;

  public CustomAdapter(List<CustomObject> list) {
    this.list = list;
  }
  @Override
  public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    return new CustomViewHolder(inflater.inflate(R.layout.view_holder, parent, false));

  }

  @Override
  public void onBindViewHolder(CustomViewHolder holder, int position) {
    CustomObject object = list.get(position);
    holder.bindData(object);
  }

  @Override
  public int getItemCount() {
    return list.size();
  }
}
