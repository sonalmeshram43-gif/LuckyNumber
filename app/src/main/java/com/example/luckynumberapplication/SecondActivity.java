package com.example.luckynumberapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText, luckyNumber;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText = findViewById(R.id.textview2);
        luckyNumber = findViewById(R.id.lucky_number_txt);
        btn =findViewById(R.id.share_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");


        int random_num = generateRandomNumber();
        luckyNumber.setText(MessageFormat.format("{0}", random_num));




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 shareData(userName,random_num);
            }
        });


    }

    private void shareData(String userName, int randomNum) {
      Intent i = new Intent(Intent.ACTION_SEND);
      i.setType("text/plain");
      i.putExtra(Intent.EXTRA_SUBJECT,userName + "got luck today");
      i.putExtra(Intent.EXTRA_TEXT,"His lucky number is:" + randomNum);
      startActivity(Intent.createChooser(i,"Choose a Platform"));

    }

    public int generateRandomNumber()
    {
        Random random = new Random();
        return random.nextInt(1000) ;
    }
}