package com.lambton.c0777245_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PersonInformationEntryActivity extends AppCompatActivity {

    private TextView sinTextView;
    private Spinner suffixTitleSpinner;
    private TextView firstNameText;
    private TextView lastNameText;
    private Spinner genderSpinner;

    String sin;
    String suffixTitle;
    String firstName;
    String lastName;
    String gender;
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
    }

    private void suffix(){

        sin = sinTextView.getText().toString();
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
        Toast.makeText(PersonInformationEntryActivity.this, "Date Picker", Toast.LENGTH_SHORT).show();
    }

    public void save(View view){
        suffix();
        genderFetch();
        Toast.makeText(PersonInformationEntryActivity.this, sin, Toast.LENGTH_SHORT).show();
    }
    public void clear(View view){
        Toast.makeText(PersonInformationEntryActivity.this, "Clear", Toast.LENGTH_SHORT).show();
    }
}

