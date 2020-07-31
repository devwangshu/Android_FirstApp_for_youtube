package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_addstud=(Button)findViewById(R.id.btn_Addstudent);
        Button btn_manageStudent=(Button)findViewById(R.id.btn_managestudent);
        btn_addstud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //display a toast message
                Context context=getApplicationContext();
                CharSequence text="Add Student Button was Clicked";
                int duration= Toast.LENGTH_SHORT;

                Toast toast=Toast.makeText(context,text,duration);
                toast.show();

                // Calling one page to another
                Intent intent=new Intent(MainActivity.this,AddStudent.class);
                startActivity(intent);
            }
        });
        btn_manageStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calling one page to another
                Intent intent=new Intent(MainActivity.this,ManageStudent.class);
                startActivity(intent);
            }
        });
    }
}