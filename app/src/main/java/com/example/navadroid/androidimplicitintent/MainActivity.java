package com.example.navadroid.androidimplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

// Ideas from https://www.formget.com/android-intent/
// and https://developer.android.com/guide/components/intents-common.html

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        findViewById(R.id.btn_intent_1).setOnClickListener(this);
        findViewById(R.id.btn_intent_2).setOnClickListener(this);
        findViewById(R.id.btn_intent_3).setOnClickListener(this);
        findViewById(R.id.btn_intent_4).setOnClickListener(this);
        findViewById(R.id.btn_intent_5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_intent_1:
                // TODO: Open media gallery
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(intent);
                break;
            case R.id.btn_intent_2:
                // TODO: call
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0869155193"));
                startActivity(intent);
                break;
            case R.id.btn_intent_3:
                // TODO: Open browser
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https:www.google.co.th"));
                startActivity(intent);

                break;
            case R.id.btn_intent_4:
                // TODO: Open camera
                intent.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);
                break;
            case R.id.btn_intent_5:
                // TODO: send email
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:someone_who_waiting_for_love@example.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Why you still miss him?");
                intent.putExtra(Intent.EXTRA_TEXT, "Just open your eyes, better guy might be around you");
                startActivity(Intent.createChooser(intent, "Send email via"));
                break;

        }
    }
}
