package com.example.administrator.addressbook;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Administrator on 2017-05-13.
 */

public class Contacts extends AppCompatActivity {

    protected void onCreate(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        inflater.inflate(R.layout.contacts, container, false);

        ListView listview;
        ListViewAdapter listview_adapter = new ListViewAdapter();




        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(listview_adapter);

        listview_adapter.addItem(ContextCompat.getDrawable(this, R.mipmap.ic_basic_person),"gyuri","01038259628");
        listview_adapter.addItem(ContextCompat.getDrawable(this, R.mipmap.ic_basic_person),"jiwoo","01024672959");
        listview_adapter.addItem(ContextCompat.getDrawable(this, R.mipmap.ic_basic_person),"inryu","01044444444");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Person item = (Person) parent.getItemAtPosition(position);

                String name = item.getName();
                String number = item.getNumber();
                Drawable iconDrawable = item.getIcon();

            }
        });

    }//listview
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            public boolean onQueryTextSubmit(String s){
                return false;
            }

            public boolean onQueryTextChange(String s){
                System.out.print(s);
                return false;
            }
        });
        return true;
    }//search actionbar
}
