package com.example.android.listviewandadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //Getting the strings which we have to show on the list view from resources folder
        final String[] countryNames = getResources().getStringArray(R.array.country_name);

        /*
        Array adapter is used to bind the content of the list view to our actual list view with a TextView style which we have created
        Array adapter constructor needs 4 parameters - 1.activity 2.which layout to follow 3.which style of TextView to follow 4.contents of the list
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.sample, R.id.textView, countryNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            /*
            Parameters function 1.refers which adapter we are using 2.refers the TextView we have added 3.position of the list view content
            4.id for each element on the list view
             */
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Accessing the array items on click from the array @countryNames with the position using as index
                String message = countryNames[position];
                Toast.makeText(MainActivity.this, message + " " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
