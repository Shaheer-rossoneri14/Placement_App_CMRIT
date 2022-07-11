package com.example.cmritplacementapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tpoRegister_activity extends AppCompatActivity {
    private Button btnRegister;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText regName,regEmail,regEid,regPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_register);
        openHelper = new DatabaseHelper(this);
        btnRegister = findViewById(R.id.btnTporegister);
        regName = findViewById(R.id.editTpoName);
        regEmail = findViewById(R.id.editTpoEmail);
        regEid = findViewById(R.id.editTpoEid);
        regPassword = findViewById(R.id.editTpoPwd);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String fName = regName.getText().toString().trim();
                String fEid = regEid.getText().toString().trim();
                String fEmail = regEmail.getText().toString().trim();
                String fPassword = regPassword.getText().toString().trim();
                if (fName.isEmpty() || fPassword.isEmpty() || fEmail.isEmpty() || fEid.isEmpty()) {
                    Intent intent = new Intent(tpoRegister_activity.this, tpoRegister_activity.class);
                    startActivity(intent);
                    Toast.makeText(tpoRegister_activity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    insertData(fName, fEid, fEmail, fPassword);
                    Toast.makeText(tpoRegister_activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(tpoRegister_activity.this, tpoLogin_activity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void insertData(String fName,String fEid,String fEmail,String fPassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.tName,fName);
        contentValues.put(DatabaseHelper.tEid,fEid);
        contentValues.put(DatabaseHelper.tEmail,fEmail);
        contentValues.put(DatabaseHelper.tPassword,fPassword);
        long id = db.insert(DatabaseHelper.TABLE_NAME1,null,contentValues);
    }
}
