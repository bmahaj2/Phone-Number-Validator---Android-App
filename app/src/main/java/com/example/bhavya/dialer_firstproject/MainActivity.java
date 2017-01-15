package com.example.bhavya.dialer_firstproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDialer;
    Button btnBrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialer=(Button)findViewById(R.id.btn_dialer);

        btnDialer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,Second.class);
                startActivity(i);
            }
        });

        btnBrowser=(Button)findViewById(R.id.btn_browser);

        btnBrowser.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url="https://developer.android.com/index.html";
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });

    }
}
