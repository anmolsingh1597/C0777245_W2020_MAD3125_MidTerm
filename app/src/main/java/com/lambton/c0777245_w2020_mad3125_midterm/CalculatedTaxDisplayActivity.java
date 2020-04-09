package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.lambton.c0777245_w2020_mad3125_midterm.models.CRACustomer;

public class CalculatedTaxDisplayActivity extends AppCompatActivity {

    private TextView sinText, fullNameText, birthdateText, genderText, ageText, taxFilingText, grossIncomeText, federalTaxText;
    private TextView provisonalTaxText, cppText, eiText, rrspContriText, carryForwardRRSPText, totalTaxableIncomeText, totalPayedText;
    Bundle fetchedUser;
    CRACustomer object;
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
            Toast.makeText(CalculatedTaxDisplayActivity.this, String.valueOf(object.getMaxRRSP()), Toast.LENGTH_SHORT).show();
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
        birthdateText.setText("Date of Birth: " + String.valueOf(object.getBirthDate()));
        genderText.setText("Gender: " + object.getGender());
        ageText.setText("Age: " + String.valueOf(object.getAge()) +" years");
        taxFilingText.setText("Tax Filing Date: " + String.valueOf(object.getTaxFilingDate()));
        grossIncomeText.setText("Gross Income: $" + String.valueOf(object.getGrossIncome()));
        federalTaxText.setText("Federal Tax: $" + String.valueOf(object.getFederalTax()));
        provisonalTaxText.setText("Provisional Tax: $" + String.valueOf(object.getProvincialTax()));
        cppText.setText("CPP: $" + String.valueOf(object.getCpp()));
        eiText.setText("EI: $" + String.valueOf(object.getEi()));
        rrspContriText.setText("RRSP Contributed: $" + String.valueOf(object.getRrspContributed()));
        carryForwardRRSPText.setText("Carry Forward RRSP: $" + String.valueOf(object.getCarryForwardRRSP()));
        totalTaxableIncomeText.setText("Total Taxable Income: $" + String.valueOf(object.getTotalTaxableIncome()));
        totalPayedText.setText("Total Tax Payed: $" + String.valueOf(object.getTotalTaxPayed()));

    }

}
