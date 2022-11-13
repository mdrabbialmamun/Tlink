package com.theexecutinglab.tlink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    MaterialButton materialButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edt_url);
        materialButton = findViewById(R.id.submit_Btn);

        materialButton.setOnClickListener(view -> {
            if(validInput()){
                String tiktokUrl = editText.getText().toString();
            }
        });

    }

    private boolean validInput() {
        if (!(editText.getText().toString().contains("tiktok"))){
            editText.setError("Input a valid URL/Link");
            return  false;
        }
        return true;
    }

}