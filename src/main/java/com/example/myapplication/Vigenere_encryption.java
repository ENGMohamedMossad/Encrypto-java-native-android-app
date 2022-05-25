package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Vigenere_encryption extends AppCompatActivity {

    EditText key,message;
    TextView Enc;
    Button Encrypt;
    String encMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vigenere_encryption);
        key=findViewById(R.id.VigenereKey);
        message=findViewById(R.id.VigenereMessage);
        Enc=findViewById(R.id.Vig_Encryption);
        Encrypt=findViewById(R.id.VigEnc_process);

        Encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encMessage=Encryption(message.getText().toString(),key.getText().toString());
                Enc.setText("The encrypted message is: "+encMessage);

            }
        });


    }

    public static String Encryption(String Message, String Key) {
        String EMessage = "";
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            EMessage += (char) (((letter - 65) + (Key.charAt(j) - 65)) % 26 + 65);
            j = ++j % Key.length();
        }
        return EMessage;
    }
}