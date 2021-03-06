package com.volha.assessment4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoopActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_loop);

    TextView textView = findViewById(R.id.text);

    CustomAsync customAsync = new CustomAsync(textView, this);
    customAsync.execute(100);
  }
}
