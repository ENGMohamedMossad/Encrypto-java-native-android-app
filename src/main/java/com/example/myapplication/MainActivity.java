package com.example.myapplication;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radiogroup;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiogroup=(RadioGroup) findViewById(R.id.radioGroup);
        Button Enter=findViewById(R.id.go);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                radioButton=findViewById(checkedId);
                switch (radioButton.getId()){
                    case R.id.Monoalphabetic:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                MonoOptions();
                            }
                        });
                        break;
                    case R.id.vigenere:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                VigenereOptions();
                            }
                        });
                        break;
                    case R.id.substitution:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                substitutionOptions();
                            }
                        });
                        break;
                    case R.id.autoKey:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AutokeynOptions();
                            }
                        });
                        break;
                    case R.id.Affine:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            AffineOptions();
                            }
                        });
                        break;
                    case R.id.RailFence:
                        Enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            RailFenceOptions();
                            }
                        });

                }


            }
        });
    }
    private void MonoOptions(){
        final String[] Options = {"Encryption","Decryption"};
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("choose one ");
        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String Selection=Options[i];
                if(Selection=="Encryption"){
                    Intent intent=new Intent(MainActivity.this, Monoalphabetic_Encryption.class);
                    startActivity(intent);
                }
                if(Selection=="Decryption"){
                    Intent intent=new Intent(MainActivity.this,Monoalphabetic_Decryption.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }
    private void VigenereOptions(){
        final String[] Options = {"Encryption","Decryption"};
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("choose one ");
        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               String Selection=Options[i];
                if(Selection=="Encryption"){
                    Intent intent=new Intent(MainActivity.this, Vigenere_encryption.class);
                    startActivity(intent);
                }
                if(Selection=="Decryption"){
                    Intent intent=new Intent(MainActivity.this,Vigenere_decryption.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }

    private void substitutionOptions() {
        final String[] Options = {"Encryption", "Decryption"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose one");

        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String Selection = Options[i];
                        if(Selection=="Encryption"){
                            Intent intent=new Intent(MainActivity.this, Substitution_Encryption.class);
                            startActivity(intent);
                        }
                        if(Selection=="Decryption"){
                            Intent intent=new Intent(MainActivity.this, Substitution_Decryption.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        builder.show();
    }
    private void AutokeynOptions() {
        final String[] Options = {"Encryption", "Decryption"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose one");
        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String Selection = Options[i];
                        if(Selection=="Encryption"){
                            Intent intent=new Intent(MainActivity.this, AutoKey_Encryption.class);
                            startActivity(intent);
                        }
                        if(Selection=="Decryption"){
                            Intent intent=new Intent(MainActivity.this, AutoKey_Decryption.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        builder.show();
    }
    private void AffineOptions() {
        final String[] Options = {"Encryption", "Decryption"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Choose one");
        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String Selection = Options[i];
                        if(Selection=="Encryption"){
                            Intent intent=new Intent(MainActivity.this, AffineCipher_Encyption.class);
                            startActivity(intent);
                        }
                        if(Selection=="Decryption"){
                            Intent intent=new Intent(MainActivity.this, AffineCipher_Decryption.class);
                            startActivity(intent);
                        }
                    }
                }
        );
        builder.show();
    }
    private void RailFenceOptions(){
        final String[] Options = {"Encryption","Decryption"};
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("choose one ");
        builder.setSingleChoiceItems(Options, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String Selection=Options[i];
                if(Selection=="Encryption"){
                    Intent intent=new Intent(MainActivity.this, RailFence_Encryption.class);
                    startActivity(intent);
                }
                if(Selection=="Decryption"){
                    Intent intent=new Intent(MainActivity.this,RailFence_Decryption.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }

    }
