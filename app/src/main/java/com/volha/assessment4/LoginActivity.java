package com.volha.assessment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

  private static final String SHARED_PREF = "sharedPref";

  SharedPreferences sharedPreferences;

  private EditText editText1;
  private EditText editText2;
  private CheckBox checkBox;
  private Button button;

  private static final String EDIT_ONE_KEY = "edit1";
  private static final String EDIT_TWO_KEY = "edit2";
  private static final String CHECK_BOX_KEY = "check";

  private static final String EMAIL_KEY = "email";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    editText1 = findViewById(R.id.edit1);
    editText2 = findViewById(R.id.edit2);
    checkBox = findViewById(R.id.check);
    button = findViewById(R.id.button);

    sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String input1 = editText1.getText().toString();
        String input2 = editText2.getText().toString();
        boolean isChecked = checkBox.isChecked();

        editor.putString(EDIT_ONE_KEY, input1).apply();
        editor.putString(EDIT_TWO_KEY, input2).apply();
        editor.putBoolean(CHECK_BOX_KEY, isChecked).apply();

        if(input1.equals("user@aol.com") && input2.equals("password1234")) {
          Intent intent = new Intent(LoginActivity.this, ListActivity.class);
          intent.putExtra(EMAIL_KEY, input1);
          startActivity(intent);
        }
      }
    });

  }

  @Override
  protected void onResume() {
    super.onResume();

    String edit1Value = sharedPreferences.getString(EDIT_ONE_KEY, "");
    String edit2Value = sharedPreferences.getString(EDIT_TWO_KEY, "");
    boolean isCheckedValue = sharedPreferences.getBoolean(CHECK_BOX_KEY, false);

    editText1.setText(edit1Value);
    editText2.setText(edit2Value);
    checkBox.setChecked(isCheckedValue);
  }
}
