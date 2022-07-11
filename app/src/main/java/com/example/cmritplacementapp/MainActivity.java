package com.example.cmritplacementapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button tpoLogin = findViewById(R.id.tpoLogin);
        Button studentLogin = findViewById(R.id.studentLogin);
        Button tpoRegister = findViewById(R.id.tpoRegister);
        Button studentRegister = findViewById(R.id.studentRegister);
        tpoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, tpoLogin_activity.class);
                startActivity(intent);
            }
        });
        studentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, studentLogin_activity.class);
                startActivity(intent);
            }
        });
        tpoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, tpoRegister_activity.class);
                startActivity(intent);
            }
        });
        studentRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, studentRegister_activity.class);
                startActivity(intent);
            }
        });
    }
}
