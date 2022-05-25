package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AffineCipher_Encyption extends AppCompatActivity {

    private EditText Plaintext;
    private TextView Ciphertext;
    private Button Process;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affine_cipher_encyption);
        Plaintext=findViewById(R.id.AffinePlaintext);
        Ciphertext=findViewById(R.id.Affine_Cipher);
        Process=findViewById(R.id.Affine_Encrypton);
        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ciphertext=encryption(Plaintext.getText().toString());
                Ciphertext.setText("Cipher text: "+ciphertext);
            }
        });

    }
    public static String encryption(String Msg)
    {
        String CTxt = "";
        int a = 3;
        int b = 6;
        for (int i = 0; i < Msg.length(); i++)
        {
            CTxt = CTxt + (char) ((((a * Msg.charAt(i)) + b) % 26) + 65);
        }
        return CTxt;
    }

}