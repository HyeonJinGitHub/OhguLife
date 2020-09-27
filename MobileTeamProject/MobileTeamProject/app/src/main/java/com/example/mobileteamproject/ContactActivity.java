package com.example.mobileteamproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase db;
    DBListAdapter adapter;
    Cursor cursor;
    EditText edit_title;
    Typeface myFont;
    ListView list;
    String[] titles = {"학생지원팀", "학생상담센터","취업진로지원팀","공학교육혁신센터",
            "기업인재대학", "기계공학과","기계설계공학과","메카트로닉스공학과","전자공학부","컴퓨터공학부","게임공학부",
            "신소재공학과","생명화학공학과","산업디자인공학과","경영학부","나노-광공학과","에너지-전기공학과","지식융합학부"};
    String[] calls = {"031-8041-0070", "031-8041-1551", "031-8041-0121","031-8041-0050",
            "031-8041-1230", "031-8041-0400","031-8041-0420","031-8041-0450","031-8041-0470","031-8041-0510",
            "031-8041-0550", "031-8041-0580", "031-8041-0610", "031-8041-0660","031-8041-0760",
            "031-8041-0710", "031-8041-0690","031-8041-0739"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        myFont = Typeface.createFromAsset(getApplicationContext().getAssets(),"newfont.ttf");
        edit_title = findViewById(R.id.edit_title);

        dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM contacts", null);

        adapter = new  DBListAdapter(ContactActivity.this);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.putExtra("POSITION", position);
                intent.putExtra("PHONE", calls[position]);

                CustomDialog dialog = new CustomDialog(ContactActivity.this, intent);
                dialog.setTitle(titles[position]);
                dialog.setCancelable(true);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(255, 254,229,137)));
                dialog.show();
            }
        });
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context){
            super(context, "mycontacts.db", null, 3);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE contacts (title TEXT, tel TEXT);");
            for(int i = 0 ; i < 18; i++){
                db.execSQL("INSERT INTO contacts VALUES ('" + titles[i] + "','" + calls[i] + "');");
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }
    class DBListAdapter extends BaseAdapter{
        LayoutInflater inflater;
        public DBListAdapter(Activity activity){ inflater = activity.getLayoutInflater();}
        @Override
        public int getCount() {
            return cursor.getCount(); }
        @Override
        public Object getItem(int position) {
            return null; }
        @Override
        public long getItemId(int position) {
            return 0; }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = inflater.inflate(R.layout.listitem, null);
            }
            TextView title = convertView.findViewById(R.id.title);
            TextView tel = convertView.findViewById(R.id.call_number);

            cursor.moveToPosition(position);
            title.setText(cursor.getString(0));
            tel.setText(cursor.getString(1));

            return convertView;
        }
    }
    public void onSearchClick(View view){
        if(edit_title.getText().toString().isEmpty()){
            cursor = db.rawQuery("SELECT title, tel FROM contacts",null);
        }
        else{
            cursor = db.rawQuery("select title, tel from contacts where title LIKE '%" +
                    edit_title.getText() + "%';", null);
        }
        adapter.notifyDataSetChanged();
    }
}
