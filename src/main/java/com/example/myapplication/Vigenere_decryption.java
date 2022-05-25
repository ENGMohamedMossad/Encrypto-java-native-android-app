package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Vigenere_decryption extends AppCompatActivity {

    EditText key,message;
    TextView Dec;
    Button Decryption;
    String Decmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_decryption);
        key=findViewById(R.id.vigenereKey2);
        message=findViewById(R.id.vigenereMessage2);
        Decryption=findViewById(R.id.VigDec_process);
        Dec=findViewById(R.id.vig_Decryption);

        Decryption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Decmessage=Decryption(message.getText().toString(),key.getText().toString());
                Dec.setText("The decrypted message is: "+ Decmessage);
            }
        });

    }

    public static String Decryption(String Message, String Key) {
        String DMessage = "";
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            DMessage += (char) ((letter - Key.charAt(j) + 26) % 26 + 65);
            j = ++j % Key.length();
        }
        return DMessage;
    }
}