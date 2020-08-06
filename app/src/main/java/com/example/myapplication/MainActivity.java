package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    TextView et1,et2;
    Button  btnlogin;

   // private RecyclerView.LayoutManager layoutManager;
   // private RecyclerView recyclerView;
   private ArrayList<Employee> data;
    Spinner spnrsub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnrsub = (Spinner) findViewById(R.id.spnrsub);

        String[] listCities = new String[]{"Islamabad", "Lahore",
                "Rawalpindi"};
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, listCities);
        spnrsub.setAdapter(adapter);


     //   layoutManager = new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(layoutManager);
        DBHelper objHelper = new DBHelper(MainActivity.this);
        objHelper.insertEmployee("12-13","Ali",1212);
        objHelper.insertEmployee("12-13","Ali",1212);
        objHelper.insertEmployee("12-13","Ali",1212);



       data = objHelper.getAllEmployees();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid=   et1.getText().toString();
                int upass= Integer.parseInt(et2.getText().toString());
                for(int i=0;i<data.size();i++){
                    if(data.get(i).id.equals(uid)&& data.get(i).pass==(upass)){
                        Intent intent = new Intent(MainActivity.this,
                                SecondActivity.class) ;
                        Bundle bundle = new Bundle();

                        //     bundle.putString("USER_ID",editTextId.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }

            }
        });

       // CustomAdapter objAdapter = new CustomAdapter(MainActivity.this,data);
       // recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
       // recyclerView.setAdapter(objAdapter);
    }
}
