package com.example.mke_a.quizuygulama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Sayfa4 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final int MULTIPLE_CHOICE_COUNT =5;

    ArrayList<String> array;
    private ListView list;
    private ArrayAdapter<String> adapter;

    private HashMap<String, String> dict;
    int a=0;
    private ArrayList<String> definitions;

    private String currentWord ="";
    TextView puan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa4);
        dict = new HashMap<>();
        puan =(TextView)findViewById(R.id.textView4);
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.word));
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] words = line.split("\t");
            dict.put(words[0],words[1]);
        }
        scanner.close();

        definitions = new ArrayList<>();
        array = new ArrayList<>(dict.keySet());


        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
       // set adapter to listview
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(this);

       random();

    }

    public void random()
    {
        Collections.shuffle(array);
        String word = array.get(0);


        //ask question
        TextView the_word = (TextView) findViewById(R.id.my_word);
        the_word.setText(word);
        currentWord = word;

        definitions.clear();
        for(int i=0; i< MULTIPLE_CHOICE_COUNT; i++){
            definitions.add(dict.get(array.get(i)));
        }
        Collections.shuffle(definitions);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, definitions);

        list.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(dict.get(currentWord).equals(list.getItemAtPosition(position).toString())){
            a+=10;
            String ok = Integer.toString(a);
            puan.setText(ok);
            Toast.makeText(this, "TEBRİKLER :)",Toast.LENGTH_SHORT).show();
            random();
        }
        else{
            a-=5;
            String ok = Integer.toString(a);
            puan.setText(ok);

            Toast.makeText(this, "YANLIŞ DAHA ÇOK ALIŞTIRMA YAP !!",Toast.LENGTH_SHORT).show();
        }

    }
}
