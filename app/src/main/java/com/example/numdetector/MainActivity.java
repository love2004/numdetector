package com.example.numdetector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editTextNumber;
    Button button;
    private static String CHINESE_LETTER_DIGIT_REGEX = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLetterDigitOrChinese(editTextNumber.getText().toString())) {
                    if (Integer.parseInt(editTextNumber.getText().toString()) % 2 == 0) {
                        textView.setText("偶數");
                    } else {
                        textView.setText("奇數");
                    }
                }else {
                    textView.setText("錯誤");
                }
            }
        });

    }

    public static boolean isLetterDigitOrChinese(String str) {
        return str.matches(CHINESE_LETTER_DIGIT_REGEX);
    }


}