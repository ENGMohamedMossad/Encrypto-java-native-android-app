package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AutoKey_Decryption extends AppCompatActivity {
    private EditText Ciphertext;
    private TextView Plaintext;
    Button Process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_key_decryption);
        Ciphertext=findViewById(R.id.autoKeyCiphertext);
        Plaintext=findViewById(R.id.autoKey_Plain);
        Process=findViewById(R.id.AutoKey_decryption);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Output=decrypt(Ciphertext.getText().toString());
                Plaintext.setText("Plaintext text = "+Output);
            }
        });
    }

    private static String decrypt(String ciphertext) {

        int x = 0, len = ciphertext.length(), asciiValue, newValue, letterValue, y = 0;
        String plaintext = new String();
        char current, temp = ' ';
        ciphertext = ciphertext.toLowerCase();// it makes it easier to have it all in one case
        String keyy = "secret";
        int keywordLength = keyy.length();

        for (int i = 0; i < keywordLength; i++) {
            if (x < ciphertext.length()) {
                plaintext += ciphertext.charAt(x);
                x++;

                if (Character.isSpace(ciphertext.charAt(x - 1))) {
                    plaintext += ciphertext.charAt(x);
                    x++;
                }
                y = x;
            }
        }

        x = 0;
        for (int i = 0; i < (len - y); i++) {

            current = ciphertext.charAt(i + y);
            if (Character.isSpace(current))
                plaintext += ' ';

            else {
                asciiValue = ((int) current);
                if (asciiValue >= 97 && asciiValue <= 122) {
                    letterValue = asciiValue - 97;

                    temp = ciphertext.charAt(x);
                    while (temp == ' ') {
                        x++;
                        temp = ciphertext.charAt(x);
                    }

                    newValue = letterValue - (((int) (temp)) - 97); // take off the shift
                    newValue %= 26;
                    // if we've gone below 0, we add 26, which has the effect of wrapping around to
                    // the end of the alphabet
                    if (newValue < 0)
                        newValue += 26;

                    plaintext += (char) (newValue + 97);// add it to the plaintext
                    x++;
                }
            }
            temp = ' ';
        }
        System.out.println("Plaintext text = " + plaintext);
        return plaintext;
    }
}