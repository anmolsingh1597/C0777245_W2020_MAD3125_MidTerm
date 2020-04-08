package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private TextView sinTextView;
    private Spinner suffixTitleSpinner;
    private TextView firstNameText;
    private TextView lastNameText;
    private Spinner genderSpinner;
    private TextView dateOfBirthText;
    private TextView taxFilingDateText;
    private TextView grossIncomeText;
    private TextView rrspText;

    long sin;
    String suffixTitle;
    String firstName;
    String lastName;
    String gender;
    Date dateOfBirth;
    int age;
    LocalDate taxFilledDate;
    double grossIncomed;
    double rrspContri;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void findById(){
        sinTextView = findViewById(R.id.enterSINTextView);
        suffixTitleSpinner = findViewById(R.id.spinner);
        firstNameText = findViewById(R.id.enterFirstNameTextView);
        lastNameText = findViewById(R.id.enterLastNameTextView);
        genderSpinner = findViewById(R.id.genderCodeSpinner);
        dateOfBirthText = findViewById(R.id.enterDateTextView);
        taxFilingDateText = findViewById(R.id.entertaxFilingDateTextView);
        grossIncomeText = findViewById(R.id.enterGrossIncomeTextView);
        rrspText = findViewById(R.id.enterrrspTextView);

        taxFilingDateText.setText(String.valueOf(LocalDate.now()));
        dateOfBirthText.setEnabled(false);
        taxFilingDateText.setEnabled(false);
        taxFilledDate = LocalDate.now();
    }

    private void suffix(){

        String sinModel = sinTextView.getText().toString();

        if (sinModel.equals("")){
            sin = 0;
        }else {
            sin = Integer.parseInt(sinModel);
        }

        int position = suffixTitleSpinner.getSelectedItemPosition();
        suffixTitle = String.valueOf(suffixTitleSpinner.getItemAtPosition(position));
        firstName = firstNameText.getText().toString();
        lastName = lastNameText.getText().toString();

    }

    private void genderFetch(){
        int genderSpinnerPosition = genderSpinner.getSelectedItemPosition();
        gender = String.valueOf(genderSpinner.getItemAtPosition(genderSpinnerPosition));
    }

    public void dateImageButton(View view){
        DatePickerDialog datePickerDialog;
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
// date picker dialog
        datePickerDialog = new DatePickerDialog(PersonInformationEntryActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        dateOfBirthText.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            dateOfBirth = formatter.parse(dateOfBirthText.getText().toString());
                            LocalDate l1 = LocalDate.of(year, monthOfYear+1, dayOfMonth);
                            LocalDate now1 = LocalDate.now();
                            Period diff1 = Period.between(l1, now1);
                            age = diff1.getYears();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void grossIncome(){
        String incomeModel = grossIncomeText.getText().toString();

        if (incomeModel.equals("")){
            grossIncomed = 0.0;
        }else{
        grossIncomed = Double.parseDouble(incomeModel);}
    }

    private void rrspContributed(){
        String rrspModel = rrspText.getText().toString();

        if (rrspModel.equals("")){
            rrspContri = 0.0;
        }else{
            rrspContri = Double.parseDouble(rrspModel);}
    }

    public void save(View view){
        suffix();
        genderFetch();
        grossIncome();
        rrspContributed();
        if (sinTextView.getText().toString().equals("")){
            sinTextView.setError("Enter SIN Number");
        }else if (firstNameText.getText().toString().equals("")){
            firstNameText.setError("Enter First Name");
        }else if ( lastNameText.getText().toString().equals("")){
            lastNameText.setError("Enter Last Name");
        }else if ( dateOfBirthText.getText().toString().equals("")){
            dateAlert();
        }else if (age <18){
            ageAlert();
        }
        else{
            Toast.makeText(PersonInformationEntryActivity.this, String.valueOf(rrspContri), Toast.LENGTH_SHORT).show();
        }
    }
    public void clear(View view){
        sinTextView.setText("");
        firstNameText.setText("");
        lastNameText.setText("");
        dateOfBirthText.setText("");
        grossIncomeText.setText("");
        rrspText.setText("");
    }

    public void dateAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("Invalid date: Please Enter a valid date");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }

    public void ageAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error");
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("Not eligible to file tax for current year");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Refill", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dateOfBirthText.setText("");
                dialog.dismiss();
            }
        });

        AlertDialog homeAlert = builder.create();
        homeAlert.show();
    }
}

