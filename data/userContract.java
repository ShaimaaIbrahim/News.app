package com.example.news.data;

import android.net.Uri;
import android.provider.BaseColumns;
import android.content.ContentResolver;
public final class userContract {

    private userContract(){

    }

    public static final String PATH_PETS="news";
   public static final String CONTENT_AUTHORITY="com.example.android.news";
   public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    public static class NewDb implements BaseColumns  {
        public static final String CONTENT_ITEM_TYBE =ContentResolver.CURSOR_ITEM_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_PETS;
        public static final String CONTENT_LIST_TYPE=ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_PETS;
        public final static String TableName="user";

        public final static String _ID = BaseColumns._ID;

    public static final Uri CONTENT_URI=Uri.withAppendedPath(BASE_CONTENT_URI,PATH_PETS);

        public final static String Username_Column="Username";

        public final static String Email_column="Email";

        public final static String Password_column="Password";

        public final static String ConfirmPassword_column="ConfirmPassword";





    }
}
