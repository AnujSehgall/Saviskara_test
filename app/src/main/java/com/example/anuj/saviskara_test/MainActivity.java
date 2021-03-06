package com.example.anuj.saviskara_test;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.listview);
        ContentAdapter adapter = new ContentAdapter(MainActivity.this,DataModel.movies);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //We are passing Bundle to activity, these lines will animate when we laucnh activity
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                        Pair.create(view,"selectedMovie")
                ).toBundle();

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("bg",DataModel.background[i]);
                intent.putExtra("cover",DataModel.cover[i]);
                intent.putExtra("title",DataModel.movies[i]);
                intent.putExtra("plot",DataModel.plot[i]);
                startActivity(intent,bundle);

            }
        });
    }
}
