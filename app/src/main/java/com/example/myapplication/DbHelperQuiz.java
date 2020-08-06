package com.example.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class DbHelperQuiz extends SQLiteOpenHelper {
    SQLiteDatabase db = getWritableDatabase();

    public DbHelperQuiz(Context context){
        super(context,"Quiz",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Questions (ID INTEGER PRIMARY KEY AUTOINCREMENT,Subject text,QUESTIONS TEXT,OPTION1 TEXT,OPTION2 TEXT,OPTION3 TEXT,option4 text, ANSWER TEXT)");
        db.execSQL("Insert into Questions (subject,questions,option1,option2,option3,option4,answer) values('MPL','What MPL stand for?','Modern Program langauge','Mini Porgramming lanuguage','Muti Progrmmming language','Modern Programming language','Modern Programming language')");
        db.execSQL("Insert into Questions (subject,questions,option1,option2,option3,option4,answer) values('MPL','What MPL stand for?','Modern Program langauge','Mini Porgramming lanuguage','Muti Progrmmming language','Modern Programming language','Modern Programming language')");
        db.execSQL("Insert into Questions (subject,questions,option1,option2,option3,option4,answer) values('MPL','What MPL stand for?','Modern Program langauge','Mini Porgramming lanuguage','Muti Progrmmming language','Modern Programming language','Modern Programming language')");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public boolean insertEmployee(String id, String name,  int pass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);

        contentValues.put("pass",pass);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert("EMPLOYEE",null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean updateEmployee(String id, String name, int pass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);

        contentValues.put("pass",pass);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.update("EMPLOYEE",contentValues,"id=?",new
                String[]{id+""});
        if(result == 0){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteEmployee(int id){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("EMPLOYEE","id=?",new String[]{id+""});
        if(result == 0){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData(){
        String query="SELECT * FROM Questions";
        Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }
}

