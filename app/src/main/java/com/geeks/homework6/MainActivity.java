package com.geeks.homework6;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText loginEditText = findViewById(R.id.loginText);
        EditText passwordEditText = findViewById(R.id.passwordText);
        Button loginButton = findViewById(R.id.buttonLogin);
        TextView welcomeText = findViewById(R.id.welcomeText);

        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!loginEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!loginEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    loginButton.setBackgroundColor(getResources().getColor(R.color.gray));
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredLogin = loginEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (enteredLogin.equals("admin") && enteredPassword.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    loginEditText.setVisibility(View.GONE);
                    passwordEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                    welcomeText.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}