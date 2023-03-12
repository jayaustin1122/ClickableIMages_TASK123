package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class OrderActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // create ArrayAdapter using the string array default spinner layout.
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply the adapter to spinner
        if (spinner != null){
            spinner.setAdapter(adapter);
        }
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.sameday));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.nextday));
                break;
            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pickup));
                break;
            default:
                break;
        }
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}