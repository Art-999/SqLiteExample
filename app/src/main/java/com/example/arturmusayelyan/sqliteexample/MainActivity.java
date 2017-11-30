package com.example.arturmusayelyan.sqliteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_button:
                status=1;
                Intent intent=new Intent(this,LoginActivity.class);
                intent.putExtra("status",status);
                startActivity(intent);
                break;
            case R.id.register_button:
                Intent intent1=new Intent(this,RegisterActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
