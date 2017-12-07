package com.volha.assessment4;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by yuliya-k on 12/6/17.
 */

public class CustomAsync extends AsyncTask<Integer, Integer, Integer> {
  private TextView textView;
  private Activity activity;

  public CustomAsync(TextView textView, Activity activity) {
    this.textView = textView;
    this.activity = activity;
  }

  @Override
  protected void onPreExecute() {
    super.onPreExecute();
  }

  @Override
  protected Integer doInBackground(Integer... integers) {
    for(int i = integers[0]; i < 100000; i++) {
      publishProgress(i);
    }
    return 100000;
  }

  @Override
  protected void onProgressUpdate(Integer... values) {
    super.onProgressUpdate(values);
    textView.setText("Loops completed: " + values[0]);
  }

  @Override
  protected void onPostExecute(Integer integer) {
    super.onPostExecute(integer);
    textView.setText("Loops completed: " + integer);
    Intent intent = new Intent(activity, LoginActivity.class);
    activity.startActivity(intent);
  }
}
