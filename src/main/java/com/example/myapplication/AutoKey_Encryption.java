package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AutoKey_Encryption extends AppCompatActivity {

    private EditText Plaintext;
    private TextView Ciphertext;
    Button Process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_key_encryption);
        Plaintext=findViewById(R.id.AutoKeyPlaintext);
        Ciphertext=findViewById(R.id.AutoKey_Cipher);
        Process=findViewById(R.id.AutoKey_Encrypton);
        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String Output = encrypt(Plaintext.getText().toString());
             Ciphertext.setText("Cipher text = "+ Output);
            }
        });


    }
    private static String encrypt(String plainText) {
        int len = plainText.length(), asciiValue, newValue, letterValue, x = 0, counter = 0, nexti = 0;
        String ciphertext = new String();
        char current;
        plainText = plainText.toUpperCase(); // it makes it easier to have it all in one case
        String keyword = "secret";
        keyword = keyword.toUpperCase();

        for (int i = 0; i < keyword.length(); i++) {
            current = plainText.charAt(i);
            if (Character.isSpace(current)) {
                ciphertext += ' ';
                i++;
                current = plainText.charAt(i);
            }

            asciiValue = ((int) current);
            // if it's an uppercase letter, encode it
            if (asciiValue >= 65 && asciiValue <= 90) {
                letterValue = asciiValue - 65;
                newValue = letterValue + (((int) (keyword.charAt(counter))) - 65);
                newValue %= 26;
                ciphertext += (char) (newValue + 65);// add it to the ciphertext
                counter++;
            }
            nexti = i;
        }

        x = 0;
        for (int i = nexti + 1; i < len; i++) {
            char temp = ' ';
            current = plainText.charAt(i);
            if (Character.isSpace(current)) {
                ciphertext += ' ';
                i++;
                current = plainText.charAt(i);
            }

            asciiValue = ((int) current);
            // if it's an uppercase letter, encode it
            if (asciiValue >= 65 && asciiValue <= 90) {
                letterValue = asciiValue - 65;
                temp = ciphertext.charAt(x);
                while (temp == ' ') {
                    x++;
                    temp = ciphertext.charAt(x);
                }

                newValue = letterValue + (((int) (temp)) - 65);// add the shift

                newValue %= 26;
                ciphertext += (char) (newValue + 65);// add it to the ciphertext
                x++;
            }

            temp = ' ';
        }
        System.out.println("Cipher text = " + ciphertext);
        return ciphertext;

    }
}