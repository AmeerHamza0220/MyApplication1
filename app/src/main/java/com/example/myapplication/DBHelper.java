package com.example.myapplication;
    import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context,"EMPDB",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE EMPLOYEE " +
                            "(ID String PRIMARY KEY, NAME TEXT,  pass INTEGER)");
            db.execSQL("insert into EMPLOYEE values(1,'ali',1)");
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
        public ArrayList<Employee> getAllEmployees(){
            ArrayList<Employee> employeeList = new ArrayList<>();
            String columns[] = {"id","name","pass"};
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor =
                    db.query(false,"employee",columns,null,null,null,null,null,null);
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false){
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                int pass = cursor.getInt(2);

                Employee objEmp = new Employee(id,name,pass);
                employeeList.add(objEmp);
                cursor.moveToNext();
            }
            db.close();
            return employeeList;
        }
    }

