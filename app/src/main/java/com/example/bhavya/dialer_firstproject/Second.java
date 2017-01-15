package com.example.bhavya.dialer_firstproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.*;

public class Second extends AppCompatActivity {
    Button Dialerbtn;
    EditText num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Dialerbtn=(Button)findViewById(R.id.dialerbtn);
        num=(EditText)findViewById(R.id.numText);

        Dialerbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String number=num.getText().toString();
                boolean makeChange=false;
                String pat_mat="";
                String expression = "(\\(\\d{3}\\))\\s{0,1}\\d{3}\\-\\d{4}";
                Pattern pattern = Pattern.compile(expression);

                Matcher matcher = pattern.matcher(number);
                if(matcher.find())
                {
                    makeChange=true;
                    number=matcher.group();

                }
                //if(matcher.matches()){
                  //  makeChange = true;
                //}
                //if(number.length()==14 && number.charAt(0)=='(' && number.charAt(4)==')' &&
                  //      number.charAt(5)==' ' && number.charAt(9)=='-')
                    //makeChange=true;

                if(makeChange==true) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:" + number.toString()));
                    startActivity(i);
                }
            }
        });
    }
}
