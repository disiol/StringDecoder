package com.piramideofra.test;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v ->{
            String originalInput = editText.getText().toString();
            String encodedString = Base64.encodeToString(originalInput.getBytes(), Base64.URL_SAFE);
            Log.e("myLog", "encodedString " + encodedString);
            editText.setText(encodedString);


            String s = decodeBase64(encodedString);
            Log.e("myLog", "decodedString " + s);

            textView.setText(s);
        });




    }


    private String decodeBase64(String coded) {
        byte[] valueDecoded = new byte[0];
        try {
            valueDecoded = Base64.decode(coded.getBytes("UTF-8"), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
        }
        return new String(valueDecoded);
    }
}
