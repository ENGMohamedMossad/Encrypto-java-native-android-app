package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Monoalphabetic_Encryption extends AppCompatActivity {

    private EditText Plaintext;
    private TextView Ciphertext;
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
        setContentView(R.layout.activity_monoalphabetic_encryption);
        Plaintext=findViewById(R.id.MonoPlaintext);
        Ciphertext=findViewById(R.id.Mono_Cipher);
        Process=findViewById(R.id.MonoEnc);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ciphertext=Encryption(Plaintext.getText().toString());
                Ciphertext.setText("Plain text: "+ciphertext);
            }
        });

    }

    public static String Encryption(String s)
    {
        String encryptedString = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {

                if (s.charAt(i) == normalChar[j])
                {
                    encryptedString += codedChar[j];
                    break;
                }

                if (s.charAt(i) < 'a' || s.charAt(i) > 'z')
                {
                    encryptedString += s.charAt(i);
                    break;
                }
            }
        }

        return encryptedString;
    }

}