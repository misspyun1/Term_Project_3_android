package com.example.administrator.phone;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Administrator on 2017-05-15.
 */


public class Contacts extends ListFragment {
    ListViewAdapter adapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.mipmap.ic_basic_person),"gyuri","01038259628");
        adapter.addItem(ContextCompat.getDrawable(getActivity(),R.mipmap.ic_basic_person),"jiwoo","01024672950");

        return inflater.inflate(R.layout.contacts, container, false);

    }//listview

    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        Person item = (Person) l.getItemAtPosition(position) ;

        String name = item.getName() ;
        String number = item.getNumber() ;
        Drawable iconDrawable = item.getIcon() ;

        // TODO : use item data.
    }

    public void addItem(Drawable icon, String name, String number){
        adapter.addItem(icon, name, number);
    }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu,menu);
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
    }//search actionbar
}

