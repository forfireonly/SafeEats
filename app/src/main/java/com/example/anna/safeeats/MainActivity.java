package com.example.anna.safeeats;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.anna.safeeats.registrationForm.password;
import static com.example.anna.safeeats.registrationForm.username;


public class MainActivity extends Activity {
    Button b1, b2;
    EditText ed1, ed2;

    TextView tx1, tx2;
    int counter = 3;

    Dialog Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // final View layout = inflater.inflate(R.layout.password_dialog, (ViewGroup) findViewById(R.id.root));
//        final EditText password1 = (EditText) layout.findViewById(R.id.EditText_Pwd1);
//        final EditText password2 = (EditText) layout.findViewById(R.id.EditText_Pwd2);
//        final TextView error = (TextView) layout.findViewById(R.id.TextView_PwdProblem);

        //

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);

        //  b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx2 = (TextView) findViewById(R.id.textView2);
        tx2.setVisibility(View.GONE);
        tx1.setVisibility(View.GONE);

        Login = new Dialog(this);
        Login.setTitle("Enter Your Login Information");


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp =
                        getSharedPreferences("MyPrefs",
                                Context.MODE_PRIVATE);
                String first = sp.getString("USERNAME", username);
                String second = sp.getString("PASSWORD", password);
                if (ed1.getText().toString().equals(first) &&
                        ed2.getText().toString().equals(second)) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();

                    Intent intent;
                    intent = new Intent(MainActivity.this, foodEntry.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx2.setVisibility(View.VISIBLE);
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });
    }

    // b2.setOnClickListener(new View.OnClickListener() {
    //      @Override
    //       public void onClick(View v) {
    //          finish();
    //       }
    //   };


    public void registration(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this, registrationForm.class);
        startActivity(intent);
    }
    //Custom dialog for registration
//    public void Registration(View view) {
//        final Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.password_dialog);
//        dialog.setTitle("Register");
//
//        dialog.show();
//        Window window=dialog.getWindow();
//        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
//        Button  PopUpClose = (Button) dialog.findViewById(R.id.Register);
//        //competitorOneWon.setContentView(R.layout.popup1);
//        // PopUpClose = (Button) competitorOneWon.findViewById(R.id.dismiss1);
//        PopUpClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//                // Toast.makeText(getApplicationContext(), "Please, Reset Score and Timer", Toast.LENGTH_LONG).show();
//
//            }
//        });
//    }


}

