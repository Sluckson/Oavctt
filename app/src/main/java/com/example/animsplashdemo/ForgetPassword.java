package com.example.animsplashdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ForgetPassword extends AppCompatActivity {
    private Button feedbak;
    private Toolbar mainToolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        mAuth = FirebaseAuth.getInstance();

        feedbak = (Button) findViewById(R.id.resertId);
        mainToolbar = (Toolbar) findViewById(R.id.boll);
        setSupportActionBar(mainToolbar);

        getSupportActionBar().setTitle("");

        feedbak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassword.this, FeedBack.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nif:
                Toast.makeText(ForgetPassword.this,"nif",Toast.LENGTH_LONG).show();
                break;

            case R.id.fulname:
                Toast.makeText(ForgetPassword.this,"name",Toast.LENGTH_LONG).show();

                break;
            case R.id.home:
                Intent intent = new Intent(ForgetPassword.this, Home.class);
                startActivity(intent);
                finish();
                break;

            case R.id.service:
                Toast.makeText(ForgetPassword.this,"servic",Toast.LENGTH_LONG).show();
                break;

            case R.id.feedback:
                Intent instant = new Intent(ForgetPassword.this, FeedBack.class);
                startActivity(instant);
                finish();
                break;

            case R.id.profile:
                Intent intend = new Intent(ForgetPassword.this, Profile.class);
                startActivity(intend);
                finish();
                break;

            case R.id.logout:
                logout();
                break;

            case R.id.exit:
                Toast.makeText(ForgetPassword.this,"exit",Toast.LENGTH_LONG).show();
                break;

            default:
               break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        mAuth.signOut();
        sendToLogion();

    }

    private void sendToLogion(){
        Intent intent = new Intent(ForgetPassword.this, Login.class);
        startActivity(intent);
        finish();

    }
}