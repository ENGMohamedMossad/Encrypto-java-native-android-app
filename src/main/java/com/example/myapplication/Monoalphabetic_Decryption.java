package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Monoalphabetic_Decryption extends AppCompatActivity {

    private EditText Ciphertext;
    private TextView Plaintext;
    private Button Process;
    private static char normalChar[]
            = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    private static char codedChar[]
            = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monoalphabetic_decryption);
        Ciphertext=findViewById(R.id.Mono_Ciphertext);
        Plaintext=findViewById(R.id.Mono_plaintext);
        Process=findViewById(R.id.MonoDecryption);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plaintext=Decryption(Ciphertext.getText().toString());
                Plaintext.setText("Plain text: " +plaintext);
            }
        });

    }

    public static String Decryption(String s)
    {


        String decryptedString = "";

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = 0; j < 26; j++) {

                if (s.charAt(i) == codedChar[j])
                {
                    decryptedString += normalChar[j];
                    break;
                }
                if (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
                {
                    decryptedString += s.charAt(i);
                    break;
                }
            }
        }
        return decryptedString;
    }
}