package com.example.cmritplacementapp;
import static com.example.cmritplacementapp.DatabaseHelper.TABLE_NAME2;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class S_Dashboard extends AppCompatActivity {
    private static SQLiteDatabase db;
    private static SQLiteOpenHelper openHelper;
    private ArrayList<DriveModel> driveModelArrayList;
    private JobRVAdapter jobRVAdapter;
    private RecyclerView jobRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdashboard);
        Button btnLogOut = findViewById(R.id.btnLogout);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(S_Dashboard.this, MainActivity.class));
                Toast.makeText(getApplicationContext(), "Successfully Logged Out", Toast.LENGTH_SHORT).show();
            }
        });
        driveModelArrayList = new ArrayList<>();
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        driveModelArrayList = S_Dashboard.getDriveDetails();
                jobRVAdapter = new JobRVAdapter(driveModelArrayList, S_Dashboard.this);
                jobRV = findViewById(R.id.idRVJobs);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(S_Dashboard.this, RecyclerView.VERTICAL, false);
                jobRV.setLayoutManager(linearLayoutManager);
                jobRV.setAdapter(jobRVAdapter);
            }
        public static ArrayList<DriveModel> getDriveDetails() {
        db = openHelper.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME2;
        Cursor cursorDrives = db.rawQuery(selectQuery, null);
        ArrayList<DriveModel> DriveModelArrayList = new ArrayList<>();
        if (cursorDrives.moveToFirst()) {
            do {
                DriveModelArrayList.add(new DriveModel(cursorDrives.getString(1),
                        cursorDrives.getString(2),
                        cursorDrives.getString(3),
                        cursorDrives.getString(4),
                        cursorDrives.getString(5)));
            } while (cursorDrives.moveToNext());
        }
        cursorDrives.close();
        return DriveModelArrayList;
    }
}
