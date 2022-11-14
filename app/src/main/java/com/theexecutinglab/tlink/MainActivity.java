package com.theexecutinglab.tlink;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.theexecutinglab.tlink.model.Data;
import com.theexecutinglab.tlink.utlis.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;

    TextInputLayout editText;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edt_url);
        materialButton = findViewById(R.id.submit_Btn);


        requestQueue = Volley.newRequestQueue(this);

        materialButton.setOnClickListener(view -> {
            if (validInput()) {
                String tiktokUrl = Objects.requireNonNull(editText.getEditText()).getText().toString();
                //downloadLink(tiktokUrl);
                jsonCall(tiktokUrl);
            }
        });

    }

    private void jsonCall(String t_url) {
        String url = Constants.LINK + t_url;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                //author_details
                String title = response.getString("desc");
                JSONObject author = response.getJSONObject("author");
                String user = author.getString("nickname");
                //To Do Cover
//                cover_data": {
//                "cover": {
//                    "uri": "large/tos-alisg-p-0037/54af52edbacb4a859f5119c6907709bf_1664865053",
//                            "url_list":
                JSONObject coverData = response.getJSONObject("cover_data");
                JSONObject cover = coverData.getJSONObject("cover");
                JSONArray cover_Link = cover.getJSONArray("url_list");
                String coverImageLink = cover_Link.getString(0);


                //Statistics
                JSONObject stat = response.getJSONObject("statistics");
                String likeCount = stat.getString("digg_count");
                String commentCount = stat.getString("comment_count");
                String shareCount = stat.getString("share_count");
                String viewCount = stat.getString("play_count");

                Log.d("like count",likeCount);

                //vdo
                JSONObject jsonObject = response.getJSONObject("video_data");
                String hqVideo = jsonObject.getString("nwm_video_url");
                String video = jsonObject.getString("nwm_video_url_HQ");

                //music
                jsonObject = response.getJSONObject("music");
                JSONObject jsonObject1 = jsonObject.getJSONObject("play_url");
                String music = jsonObject1.getString("uri");


                Data data = new Data(coverImageLink,title,user,likeCount,commentCount,shareCount,viewCount,video,hqVideo,music);
                Intent intent = new Intent(this,PreView.class);
                intent.putExtra("link",data);
                startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonObjectRequest);
    }

    private boolean validInput() {
        if (!(Objects.requireNonNull(editText.getEditText()).getText().toString().contains("tiktok.com"))) {
            editText.setError("Input a valid URL/Link");
            return false;
        }
        return true;
    }

}