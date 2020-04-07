package com.example.qurandemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String name,id,serial,url;

    private RecyclerView recyclerView;

    private List<SuraHandelar> suraHandelarList=new ArrayList<>();
    private  BlessingsAdapters adapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

recyclerView=findViewById(R.id.suraListRecyclerViewid);


recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(this));

adapters=new BlessingsAdapters(MainActivity.this,suraHandelarList);
recyclerView.setAdapter(adapters);


adapters.setOnItemClickListener(new BlessingsAdapters.OnItemClickListner() {
    @Override
    public void OnItemClick(int position) {
        Intent intent=new Intent(MainActivity.this,SuraActivity.class);
        int value=position+1;
        intent.putExtra("url",position+1);
   startActivity(intent);
    }
});




    }

    @Override
    protected void onStart() {
        super.onStart();

        DataAccess dataAccess=DataAccess.getInstance(getApplicationContext());
        dataAccess.open();

        Cursor cursor= dataAccess.displaysura();
        if(cursor.getCount()!=0){
            suraHandelarList.clear();
            while (cursor.moveToNext()){
                 serial=cursor.getString(0);
                 name=cursor.getString(3);
                 SuraHandelar suraHandelar=new SuraHandelar(name,serial);
                suraHandelarList.add(suraHandelar);
                adapters.notifyDataSetChanged();

            }
        }
    }
}
