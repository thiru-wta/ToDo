package com.example.wtastudios.todo;

import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    Context context;
    public Database(Context context) {
        super(context, "WTas1", null, 1);
        this.context = context;

    }


    @Override
    public void onCreate(SQLiteDatabase db1) {

        db1.execSQL("create table if not exists User_sign_up(name varchar(20),email varchar(20),password varchar(20))");
        db1.execSQL("create table if not exists first_item(searchItem varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int arg1, int arg2) {


    }


    public void regData(String sn, String se, String sp) {

        SQLiteDatabase db1=getWritableDatabase();
        db1.execSQL("insert into User_sign_up values('"+sn+"','"+se+"','"+sp+"')");
    }

    /*public String showDetails(String s1) {

        SQLiteDatabase db1=getReadableDatabase();
        ArrayList<String> arrl=new ArrayList<String>();
        Cursor cur=db1.rawQuery("select * from User_sign_up where name ='"+s1+"'",null);
        cur.moveToFirst();
        String as = null;
        if(cur!=null){
            do{
                int ca1=cur.getColumnIndex("name");//name'ld be same as given in db.
                int email=cur.getColumnIndex("email");

                int pass=cur.getColumnIndex("password");

                String str=cur.getString(ca1);
                String str1=cur.getString(email);

                String str3=cur.getString(pass);
                as=str+"#"+str1+"#"+str3;
            } while (cur.moveToNext());
            System.out.println("will it retrieve correct details");
        }
        return as;
    }*/


    public int validateData(String email, String password) {
        int count= 0;
        SQLiteDatabase db1=getReadableDatabase();
        Cursor cursor = db1.rawQuery("select * from User_sign_up where name='"+email+"' and password='"+password+"",null);
        if(cursor!=null){
            count = cursor.getCount();
        }

        return  count;
    }

    public void setFirstItemToList(String item) {
        SQLiteDatabase db1=getWritableDatabase();
        db1.execSQL("insert into first_item values('"+item+"')");
    }

    public ArrayList<GetDetailList> getListItem() {

        SQLiteDatabase db1=getReadableDatabase();
        ArrayList<GetDetailList> list_item = new ArrayList<GetDetailList>();
        Cursor c=db1.rawQuery("select * from first_item",null);
        c.moveToFirst();
        if (c!=null) {
            do {
                GetDetailList getlist = new GetDetailList();
                int c1=c.getColumnIndex("searchItem");
                getlist.listitem=c.getString(c1);
                /*String str=c.getString(c1);
                list_item.add(str);*/
                list_item.add(getlist);
            } while (c.moveToNext());

        }

        return list_item;
    }
}
