package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AffineCipher_Decryption extends AppCompatActivity {

    private EditText Ciphertext;
    private TextView Plaintext;
    private Button Process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affine_cipher_decryption);
        Ciphertext=findViewById(R.id.Affine_Ciphertext);
        Plaintext=findViewById(R.id.Affine_plaintext);
        Process=findViewById(R.id.AffineDecryption);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String plaintext=decryption(Ciphertext.getText().toString());
            Plaintext.setText("Plain text:" +plaintext);
            }
        });
    }

    private static String decryption(String CTxt)
    {
        String Msg = "";
        int a = 3;
        int b = 6;
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
            if (flag == 1)
            {
                a_inv = i;
                System.out.println(i);
            }
        }
        for (int i = 0; i < CTxt.length(); i++)
        {
            Msg = Msg + (char) (((a_inv * ((CTxt.charAt(i) - b)) % 26)) + 65);
        }
        return Msg;
    }
}