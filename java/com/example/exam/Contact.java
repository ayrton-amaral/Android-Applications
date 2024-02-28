package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class Contact extends AppCompatActivity {

    Button buttonAddToList;
    EditText editTextName;
    EditText editTextNumber;
    ListView listView;

    static List<String> listContacts = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact);

        buttonAddToList = findViewById(R.id.btnAddList);
            listView = findViewById(R.id.listView);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text1, listContacts);
            listView.setAdapter(adapter);

        buttonAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName = findViewById(R.id.name);
                editTextNumber = findViewById(R.id.phoneNumber);

                listContacts.add(editTextName.getText().toString() + " - " + editTextNumber.getText().toString());
                adapter.notifyDataSetChanged();
            }
       });
    }
}