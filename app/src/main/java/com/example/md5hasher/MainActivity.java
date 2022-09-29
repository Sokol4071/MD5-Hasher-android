package com.example.md5hasher;
import android.view.View;
import  android.widget.Button;
import  android.widget.EditText;
import  android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    Button btnCon;
    EditText editTx;
    TextView textPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCon = findViewById(R.id.button);
        editTx = findViewById(R.id.editTextTextPersonName);
        textPass = findViewById(R.id.textView);

        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textPass.setText(getMdHash(editTx.getText().toString()));

            }
        });
    }
        private String getMdHash(String toString){
            String MD5="MD5";

            try {
                MessageDigest digest= MessageDigest.getInstance(MD5);
                digest.update(toString().getBytes());
                byte messagedigest[]=digest.digest();

                StringBuilder hexString = new StringBuilder();

                    for(byte aMsgDigest : messagedigest ){
                        String h = Integer.toHexString(0xFF & aMsgDigest);

                        while(h.length()>2)
                            h= "0" + h;
                            hexString.append(h);


                }
                    return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return "";


        }
    }
