package com.example.mke_a.quizuygulama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1= (Button)findViewById(R.id.button);
        b2= (Button)findViewById(R.id.button2);
        b3= (Button)findViewById(R.id.button3);


    }

    public void sayfa2(View view) {
        Intent intent = new Intent(this,Sayfa2.class);
         startActivity(intent);
    }
    public void sayfa3(View view) {
        Intent intent = new Intent(this,Sayfa3.class);
        startActivity(intent);
    }
    public void sayfa4(View view) {
        Intent intent = new Intent(this,Sayfa4.class);
        startActivity(intent);
    }
}
