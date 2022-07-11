package com.example.cmritplacementapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "studentRegistration";
    public static final String TABLE_NAME1 = "tpoRegistration";
    public static final String sId = "ID";
    public static final String sName = "Name";
    public static final String sUsn = "Usn";
    public static final String sEmail = "Email";
    public static final String sPassword = "Password";
    public static final String tId = "ID";
    public static final String tName = "Name";
    public static final String tEid = "Eid";
    public static final String tEmail = "Email";
    public static final String tPassword = "Password";
    public static final String TABLE_NAME2 = "Drive";
    public static final String jID = "id";
    public static final String jName = "Company_Name";
    public static final String jRole = "Role";
    public static final String jCTC = "CTC";
    public static final String jJD = "Job_Description";
    public static final String Jurl = "Application_Link";
    public static SQLiteDatabase db;
    public static SQLiteOpenHelper openHelper;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Usn TEXT,Email TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Eid TEXT,Email TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Company_Name TEXT,Role TEXT,CTC TEXT,Job_Description TEXT, Application_Link TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }
}
