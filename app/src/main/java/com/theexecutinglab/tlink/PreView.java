package com.theexecutinglab.tlink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.theexecutinglab.tlink.model.Data;

public class PreView extends AppCompatActivity {
    Data data;
    TextView textView;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_view);

        Intent intent = getIntent();
        data = (Data) intent.getSerializableExtra("link");
        textView = findViewById(R.id.textView);

        textView.setText(data.getHdVidLink()+"\n"+data.getNormalVidLink()+"\n"+data.getMusicLink());

    }
}