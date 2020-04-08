package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.lambton.c0777245_w2020_mad3125_midterm.models.CRACustomer;

public class CalculatedTaxDisplayActivity extends AppCompatActivity {


    Bundle fetchedUser;
    CRACustomer object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_tax_display);
        fetchedObject();
    }

    public void fetchedObject(){
        Intent intent = getIntent();
        if (intent.hasExtra("userObject")){
            fetchedUser = intent.getBundleExtra("userObject");
            object = (CRACustomer) fetchedUser.getSerializable("userBundle");
            Toast.makeText(CalculatedTaxDisplayActivity.this, object.getFullName(), Toast.LENGTH_SHORT).show();
        }
    }
}
