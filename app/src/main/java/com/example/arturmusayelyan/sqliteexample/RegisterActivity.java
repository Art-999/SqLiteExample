package com.example.arturmusayelyan.sqliteexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by artur.musayelyan on 30/11/2017.
 */

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName_et;
    private EditText password_et;
    private EditText password_confirm_et;
    private Button register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName_et = findViewById(R.id.user_name_et_register);
        password_et = findViewById(R.id.user_password_et_register);
        password_confirm_et = findViewById(R.id.user_confirm_password_et_register);
        register_btn = findViewById(R.id.user_register_button);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.user_register_button) {
            String userName = userName_et.getText().toString();
            String password = password_et.getText().toString();
            String confirmPassword = password_confirm_et.getText().toString();

            if (!(confirmPassword.equals(password))) {
                Toast.makeText(this, "Passwords are not matching", Toast.LENGTH_LONG).show();
                userName_et.setText("");
                password_et.setText("");
                password_confirm_et.setText("");
            } else {
                DatabaseOperations databaseOperations = new DatabaseOperations(this);
                databaseOperations.putInformation(databaseOperations, userName, password);
                Toast.makeText(this, "Registration success", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
