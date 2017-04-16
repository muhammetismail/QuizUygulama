package com.example.mke_a.quizuygulama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Sayfa3 extends AppCompatActivity {
  
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa3);
        edit=(EditText)findViewById(R.id.text1);
        
    }

    public void tikla(View view) throws FileNotFoundException {
        
        PrintStream out = new PrintStream(openFileOutput("out.txt",MODE_PRIVATE));
        out.println(edit.getText().toString());

       // Scanner scan = new Scanner(openFileInput("out.txt",MODE_PRIVATE));
    }



}
