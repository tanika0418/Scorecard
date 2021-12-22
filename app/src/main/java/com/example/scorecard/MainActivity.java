package com.example.scorecard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    TextView textView;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.editTextTextEmailAddress);
        password=findViewById(R.id.editTextTextPassword);
        login=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        textView.setPaintFlags(textView.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        textView.setText("Please enter the details to access scorecard");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickLogin();
            }
        });
    }
    public void ClickLogin(){
        if (username.getText().toString().trim().isEmpty()) {
            String text1="Username should not be empty";
            Toast t= Toast.makeText(this,text1,Toast.LENGTH_SHORT);
            t.show();
        }
        else if (password.getText().toString().trim().isEmpty()) {
            String text2="Password should not be empty";
            Toast t= Toast.makeText(this,text2,Toast.LENGTH_SHORT);
            t.show();
        }
        else if((username.getText().toString().equalsIgnoreCase("harsh"))&&
                    (password.getText().toString().equalsIgnoreCase("qwerty01$0("))) {
            String admin="Harsh";
                        secondActivity();
            }

            else if((username.getText().toString().equalsIgnoreCase("shivam"))&&
                    (password.getText().toString().equalsIgnoreCase("asdfgh99A@"))) {
                secondActivity();
            }
            else{
                Toast t=Toast.makeText(this,"Wrong credentials",Toast.LENGTH_SHORT);
                t.show();
            }
        }

    public void secondActivity(){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

    }
}