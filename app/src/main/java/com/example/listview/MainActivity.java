package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView lv_messages;
EditText edt_messages;
Button btn_add;
    ArrayList<String>messages=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            messages=savedInstanceState.getStringArrayList("messages");

        }
        edt_messages=findViewById(R.id.edt_message);
        lv_messages=findViewById(R.id.lv_messages);
        lv_messages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),messages.get(i),Toast.LENGTH_SHORT).show();

            }
        });
        final ArrayAdapter<String>messages_adapter=new ArrayAdapter<>(getApplicationContext(),R.layout.list_item,messages);
        lv_messages.setAdapter(messages_adapter);
        btn_add=findViewById(R.id.btn_add);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
messages.add(edt_messages.getText().toString());
edt_messages.setText("");
messages_adapter.notifyDataSetChanged();


               // Toast.makeText(getApplicationContext(),edt_messages.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        messages_adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("messages",messages);
    }
}
