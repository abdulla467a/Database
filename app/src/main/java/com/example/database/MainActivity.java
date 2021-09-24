package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DatabaseHelper myDbhelper;
    private String name,email,phone;
EditText nameEdittext,phonedittext,emailedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDbhelper=new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        nameEdittext = findViewById(R.id.nameEditTextid);
        emailedittext = findViewById(R.id.emailEditTextid);
        phonedittext = findViewById(R.id.phoneEditTextid);
    }

    public void savedatafunction(View view) {
        name = nameEdittext.getText().toString();
        email = emailedittext.getText().toString();
        phone = phonedittext.getText().toString();
       String value= myDbhelper.addStudentsInfo(name,email,phone);
       if (value.equals("Y")){
            Toast.makeText(this,"Data inserted Sucessfully",Toast.LENGTH_LONG).show();
        }
       else{
           Toast.makeText(this,"failed" ,Toast.LENGTH_LONG).show();
       }
    }
}