package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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

    long sin;
    String suffixTitle;
    String firstName;
    String lastName;
    String gender;
    Date dateOfBirth;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
    }

    private void findById(){
        sinTextView = findViewById(R.id.enterSINTextView);
        suffixTitleSpinner = findViewById(R.id.spinner);
        firstNameText = findViewById(R.id.enterFirstNameTextView);
        lastNameText = findViewById(R.id.enterLastNameTextView);
        genderSpinner = findViewById(R.id.genderCodeSpinner);
        dateOfBirthText = findViewById(R.id.enterDateTextView);
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

    public void save(View view){
        suffix();
        genderFetch();
        if (sinTextView.getText().toString().equals("") /* || ||
               )*/){
            sinTextView.setError("Enter SIN Number");
           /*

            */
        }else if (firstNameText.getText().toString().equals("")){
            firstNameText.setError("Enter First Name");
        }else if ( lastNameText.getText().toString().equals("")){
            lastNameText.setError("Enter Last Name");
        }else if ( dateOfBirthText.getText().toString().equals("")){
            dateOfBirthText.setError("Invalid Date of Birth");
        }else if (age <18){
            dateOfBirthText.setError("Not eligible to file tax for current year");
        }

        else{
            Toast.makeText(PersonInformationEntryActivity.this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        }


    }
    public void clear(View view){
        Toast.makeText(PersonInformationEntryActivity.this, "Clear", Toast.LENGTH_SHORT).show();
    }
}

