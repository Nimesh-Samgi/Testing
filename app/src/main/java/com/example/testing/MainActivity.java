package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name =(EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        Info = (TextView) findViewById(R.id.tvInfo);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void Validate(String userName, String userPassword){
        if ((userName.equals("Nimesh")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else{
            counter --;

            Info.setText("No of Attempts remaining: " + String.valueOf(counter));

            if (counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
