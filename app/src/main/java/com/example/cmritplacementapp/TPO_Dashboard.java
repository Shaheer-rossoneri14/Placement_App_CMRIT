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
public class TPO_Dashboard extends AppCompatActivity {
    private EditText companyName, Role, companyCTC, jobDescription, applicationLink;
    private Button addJobBtn, btnLogOut;
    private SQLiteDatabase db;
    private SQLiteOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpo_dashboard);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getWritableDatabase();
        companyName = findViewById(R.id.idEdtCompanyName);
        Role = findViewById(R.id.idEdtRole);
        companyCTC = findViewById(R.id.idEdtCTC);
        jobDescription = findViewById(R.id.idEdtJobDescription);
        applicationLink = findViewById(R.id.idEdtJobURL);
        addJobBtn = findViewById(R.id.idBtnAddJob);
        btnLogOut = findViewById(R.id.btnLogout);
        addJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String companyname = companyName.getText().toString();
                String companyrole = Role.getText().toString();
                String companyctc = companyCTC.getText().toString();
                String jobdescription = jobDescription.getText().toString();
                String url = applicationLink.getText().toString();
                if (companyname.isEmpty() && companyrole.isEmpty() && companyctc.isEmpty() && jobdescription.isEmpty() && url.isEmpty()) {
                    Toast.makeText(TPO_Dashboard.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                } else {
                    insertData(companyname, companyrole, companyctc, jobdescription, url);
                    Toast.makeText(TPO_Dashboard.this, "Drive has been added.", Toast.LENGTH_SHORT).show();
                    companyName.setText("");
                    Role.setText("");
                    companyCTC.setText("");
                    jobDescription.setText("");
                    applicationLink.setText("");
                }
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TPO_Dashboard.this, MainActivity.class));
                Toast.makeText(getApplicationContext(), "Successfully Logged Out", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void insertData(String companyName,String Role,String companyCTC,String jobDescription, String applicationLink){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.jName,companyName);
        contentValues.put(DatabaseHelper.jRole,Role);
        contentValues.put(DatabaseHelper.jCTC,companyCTC);
        contentValues.put(DatabaseHelper.jJD,jobDescription);
        contentValues.put(DatabaseHelper.Jurl,applicationLink);
        long id = db.insert(DatabaseHelper.TABLE_NAME2,null,contentValues);
    }
}