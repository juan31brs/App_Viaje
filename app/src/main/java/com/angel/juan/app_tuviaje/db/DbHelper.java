package com.angel.juan.app_tuviaje.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    public static final String TAG = DbHelper.class.getSimpleName();

    public static final String DB_NAME= "viaje.db";//nombre de la bd
    public static final int DB_VERSION = 1;//version

    public static final String USER_TABLE = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASS = "password";

    /*
    create table users{
                       id integer primary key autoincrement,
                       name text,
                       password text}
     */

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT,"
            + COLUMN_PASS + " TEXT);";


    //constructor
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //metodo de sqlite, crea la tabla
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {sqLiteDatabase.execSQL(CREATE_TABLE_USERS);}

    //metodo de sqlite
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(sqLiteDatabase);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String name, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_PASS, password);

        long id = sqLiteDatabase.insert(USER_TABLE, null, values);
        sqLiteDatabase.close();

        Log.d(TAG, "user inserted" + id);
    }


    public boolean getUser(String name, String pass){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from  " + USER_TABLE + " where " +
                COLUMN_NAME + " = " + "'"+name+"'" + " and " + COLUMN_PASS + " = " + "'"+pass+"'";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            return true;
        }
        cursor.close();
        sqLiteDatabase.close();

        return false;
    }
}
