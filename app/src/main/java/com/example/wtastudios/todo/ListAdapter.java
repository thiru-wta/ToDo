package com.example.wtastudios.todo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by WTA on 2/22/2017.
 */

public class ListAdapter extends BaseExpandableListAdapter implements View.OnClickListener{
   private Context context;
   public List<String> listTitles;     // why we need to use private modifier
   public HashMap<String, List<String>> listDetails;
    EditText addItem;
    TextView txtItems;
    EditText etAddItem;
    String childItems;

    public ListAdapter(Context context, List<String> listTitles, HashMap<String, List<String>> listDetails){
        this.context=context;
        this.listTitles=listTitles;
        this.listDetails=listDetails;

    }
    @Override
    public int getGroupCount() {
        return listTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listDetails.get(listTitles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listDetails.get(listTitles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String titles = (String)getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.list_item,null);
        }
        TextView txtList= (TextView) convertView.findViewById(R.id.textListName);
        TextView txtAdd= (TextView) convertView.findViewById(R.id.addActivity);

//        txt.setTypeface(null, Typeface.BOLD);
        txtList.setText(titles);
        txtAdd.setOnClickListener(this);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String items = (String) getChild(groupPosition, childPosition);
        if(convertView==null){
            LayoutInflater linf = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = linf.inflate(R.layout.list_items,null);

        }
        txtItems = (TextView) convertView.findViewById(R.id.listItems);
        etAddItem = (EditText)convertView.findViewById(R.id.addITemToList1);
        childItems = etAddItem.getText().toString();
        txtItems.setText(childItems);
        return  convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onClick(View view) {
//        addItem=(EditText)
        Toast.makeText(context, "Add activity to the list", Toast.LENGTH_SHORT).show();
    }
}
