package com.example.lastday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        msg = findViewById(R.id.hello);


        SharedPreferences pref = getSharedPreferences("myData",0);
        String p_name = pref.getString("USER_NAME","");
        String p_pass = pref.getString("USER_PASSWORD","");

        msg.setText("Hello, "+p_name);

        /*Log.w("MSG",p_name+" - "+p_pass);
        if(!p_name.isEmpty() && !p_pass.isEmpty()) {
            Intent i = new Intent(MainActivity.this,MenuActivity.class);
            startActivity(i);
        }*/

    }
}