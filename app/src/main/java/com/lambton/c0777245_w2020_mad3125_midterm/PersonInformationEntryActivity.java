package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PersonInformationEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dateImageButton(View view){
        Toast.makeText(PersonInformationEntryActivity.this, "Date Picker", Toast.LENGTH_SHORT).show();
    }

    public void save(View view){
        Toast.makeText(PersonInformationEntryActivity.this, "Save", Toast.LENGTH_SHORT).show();
    }
    public void clear(View view){
        Toast.makeText(PersonInformationEntryActivity.this, "Clear", Toast.LENGTH_SHORT).show();
    }
}

