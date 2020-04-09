package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lambton.c0777245_w2020_mad3125_midterm.models.CRACustomer;

public class CalculatedTaxDisplayActivity extends AppCompatActivity {

    private TextView sinText, fullNameText, birthdateText, genderText, ageText, taxFilingText, grossIncomeText, federalTaxText;
    private TextView provisonalTaxText, cppText, eiText, rrspContriText, carryForwardRRSPText, totalTaxableIncomeText, totalPayedText;
    Bundle fetchedUser;
    CRACustomer object;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_tax_display);
        fetchedObject();
        intials();
    }

    public void fetchedObject(){
        Intent intent = getIntent();
        if (intent.hasExtra("userObject")){
            fetchedUser = intent.getBundleExtra("userObject");
            object = (CRACustomer) fetchedUser.getSerializable("userBundle");
//            Toast.makeText(CalculatedTaxDisplayActivity.this, String.valueOf(object.getBirthDate()), Toast.LENGTH_SHORT).show();
        }
    }

    public void intials(){
        sinText = findViewById(R.id.sinDisplayText);
        fullNameText = findViewById(R.id.fullNameDisplayText);
        birthdateText = findViewById(R.id.birthDateDisplayText);
        genderText = findViewById(R.id.genderDisplayText);
        ageText = findViewById(R.id.ageDisplayText);
        taxFilingText = findViewById(R.id.taxFilingDateDisplayText);
        grossIncomeText = findViewById(R.id.grossIncomeDisplayText);
        federalTaxText = findViewById(R.id.federalTaxDisplayText);
        provisonalTaxText = findViewById(R.id.provisionalTaxDisplayText);
        cppText = findViewById(R.id.cppDisplayText);
        eiText = findViewById(R.id.eiDisplayText);
        rrspContriText = findViewById(R.id.rrspDisplayText);
        carryForwardRRSPText = findViewById(R.id.carryForwardRRSPDisplayText);
        totalTaxableIncomeText = findViewById(R.id.totalTaxableIncomeDisplayText);
        totalPayedText = findViewById(R.id.totalTaxPayedDisplayText);


        sinText.setText("SIN: " + object.getPersonSINNumber());
        fullNameText.setText("Full Name: " + object.getFullName());
        birthdateText.setText("Date of Birth: " + dateToString(object.getBirthDate()));
        genderText.setText("Gender: " + object.getGender());
        ageText.setText("Age: " + String.valueOf(object.getAge()) +" years");
        taxFilingText.setText("Tax Filing Date: " + String.valueOf(object.getTaxFilingDate()));
        grossIncomeText.setText("Gross Income: " + defaultFormat.format(object.getGrossIncome()));
        federalTaxText.setText("Federal Tax: " + defaultFormat.format(object.getFederalTax()));
        provisonalTaxText.setText("Provincial Tax (Ontario) : " + defaultFormat.format(object.getProvincialTax()));
        cppText.setText("CPP: " + defaultFormat.format(object.getCpp()));
        eiText.setText("EI: " + defaultFormat.format(object.getEi()));
        rrspContriText.setText("RRSP Contributed: " + defaultFormat.format(object.getRrspContributed()));
        carryForwardRRSPText.setText("Carry Forward RRSP: " + defaultFormat.format(object.getCarryForwardRRSP()));
        setColor();
        totalTaxableIncomeText.setText("Total Taxable Income: " + defaultFormat.format(object.getTotalTaxableIncome()));
        totalPayedText.setText("Total Tax Payed: " + defaultFormat.format(object.getTotalTaxPayed()));

    }

    public void setColor(){
        if (object.carryForwardRRSP<0.0){
            carryForwardRRSPText.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    public String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
