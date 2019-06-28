package com.example.news.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class NewProvider extends ContentProvider {
    private static final String LOG_TAG=NewProvider.class.getName();

    public static final int PETS = 100;
    public static final int PETS_ID = 101;
    private static final String PATH_NEWS = "news";
    UserDbHelper userDbHelper;

    @Override
    public boolean onCreate() {
        userDbHelper = new UserDbHelper(getContext());
        return true;
    }

    private static final UriMatcher suriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        suriMatcher.addURI(userContract.CONTENT_AUTHORITY, PATH_NEWS, PETS);
        suriMatcher.addURI(userContract.CONTENT_AUTHORITY, PATH_NEWS + "/#", PETS_ID);
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database = userDbHelper.getReadableDatabase();
        Cursor cursor = null;
        int match = suriMatcher.match(uri);
        switch (match) {
            case PETS:
                cursor = database.query(userContract.NewDb.TableName, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case PETS_ID:
                selection = userContract.NewDb._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(userContract.NewDb.TableName, projection, selection, selectionArgs, null, null, sortOrder);
        }
        return cursor;
    }


    @Override
    public String getType(Uri uri) {
final int match=suriMatcher.match(uri);
switch (match){
    case PETS:
        return userContract.NewDb.CONTENT_LIST_TYPE;
    case PETS_ID:
        return userContract.NewDb.CONTENT_ITEM_TYBE;
        default:
            throw new IllegalStateException("");

}

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int match = suriMatcher.match(uri);
        switch (match) {
            case PETS:
                return insertPet(uri, values);
                default:
                    throw new IllegalArgumentException("jhdfhjfkj");
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int match=suriMatcher.match(uri);
        switch (match){
            case PETS:
                return deleteUser(uri,selection,selectionArgs);
            case PETS_ID:
                selection= userContract.NewDb._ID+"=?";
                selectionArgs=new String[]{String.valueOf(ContentUris.parseId(uri))};
                return deleteUser(uri,selection,selectionArgs);
                default:
                    throw  new IllegalArgumentException("Error Deletion");
        }
    }

    private int deleteUser(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase database=userDbHelper.getWritableDatabase();
        return database.delete(userContract.NewDb.TableName,selection,selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
   int match=suriMatcher.match(uri);
   switch (match){
       case PETS:
          return UpdateUser(uri,values,selection,selectionArgs);
       case PETS_ID:
           selection= userContract.NewDb._ID +"=?";
           selectionArgs=new String[]{String.valueOf(ContentUris.parseId(uri))};
           return UpdateUser(uri,values,selection,selectionArgs);
           default:
               throw new IllegalArgumentException("Not valid");
   } }


    private Uri insertPet(Uri uri,ContentValues values) {

       String Username=values.getAsString(userContract.NewDb.Username_Column);
       if (Username==null){
           throw new IllegalArgumentException("Username Requried");
       }
       String Email=values.getAsString(userContract.NewDb.Email_column);
       if (Email==null){
           throw new IllegalArgumentException("Email Required");
       }
       String Password=values.getAsString(userContract.NewDb.Password_column);
       if (Password==null){
           throw new IllegalArgumentException("Password Required");
       }
       String Confirm_password=values.getAsString(userContract.NewDb.ConfirmPassword_column);
       if (Confirm_password==null){
           throw  new IllegalArgumentException("Confirmed Password Required");
       }

        SQLiteDatabase database = userDbHelper.getWritableDatabase();
        long id=  database.insert(userContract.NewDb.TableName, null, values);
        if (id==-1){
            Log.e(LOG_TAG,"Failed to insert Username Data for "+uri);
            return null;
        }
       return ContentUris.withAppendedId(uri,id);
    }

    private int UpdateUser(Uri uri ,ContentValues values ,String selection, String[]selectionArgs){
        if (values.size()==0){
            return 0;
        }
        if (values.containsKey(userContract.NewDb.Username_Column)){
            String Username=values.getAsString(userContract.NewDb.Username_Column);
            if (Username==null){
                throw new IllegalArgumentException("User requirre username");
            }
        }
        if (values.containsKey(userContract.NewDb.Email_column)){
            String userEmail=values.getAsString(userContract.NewDb.Email_column);
            if (userEmail==null){
                throw new IllegalArgumentException("User requirre email");
            }
        }
        if (values.containsKey(userContract.NewDb.Password_column)){
            String userPass=values.getAsString(userContract.NewDb.Password_column);
            if (userPass==null){
                throw new IllegalArgumentException("User requirre username");
            }
        }
        if (values.containsKey(userContract.NewDb.ConfirmPassword_column)){
            String userConfirm=values.getAsString(userContract.NewDb.ConfirmPassword_column);
            if (userConfirm==null){
                throw new IllegalArgumentException("User requirre username");
            }
        }

        SQLiteDatabase database=userDbHelper.getWritableDatabase();
        return database.update(userContract.NewDb.TableName,values,selection,selectionArgs);
    }
}
