package com.example.anna.safeeats;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class registrationForm extends AppCompatActivity {
    public static String username, password;
    EditText userName, passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
    }
    public void saveData(View view) {
        userName = (EditText)findViewById(R.id.editText);
        passWord = (EditText) findViewById(R.id.editText2);
        username = userName.getText().toString();
        password = passWord.getText().toString();
        SharedPreferences sp =
                getSharedPreferences("MyPrefs",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USERNAME", username);
        editor.putString("PASSWORD", password);
        //editor.putInt("highscore", HighScore);
        editor.commit();
    }
}
