package com.example.administrator.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017-05-13.
 */

public class ListViewAdapter extends BaseAdapter{
    private ArrayList<Person> PersonList = new ArrayList<Person>();

    public ListViewAdapter() {

    }
    @Override
    public int getCount(){
        return PersonList.size();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos= position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }//person layout을 inflate하여 convertview 참조 획득

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1) ;
        TextView NameTextView = (TextView) convertView.findViewById(R.id.textView1) ;
        TextView NumberTextView = (TextView) convertView.findViewById(R.id.textView2) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Person person = PersonList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(person.getIcon());
        NameTextView.setText(person.getName());
        NumberTextView.setText(person.getNumber());

        return convertView;

    }

    @Override
    public long getItemId(int position){
        return  position ;
    }

    public Object getItem(int position){
        return PersonList.get(position);
    }

    public void addItem(Drawable icon, String name, String number){
        Person item = new Person();

        item.setIcon(icon);
        item.setName(name);
        item.setNumber(number);

        PersonList.add(item);

    }


}
