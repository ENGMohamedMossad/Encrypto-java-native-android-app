package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RailFence_Decryption extends AppCompatActivity {

    private EditText Ciphertext,Depth;
    private TextView Dec;
    private Button Process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rail_fence_decryption);
        Ciphertext=findViewById(R.id.railCiphertext);
        Depth=findViewById(R.id.railDepth2);
        Dec=findViewById(R.id.rail_Decryption);
        Process=findViewById(R.id.railDec_process);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int depth=Integer.parseInt(Depth.getText().toString());
                String Plaintext=Decryption(Ciphertext.getText().toString(),depth);
                Dec.setText("Decrypted text is: "+Plaintext);
            }
        });

    }
    public static String Decryption(String cipherText,int depth)
    {
        int r=depth,len=cipherText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;

        String plainText="";

        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                plainText+=mat[j][i];
            }
        }
        return plainText;
    }
}

