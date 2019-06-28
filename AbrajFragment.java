package com.example.news;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentProvider;
import android.content.ContentResolver;
import com.example.news.data.userContract.NewDb;
import com.example.news.data.UserDbHelper;
import com.example.news.data.userContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class AbrajFragment extends Fragment {
    EditText username;
    EditText password;
    Button logIn;
    String user, pasword;

    private String facebook = "https://www.facebook.com/%D8%A7%D9%84%D8%B5%D9%81%D8%AD%D8%A7%D8%AA-%D8%A7%D9%84%D8%A5%D8%AE%D8%A8%D8%A7%D8%B1%D9%8A%D8%A9-News-Pages-188790327830357/";

    public AbrajFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
      setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.activity_abraj, container, false);

        final String uri = "https://www.instagram.com/abraj.top/?fbclid=IwAR05X1N_90j8W2oD4-bCuxxYdWYtK9Dx2FQjjUhR1fu8rpra5ZiEQccwA_w";
        username = (EditText) rootView.findViewById(R.id.user);


        password = (EditText) rootView.findViewById(R.id.password);


        logIn = (Button) rootView.findViewById(R.id.log_in);

       TextView Alredy_register=(TextView)rootView.findViewById(R.id.already_resister);
       Alredy_register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(), Register.class);
               startActivity(intent);
           }
       });
//log out method used to delete the other  account the user Registtered with it
        //////////////////check it
       TextView log_out=(TextView)rootView.findViewById(R.id.log_out);
       log_out.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               int d= (int) getContext().getContentResolver().delete(NewDb.CONTENT_URI,null,null);
               if (d>=1){
                 Toast.makeText(getActivity(), "you Log out Successfully"  , Toast.LENGTH_LONG).show();
               }
               else{
                   Toast.makeText(getActivity(), "you Hasn not registered yet"  , Toast.LENGTH_LONG).show();
               }
           }
       });
       //to update password the user Registered with it
/////////////////////////////////////////////////////////////////////
       TextView forget_pass=(TextView)rootView.findViewById(R.id.forget_password);
       forget_pass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getActivity(),VerifyPassword.class);
               startActivity(intent);
           }
       });
       /////to log in account
 ////////////////////////////////////////////////////////////////////
        logIn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
         query();
            }

        });
 /////////////////////////////////////////////////////////////
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.userr, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void query() {
        user = username.getText().toString();
        pasword = password.getText().toString();

        String []projection={
          NewDb._ID,NewDb.Username_Column
          ,NewDb.Email_column,
          NewDb.Password_column,
          NewDb.ConfirmPassword_column
        };

       Cursor cursor=getContext().getContentResolver().query(NewDb.CONTENT_URI, projection, null, null, null, null);
       cursor.moveToLast();
       if (cursor.getCount()==0){
           Toast.makeText(getActivity(), "No Valid Account", Toast.LENGTH_LONG).show();
           return;
       }
            int user_ColumnIndex = cursor.getColumnIndex(NewDb.Username_Column);
            int pass_ColumnIndex = cursor.getColumnIndex(NewDb.ConfirmPassword_column);


            String User = cursor.getString(user_ColumnIndex);
            String pass_confirm = cursor.getString(pass_ColumnIndex);


            if (user.equals(User) && pasword.equals(pass_confirm)) {
                Intent intent_facebook = new Intent(Intent.ACTION_VIEW, Uri.parse(facebook));
                startActivity(intent_facebook);
            }
        }
    }

