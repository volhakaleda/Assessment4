package com.volha.assessment4;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yuliya-k on 12/6/17.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

  private TextView textView;

  public CustomViewHolder(View itemView) {
    super(itemView);
    textView = itemView.findViewById(R.id.number);
  }

  public void bindData(CustomObject object) {
    String value = String.valueOf(object.getNumber());
    textView.setText(value);

    textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      }
    });
  }
}
