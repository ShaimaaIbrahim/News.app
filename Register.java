package com.example.news;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.UserHandle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.news.data.userContract.NewDb;
import com.example.news.data.UserDbHelper;
import com.example.news.data.userContract;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
public class Register extends AppCompatActivity {
     public static String Register_user;
    public static String Register_pass;
     public static String Register_email;
    public static String Register_Confirmpasspass;

   private EditText editText;
   private EditText editText1;
   private EditText editText2;
   private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("تسجيل الدخول");
          editText = (EditText) findViewById(R.id.register_user);
        editText1 = (EditText) findViewById(R.id.register_email);
        editText2 = (EditText) findViewById(R.id.register_pass);
       editText3 = (EditText) findViewById(R.id.register_confirm_pass);


        Button button = (Button) findViewById(R.id.register_botton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

        TextView textView=(TextView)findViewById(R.id.show_accounts);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Register.this,showAccounts.class);
                startActivity(intent);
            }
        });

    }
    private void insert() {

        Register_user = editText.getText().toString().trim();
        Register_email = editText1.getText().toString().trim();
        Register_pass = editText2.getText().toString().trim();
        Register_Confirmpasspass = editText3.getText().toString().trim();


        if (TextUtils.isEmpty(Register_user)) {
            editText.setError("This field Can not be blank");
        }
        if (TextUtils.isEmpty(Register_email)) {
            editText1.setError("This field Can not be blank");
        }
        if (TextUtils.isEmpty(Register_pass)) {
            editText2.setError("This field Can not be blank");
        }
        if (TextUtils.isEmpty(Register_Confirmpasspass)) {
            editText3.setError("This field Can not be blank");
        }
        if (!Register_user.isEmpty() && !Register_email.isEmpty() && !Register_pass.isEmpty() && !Register_Confirmpasspass.isEmpty()) {

            ContentValues values = new ContentValues();
            values.put(NewDb.Username_Column, Register_user);
            values.put(NewDb.Email_column, Register_email);
            values.put(NewDb.Password_column, Register_pass);
            values.put(NewDb.ConfirmPassword_column, Register_Confirmpasspass);
            Uri uri = getContentResolver().insert(NewDb.CONTENT_URI, values);
             Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        }
    }
    }



