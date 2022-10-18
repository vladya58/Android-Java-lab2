package com.example.lab2j;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class list extends Activity {
    ArrayList <String> data = new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Button b_add = findViewById(R.id.button2);
        Button b_del = findViewById(R.id.button3);
        ListView list = findViewById(R.id.list1);
        EditText input = findViewById(R.id.edtxt);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        list.setAdapter(adapter);
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = input.getText().toString();
                if (!word.isEmpty()) {
                    data.add(word);
                    input.setText("");
                    adapter.notifyDataSetChanged();


                }

            }
        });
        b_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.size() > 0) {
                    data.remove(data.size()-1);
                    adapter.notifyDataSetChanged();
                }

            }
        });


    }
}
