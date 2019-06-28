package com.example.news;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.news.data.UserDbHelper;
import com.example.news.data.userContract.NewDb;


public class VerifyPassword extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;
UserDbHelper userDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_password);
     userDbHelper = new UserDbHelper(this);
        editText = (EditText) findViewById(R.id.new_pass);
        editText1 = (EditText) findViewById(R.id.old_pass);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.verified);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  newPass = editText.getText().toString();
              String  oldpass = editText1.getText().toString();
                  if (!newPass.equals(oldpass)) {
            editText.setError("Confirm password");
        }
        if (TextUtils.isEmpty(oldpass)) {
            editText.setError("Password is empty");
        }
        if (TextUtils.isEmpty(newPass)) {
            editText.setError("Password is empty");
        }

                ContentValues values = new ContentValues();
                values.put(NewDb.Password_column, newPass);
                 values.put(NewDb.ConfirmPassword_column,newPass);
                String[] projection = {NewDb._ID,
                        NewDb.Username_Column,NewDb.Email_column,NewDb.Password_column,NewDb.ConfirmPassword_column};

                Cursor cursor = getContentResolver().query(NewDb.CONTENT_URI, projection, null, null, null);
                if (cursor.getCount()==0){
                    Toast.makeText(VerifyPassword.this,"Failed", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                String[] selectioArgs = {String.valueOf(cursor.getCount())};
                int uri = getContentResolver().update(NewDb.CONTENT_URI, values,null,null);
                if (uri>=1){
                    Toast.makeText(VerifyPassword.this,"Password updated successfully", Toast.LENGTH_SHORT).show();
                }

            }}
        });
    }
}
