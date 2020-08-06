package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button btnNext;
    private RadioButton rd1, rd2, rd3, rd4;
    private TextView txtq;
    String correctAnswer = "";
    int score=0;
    int qno=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnNext = findViewById(R.id.btnNext);
        rd1 = findViewById(R.id.rd1);
        rd2 = findViewById(R.id.rd2);
        rd3 = findViewById(R.id.rd3);
        rd4 = findViewById(R.id.rd4);
        txtq = findViewById(R.id.txtq);

        DbHelperQuiz db = new DbHelperQuiz(this);
        final Cursor c = db.getData();
        c.moveToNext();
        txtq.setText(c.getString(2));
        rd1.setText(c.getString(3));
        rd2.setText(c.getString(4));
        rd3.setText(c.getString(5));
        rd4.setText(c.getString(6));
        correctAnswer = c.getString(7);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String selected="";
               if (rd1.isChecked())
                   selected=rd1.getText().toString();
               else if (rd2.isChecked())
                   selected=rd2.getText().toString();
               else if (rd3.isChecked())
                   selected=rd3.getText().toString();
               else if (rd4.isChecked())
                   selected=rd4.getText().toString();

               if (selected.equals(correctAnswer))
                   score++;
               qno++;
               if (qno==3){
                   Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                   intent.putExtra("Score",score);
                   startActivity(intent);
               }
                c.moveToNext();
                txtq.setText(c.getString(2));
                rd1.setTag(c.getString(3));
                rd2.setTag(c.getString(4));
                rd3.setTag(c.getString(5));
                rd4.setTag(c.getString(6));
                correctAnswer = c.getString(7);
            }
        });
}
}
