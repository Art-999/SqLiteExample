package com.example.arturmusayelyan.sqliteexample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName_et;
    private EditText password_et;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName_et = findViewById(R.id.user_name_et_login);
        password_et = findViewById(R.id.password_et_login);
        login_btn = findViewById(R.id.login_button_login_activity);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button_login_activity:
                Bundle bundle = getIntent().getExtras();
                int status = bundle.getInt("status");
                if (status == 1) {
                    String userName = userName_et.getText().toString();
                    String password = password_et.getText().toString();
                    Toast.makeText(this, "Please wait...", Toast.LENGTH_LONG).show();
                    DatabaseOperations databaseOperations = new DatabaseOperations(this);
                    Cursor cursor = databaseOperations.getInformation(databaseOperations);
                    cursor.moveToFirst();
                    boolean login_status = false;
                    String NAME = "";
                    do {
                        if (userName.equals(cursor.getString(0)) && (password.equals(cursor.getString(1)))) {
                            login_status = true;
                            NAME = cursor.getString(0);
                        }

                    } while (cursor.moveToNext());

                    if (login_status) {
                        Toast.makeText(this, "Login success----\n Welcome " + NAME, Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Login Failed----", Toast.LENGTH_LONG).show();
                        finish();
                    }
                } else if (status == 2) {
                    Intent intent = new Intent("update_filter");
                    startActivity(intent);
                } else if (status == 3) {
                    String userName = userName_et.getText().toString();
                    String password = password_et.getText().toString();
                    Toast.makeText(this, "Please wait...", Toast.LENGTH_LONG).show();
                    DatabaseOperations databaseOperations = new DatabaseOperations(this);
                    Cursor cursor = databaseOperations.getInformation(databaseOperations);
                    cursor.moveToFirst();
                    boolean login_status = false;
                    String NAME = "";
                    do {
                        if (userName.equals(cursor.getString(0)) && (password.equals(cursor.getString(1)))) {
                            login_status = true;
                            NAME = cursor.getString(0);
                        }

                    } while (cursor.moveToNext());

                    if (login_status) {
                        Toast.makeText(this, "Login success----\n Welcome " + NAME, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(this,DeleteActivity.class);
                        Bundle bundle1 = new Bundle();
                        bundle1.putString("user_name", NAME);
                        intent.putExtras(bundle1);
                        startActivity(intent);

                        finish();
                    } else {
                        Toast.makeText(this, "Login Failed----", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
                break;
        }
    }
}
