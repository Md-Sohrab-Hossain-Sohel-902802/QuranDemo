package com.example.qurandemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SuraActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<SuraValues> suraValuesList=new ArrayList<>();
    private  SuraAdapter suraAdapter;
    String arabic;
    String bangla;
    String banglaTranslate;
    int url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura);

        url=getIntent().getIntExtra("url",10);

        DataAccess dataAccess=DataAccess.getInstance(getApplicationContext());
        dataAccess.open();
        Cursor cursor= dataAccess.getSura(url);
        if(cursor.getCount()!=0){
            suraValuesList.clear();
            while (cursor.moveToNext()){
                arabic=cursor.getString(5);
                banglaTranslate=cursor.getString(8);
                bangla=cursor.getString(9);
                SuraValues suraValues=new SuraValues(arabic,banglaTranslate,bangla);
                suraValuesList.add(suraValues);

            }
        }

        recyclerView=findViewById(R.id.suraRecyclerViewid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        suraAdapter=new SuraAdapter(SuraActivity.this,suraValuesList);

        recyclerView.setAdapter(suraAdapter);



    }

    @Override
    protected void onStart() {
        super.onStart();





    }
}
