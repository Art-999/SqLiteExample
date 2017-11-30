package com.example.arturmusayelyan.sqliteexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    private Button delete_btn;
    private EditText password_et;
    private Bundle bundle;
    private String USERNAME;
    private String PASSWORRD;
    private DatabaseOperations databaseOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete_btn = findViewById(R.id.delete_btn);
        password_et = findViewById(R.id.delete_et);
        delete_btn.setOnClickListener(this);

        bundle = getIntent().getExtras();
        USERNAME = bundle.getString("user_name");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete_btn:
                PASSWORRD = password_et.getText().toString();
                databaseOperations=new DatabaseOperations(this);
                Cursor cursor=databaseOperations.getUserPassword(databaseOperations,USERNAME);
                cursor.moveToFirst();
                boolean login_status=false;
                do {
                    if(PASSWORRD.equals(cursor.getString(0))){
                        login_status=true;
                    }

                }while (cursor.moveToNext());

                if(login_status){
                    //delete user from here
                    databaseOperations.deleteUser(databaseOperations,USERNAME,PASSWORRD);
                    Toast.makeText(this,"User removed successfully.....",Toast.LENGTH_LONG).show();
                    finish();

                }else {
                    Toast.makeText(this,"Invalid User.....Try later",Toast.LENGTH_LONG).show();
                    finish();
                }

                break;
        }
    }
}
