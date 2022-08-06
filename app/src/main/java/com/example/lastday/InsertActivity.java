package com.example.lastday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText nm , add;
    Button btn_ins;

    MyDatabaseClass database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        database = new MyDatabaseClass(this);

        nm = findViewById(R.id.student_name);
        add = findViewById(R.id.student_address);
        btn_ins = findViewById(R.id.insert_btn);

        btn_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               long res =  database.insert(nm.getText().toString(),add.getText().toString());

               if(res != -1)
                   Toast.makeText(getBaseContext(),"Insert Done!",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(getBaseContext(),"Insert Failed!",Toast.LENGTH_LONG).show();

            }
        });

    }
}