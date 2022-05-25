package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Substitution_Decryption extends AppCompatActivity {

    private EditText password,key,message;
    private Button process;
    private TextView Dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution_decryption);
        password=findViewById(R.id.substitutionPass2);
        key=findViewById(R.id.substitutionKey2);
        message=findViewById(R.id.substitutionMessage2);
        process=findViewById(R.id.substitutionDec);
        Dec=findViewById(R.id.substitution_decrypttion);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pass=password.getText().toString();
                String keyword=key.getText().toString();
                int keynum=Integer.parseInt(key.getText().toString());
                String msg=message.getText().toString();

                if(keynum>25 || keynum<0){
                    alret();
                    return;
                }
                Dec.setText("Your Decrypted message is: " +Decryption(Pass,keyword,msg,keynum));
            }
        });

    }

    private static String Decryption(String Pass,String keyword,String message,int shiftKey){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encryptedWord = "";
        Character letter;
        String decryptedWord = "";
        for (int i = 0; i < Pass.length(); i++) {
            letter = Pass.charAt(i);
            if (Character.isLetter(letter)) {
                if (i == 0) {
                    keyword += Pass.charAt(i);
                } else if ((keyword.contains(letter.toString()) == false)) {
                    keyword += Pass.charAt(i);
                }
            } else {
                keyword += "";
            }
        }
        for (int i = 0; i < 26; i++) {
            letter = alphabet.charAt(i);
            if ((Pass.toUpperCase().contains(letter.toString())) == false) {
                keyword += letter;
            }
        }
        for (int i = 0; i < message.length(); i++) {
            if (Character.isWhitespace(message.charAt(i))) {
                message += " ";
            } else {
                for (int counter = 0; counter < 26; counter++)
                    if (message.toLowerCase().charAt(i) == keyword.toLowerCase().charAt(counter)) {
                        if (Character.isUpperCase(message.charAt(i))) {
                            {
                                if ((counter - shiftKey) < 0) {
                                    decryptedWord += alphabet.toUpperCase().charAt((counter - shiftKey) + 26);
                                } else {
                                    decryptedWord += alphabet.toUpperCase().charAt(counter - shiftKey);
                                }
                            }
                        } else {
                            if ((counter - shiftKey) < 0) {
                                decryptedWord += alphabet.toLowerCase().charAt((counter - shiftKey) + 26);
                            } else {
                                decryptedWord += alphabet.toLowerCase().charAt(counter - shiftKey);
                            }
                        }
                    }
            }
        }
        return decryptedWord;
    }




    private void alret(){
        AlertDialog.Builder alertDialog;
        alertDialog=new AlertDialog.Builder(Substitution_Decryption.this);
        alertDialog.setTitle("Enter correct Number");
        alertDialog.setMessage("please Enter Correct Number");
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        AlertDialog dialog=alertDialog.create();
        dialog.show();
    }
}