package com.example.cmritplacementapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class studentLogin_activity extends AppCompatActivity {
    private EditText S_Email,S_Password;
    private Button S_loginbtn;
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        S_Email = findViewById(R.id.editSEmailAddress);
        S_Password = findViewById(R.id.editS_Pwd);
        S_loginbtn = findViewById(R.id.S_loginbtn);
        S_loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = S_Email.getText().toString().trim();
                String password = S_Password.getText().toString().trim();
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(studentLogin_activity.this, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
                } else {
                    cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.sEmail + "=? AND " + DatabaseHelper.sPassword + "=?", new String[]{email, password});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            startActivity(new Intent(studentLogin_activity.this, S_Dashboard.class));
                            Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Login error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}