package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RailFence_Encryption extends AppCompatActivity {

    private EditText Plaintext,Depth;
    private TextView Enc;
    private Button Process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rail_fence_encryption);
        Plaintext=findViewById(R.id.RailPlaintext);
        Depth=findViewById(R.id.RailDepth);
        Enc=findViewById(R.id.Rail_Encryption);
        Process=findViewById(R.id.RailEnc_process);

        Process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            int depth=Integer.parseInt(Depth.getText().toString());
            String Ciphertext=Encryption(Plaintext.getText().toString(),depth);
            Enc.setText("Encrypted text is: "+Ciphertext);
            }
        });

    }

   public static String Encryption(String plainText,int depth)
    {
        int r=depth,len=plainText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;

        String cipherText="";

        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                if(k!=len)
                    mat[j][i]=plainText.charAt(k++);
                else
                    mat[j][i]='X';
            }
        }
        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                cipherText+=mat[i][j];
            }
        }
        System.out.println(cipherText);
        return cipherText;
    }
}