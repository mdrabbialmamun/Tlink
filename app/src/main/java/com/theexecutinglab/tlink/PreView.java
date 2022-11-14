package com.theexecutinglab.tlink;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.theexecutinglab.tlink.model.Data;
import com.theexecutinglab.tlink.utlis.Constants;

public class PreView extends AppCompatActivity {
    Data data;
    TextView titleTv,userTv,likeTv,commentTv,shareTv,viewTv;
    ImageView coverIv;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_view);

        Intent intent = getIntent();
        data = (Data) intent.getSerializableExtra("link");

        titleTv = findViewById(R.id.tv_title);
        userTv = findViewById(R.id.tv_proflie_name);
        likeTv = findViewById(R.id.tv_likes);
        commentTv = findViewById(R.id.tv_comments);
        shareTv = findViewById(R.id.tv_share);
        viewTv = findViewById(R.id.tv_views);

        coverIv = findViewById(R.id.cover_image);

        titleTv.setText(data.getTitle());
        userTv.setText(data.getUser());

        likeTv.setText(Constants.formatValue(Double.parseDouble(data.getLikeCount())));
        commentTv.setText(Constants.formatValue(Double.parseDouble(data.getCommentCount())));
        shareTv.setText(Constants.formatValue(Double.parseDouble(data.getShareCount())));
        viewTv.setText(Constants.formatValue(Double.parseDouble(data.getViewCount())));

        Glide.with(this).load(data.getCoverImageLink()).into(coverIv);
    }
}