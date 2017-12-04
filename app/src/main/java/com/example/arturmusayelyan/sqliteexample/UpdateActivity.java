package com.example.arturmusayelyan.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText userName_et;
    private Button update_btn;
    private String user_name, user_pass, new_user_name;
    private DatabaseOperations databaseOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        userName_et = findViewById(R.id.update_et);
        update_btn = findViewById(R.id.update_btn);
        update_btn.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        user_name = bundle.getString("user_name");
        user_pass = bundle.getString("user_pass");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update_btn:
                new_user_name = userName_et.getText().toString();
                databaseOperations = new DatabaseOperations(this);
                databaseOperations.updateUserInfo(databaseOperations, user_name, user_pass, new_user_name);
                Toast.makeText(this, "Updation Success.....", Toast.LENGTH_LONG).show();
                finish();
                break;
        }
    }
}
