package com.wnzx.recyclertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView id_recycler;

    private List<String> mDatas;

    private SimplesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatas = new ArrayList<>();

        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add("" + (char) i);
        }

        id_recycler = (RecyclerView) findViewById(R.id.id_recycler);


        adapter = new SimplesAdapter(this, mDatas);
        id_recycler.setAdapter(adapter);

        //RecyclerView布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        id_recycler.setLayoutManager(linearLayoutManager);

        //RecyclerView分割线
        id_recycler.addItemDecoration(new DividerItemDecoration(this
                , DividerItemDecoration.VERTICAL_LIST));

        adapter.setOnItemClickListener(new SimplesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"onClick事件       您点击了第："+position+"个Item",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
