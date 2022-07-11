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
public class tpoLogin_activity extends AppCompatActivity {
    private EditText TPO_Email,TPO_Password;
    private Button TPO_loginbtn;
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        TPO_Email = findViewById(R.id.editTPOEmailAddress);
        TPO_Password = findViewById(R.id.editTPO_Pwd);
        TPO_loginbtn = findViewById(R.id.TPO_loginbtn);
        TPO_loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TPO_Email.getText().toString().trim();
                String password = TPO_Password.getText().toString().trim();
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(tpoLogin_activity.this, "Enter your Email and Password to login", Toast.LENGTH_SHORT).show();
                } else {
                    cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME1 + " WHERE " + DatabaseHelper.tEmail + "=? AND " + DatabaseHelper.tPassword + "=?", new String[]{email, password});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            startActivity(new Intent(tpoLogin_activity.this, TPO_Dashboard.class));
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