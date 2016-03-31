package com.example.happy_fan.day30_layoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    List<Map<String,Object>> list;
    SimpleAdapter adapter;
    private FrameLayout container;
    private TextView tv_show;
    private Bundle bundle;
    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);
        loadData();
        adapter = new SimpleAdapter(this,list,android.R.layout.activity_list_item,
                new String[]{"name","img"},new int[]{android.R.id.text1,android.R.id.icon});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

        container = (FrameLayout) findViewById(R.id.container);

    }

    private void loadData() {
        list = new ArrayList<>();
        for(int i = 0; i < 100; ++i){
            HashMap<String, Object> map = new HashMap<>();
            map.put("name",String.format("第%03d个",i));
            map.put("img",R.mipmap.ic_launcher);
            list.add(map);
        }

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Map<String, Object> item = (Map<String, Object>) parent.getAdapter().getItem(position);
        String name = (String) item.get("name");
        int img = (int) item.get("img");
        this.bundle = new Bundle();
        bundle.putString("name",name);

        //如果为竖屏
        if(container == null) {
            Intent intent = new Intent(this, SecondActivity.class).putExtras(bundle);
            startActivity(intent);
        }else{
            blankFragment = BlankFragment.newInstance(bundle);
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container,blankFragment).commit();
//            tv_show = ((TextView) findViewById(R.id.tv_show));
//            tv_show.setText(name);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        blankFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,blankFragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }
}
