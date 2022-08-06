package com.example.lastday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MyDatabaseClass databaseClass;

    String DB_PATH;
    Button ins, del, up, gt_stu, gt_all_stu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///// adfnslgldhndhkdm
        Log.w("GIT","dfgdfgdfgdfg");

        databaseClass = new MyDatabaseClass(this);
        ins = findViewById(R.id.insert);
        del = findViewById(R.id.delete);
        up = findViewById(R.id.update);
        gt_stu = findViewById(R.id.getone);
        gt_all_stu = findViewById(R.id.getAll);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(i);
            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(i);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = databaseClass.delete(1);

                if (res != -1)
                    Toast.makeText(getBaseContext(), "Delete Done!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Delete Failed!", Toast.LENGTH_LONG).show();

            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int res = databaseClass.update(1, "Ahmed", "Benha");
                if (res != -1)
                    Toast.makeText(getBaseContext(), "Update Done!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getBaseContext(), "Update Failed!", Toast.LENGTH_LONG).show();


            }
        });
        gt_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseClass.getStudent(2);

                Toast.makeText(getBaseContext(), res.getInt(0) + "\n" + res.getString(1) +
                        "\n" + res.getString(2), Toast.LENGTH_LONG).show();

            }
        });

        gt_all_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = databaseClass.getAllStudent();

                do {

                    Toast.makeText(getBaseContext(), res.getInt(0) + "\n" + res.getString(1) +
                            "\n" + res.getString(2), Toast.LENGTH_LONG).show();

                } while (res.moveToNext());


            }
        });
    }

}
