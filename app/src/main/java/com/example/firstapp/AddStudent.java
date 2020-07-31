package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    private final AppCompatActivity activity = AddStudent.this;
    private EditText name;
    private EditText address;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText dob;

    private Button save;
    private User user;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        name=(EditText)findViewById(R.id.editTextTextPersonName);
        address=(EditText)findViewById(R.id.editTextAddress);
        email=(EditText)findViewById(R.id.editTextTextEmailAddress);
        phone=(EditText)findViewById(R.id.editTextPhone);
        password=(EditText)findViewById(R.id.editTextTextPassword);
        dob=(EditText)findViewById(R.id.editTextDate);

        save=(Button)findViewById(R.id.save);
        user = new User();
        databaseHelper = new DatabaseHelper(activity);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDataToSQLite();
            }
        });
    }
    private void saveDataToSQLite()
    {
        user.setName(name.getText().toString().trim());
        user.setAddress(address.getText().toString().trim());
        user.setEmail(email.getText().toString().trim());
        user.setPhone(phone.getText().toString().trim());
        user.setPassword(password.getText().toString().trim());
        user.setDob(dob.getText().toString().trim());

        databaseHelper.addUser(user); // save the data in database using databaseHelper class.

        //Show message  save succussfully
        Context context=getApplicationContext();
        CharSequence text="Student data saved :"+name.getText();
        int duration= Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();

        // call the manage student page
        Intent intent = new Intent(AddStudent.this,ManageStudent.class);
        startActivity(intent);
    }
}