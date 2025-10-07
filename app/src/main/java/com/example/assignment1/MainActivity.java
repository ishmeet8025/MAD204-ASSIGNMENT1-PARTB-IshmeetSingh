package com.example.assignment1;

/**
 * Course: MAD204 - Java Development for Mobile Applications
 * Assignment: 1 (Part B - Android App)
 * Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 2025
 * Description: A simple Android app that takes user input (name, age, program)
 * and displays an introduction message or validation errors.
 */

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, ageInput, programInput;
    TextView resultText;
    Button introduceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect UI elements
        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        programInput = findViewById(R.id.programInput);
        introduceBtn = findViewById(R.id.introduceBtn);
        resultText = findViewById(R.id.resultText);

        // Handle button click
        introduceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString().trim();
                String ageText = ageInput.getText().toString().trim();
                String program = programInput.getText().toString().trim();

                if (name.isEmpty() || ageText.isEmpty() || program.isEmpty()) {
                    resultText.setText("⚠️ Please fill all fields!");
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);
                    if (age <= 0) {
                        resultText.setText("⚠️ Age must be greater than 0!");
                        return;
                    }

                    resultText.setText("Hello! My name is " + name + ", I am " + age +
                            " years old and enrolled in " + program + ".");
                } catch (NumberFormatException e) {
                    resultText.setText("⚠️ Please enter a valid number for age!");
                }
            }
        });
    }
}
