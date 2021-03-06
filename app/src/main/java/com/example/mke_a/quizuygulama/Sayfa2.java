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

public class Sayfa2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final int MULTIPLE_CHOICE_COUNT =5;

    ArrayList<String> array;
    private ListView list;
    private ArrayAdapter<String> adapter;

    private HashMap<String, String> dict;

    private ArrayList<String> definitions;

    private String currentWord ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);

        dict = new HashMap<>();

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

        TextView the_word = (TextView) findViewById(R.id.my_word);

        if(dict.get(currentWord).equals(list.getItemAtPosition(position).toString())){
            the_word.setText(currentWord);
            random();
        }

    }
}
