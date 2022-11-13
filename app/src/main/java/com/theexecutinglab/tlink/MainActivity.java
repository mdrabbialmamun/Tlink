package com.theexecutinglab.tlink;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;
import com.theexecutinglab.tlink.utlis.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    JsonObjectRequest jsonObjectRequest;
    RequestQueue requestQueue;

    EditText editText;
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
                String tiktokUrl = editText.getText().toString();
                //downloadLink(tiktokUrl);
                jsonCall(tiktokUrl);
            }
        });

    }

    private void jsonCall(String t_url) {
        String url = Constants.LINK + t_url;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                //vdo
                JSONObject jsonObject = response.getJSONObject("video_data");
                String hqVideo = jsonObject.getString("nwm_video_url");
                String video = jsonObject.getString("nwm_video_url_HQ");
                //music
                jsonObject = response.getJSONObject("music");
                JSONObject jsonObject1 = jsonObject.getJSONObject("play_url");
                String musicLink = jsonObject1.getString("uri");
                Log.d("Link", musicLink);

                DownloadManager.Request request =new DownloadManager.Request(Uri.parse(hqVideo));
                request.setTitle("File download.");
                request.setDescription("File downloading...");
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> Toast.makeText(this, "" + error, Toast.LENGTH_SHORT).show());

        requestQueue.add(jsonObjectRequest);
    }

    private boolean validInput() {
        if (!(editText.getText().toString().contains("tiktok"))) {
            editText.setError("Input a valid URL/Link");
            return false;
        }
        return true;
    }

}