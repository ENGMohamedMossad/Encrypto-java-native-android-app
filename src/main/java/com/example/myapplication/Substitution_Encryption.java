package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Substitution_Encryption extends AppCompatActivity {

    private EditText password,key,message;
    private Button process;
    private TextView Enc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution_encryption);
        password=findViewById(R.id.SubstitutionPass);
        key=findViewById(R.id.SubstitutionKey);
        message=findViewById(R.id.SubstitutionMessage);
        process=findViewById(R.id.SubstitutionEnc);
        Enc=findViewById(R.id.Substitution_Encryption);


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

                 Enc.setText("Your encrypted message is: "+Encryption(Pass,keyword,msg,keynum));
             }
         });


    }
    private static String Encryption(String Pass,String keyword,String message,int shiftKey){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encryptedWord = "";
        Character letter;
        for (int i = 0; i < Pass.length(); i++) {
            letter = Pass.charAt(i);
            if (Character.isLetter(letter)) {
                if (i == 0) {
                    keyword += Pass.charAt(i);
                } else if ((keyword.contains(letter.toString()) == false)) {
                    keyword += Pass.charAt(i);
                }
            }

            else {
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
                encryptedWord += " ";
            } else {
                for (int counter = 0; counter < 26; counter++)

                    if (message.toLowerCase().charAt(i) == alphabet.toLowerCase().charAt(counter)) {

                        if (Character.isUpperCase(message.charAt(i))) {
                            {

                                if ((counter + shiftKey) > 25) {

                                    encryptedWord += keyword.toUpperCase().charAt((counter + shiftKey) - 26);
                                }

                                else {
                                    encryptedWord += keyword.toUpperCase().charAt(counter + shiftKey);
                                }
                            }
                        }

                        else {
                            if ((counter + shiftKey) > 25) {
                                encryptedWord += keyword.toLowerCase().charAt((counter + shiftKey) - 26);
                            } else {
                                encryptedWord += keyword.toLowerCase().charAt(counter + shiftKey);
                            }
                        }
                    }
            }
        }
        return  encryptedWord;

    }
    private void alret(){
        AlertDialog.Builder alertDialog;
        alertDialog=new AlertDialog.Builder(Substitution_Encryption.this);
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