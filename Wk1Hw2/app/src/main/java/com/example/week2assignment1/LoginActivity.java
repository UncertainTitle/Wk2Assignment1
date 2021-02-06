package com.example.week2assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    Button LoginButton;
    EditText nameTextView;
    EditText passwordTextView;

    HashMap<String, String> loginMap = new HashMap<String, String>();
    HashMap<String, Integer> idMap = new HashMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button LoginButton = (Button)findViewById(R.id.login_Button);
        EditText nameTextView = (EditText) findViewById(R.id.nameEditText);
        EditText passwordTextView = (EditText) findViewById((R.id.passwordEditText));

        loginMap.put("Will", "White");
        idMap.put("Will", 2);

        loginMap.put("Dr", "C");
        idMap.put("Dr", 1);

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String userText = nameTextView.getText().toString();
                String passwordText = passwordTextView.getText().toString();

                nameTextView.setBackgroundColor(Color.WHITE);
                passwordTextView.setBackgroundColor(Color.WHITE);

                if(loginMap.containsKey(userText))
                {
                    String userPassword = loginMap.get(userText);

                    if(userPassword.equals(passwordText))
                    {
                        int idNumber = idMap.get(userText);
                        openActivity(userText, idNumber);
                    }
                    else
                    {
                        toaster("INCORRECT PASSWORD!!!");
                        passwordTextView.setBackgroundColor(Color.RED);
                    }
                }
                else
                {
                    toaster("INCORRECT USERNAME!!!");
                    nameTextView.setBackgroundColor(Color.RED);
                }
            }
        });
    };


    //====================================================================================
    //This method creates a toast message
    //====================================================================================
    private void toaster(String message)
    {
        Toast t = Toast.makeText(this.getApplicationContext(),message,Toast.LENGTH_LONG );
        t.setGravity(Gravity.CENTER_VERTICAL,0,0);
        t.show();
    }

    public void openActivity(String s, Integer i){
        Intent intent = new Intent(this, MainActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("Username", s);
        bundle.putInt("Current User", i);

        intent.putExtras(bundle);
        startActivity(intent);}
    }