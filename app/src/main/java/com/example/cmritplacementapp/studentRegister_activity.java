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
public class studentRegister_activity extends AppCompatActivity {
    private Button btnRegister;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private EditText regName,regEmail,regUsn,regPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
        openHelper = new DatabaseHelper(this);
        btnRegister = findViewById(R.id.btnSregister);
        regName = findViewById(R.id.editSName);
        regEmail = findViewById(R.id.editSEmail);
        regUsn = findViewById(R.id.editSUsn);
        regPassword = findViewById(R.id.editSPwd);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();
                String fName = regName.getText().toString().trim();
                String fUsn = regUsn.getText().toString().trim();
                String fEmail = regEmail.getText().toString().trim();
                String fPassword = regPassword.getText().toString().trim();
                if (fName.isEmpty() || fPassword.isEmpty() || fEmail.isEmpty() || fUsn.isEmpty()) {
                    Intent intent = new Intent(studentRegister_activity.this, studentRegister_activity.class);
                    startActivity(intent);
                    Toast.makeText(studentRegister_activity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else {
                    insertData(fName, fUsn, fEmail, fPassword);
                    Toast.makeText(studentRegister_activity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(studentRegister_activity.this, studentLogin_activity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public void insertData(String fName,String fUsn,String fEmail,String fPassword){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.sName,fName);
        contentValues.put(DatabaseHelper.sUsn,fUsn);
        contentValues.put(DatabaseHelper.sEmail,fEmail);
        contentValues.put(DatabaseHelper.sPassword,fPassword);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
}
