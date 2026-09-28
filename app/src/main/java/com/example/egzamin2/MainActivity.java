package com.example.egzamin2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class Notatka {
    public String NTitle;
    public String NContent;

     public Notatka(String T, String C) {
         NTitle = T;
         NContent = C;
     }
     @Override
     public String toString() {
         return NTitle  + "\n" + NContent;
     }
}


public class MainActivity extends AppCompatActivity {

    public ListView list;
    public TextView Title, Content;
    public Button Add;
    public ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            list = (ListView) findViewById(R.id.List);
            Title = (TextView) findViewById(R.id.Title);
            Content = (TextView) findViewById(R.id.Content);
            Add = (Button) findViewById(R.id.Add);

            ArrayList<Notatka> Notatki = new ArrayList<Notatka>();

            Notatki.add(new Notatka("tenis","Gra z Ewą w poniedziałek"));

            ArrayAdapter<Notatka> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Notatki);
            list.setAdapter(arrayAdapter);

            arrayAdapter.notifyDataSetChanged();

            Add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String tempTitle = Title.getText().toString();
                    String tempContent = Content.getText().toString();
                    Notatki.add(new Notatka(tempTitle,tempContent));

                    arrayAdapter.notifyDataSetChanged();
                }
            });

            return insets;
        });
    }
}