package com.example.wtastudios.todo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by WTA Studios on 3/2/2017.
 */

public class FirstItemAdapter extends RecyclerView.Adapter<FirstItemAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<GetDetailList> data;
    private LayoutInflater inflater;
    public FirstItemAdapter(Context context, ArrayList<GetDetailList> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public FirstItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.add_to_list_first, parent, false);
        MyViewHolder holder= new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FirstItemAdapter.MyViewHolder holder, int position) {

        /*holder.textview1.setText(data.get(position).iconName);
        holder.textview2.setText(data.get(position).url);
        holder.imageView.setImageResource(data.get(position).imageId);*/
        holder.textview1.setText(data.get(position).listitem);

        final int current_position = position;
    //    final DataDetails idDetails = data.get(position);
       /* holder.addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

       /* holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addList(current_position, idDetails);

            }
        });
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                removeList(idDetails);
                return true;
            }
        });*/


    }

   /* private void removeList(DataDetails idDetails) {
        int currPosition = data.indexOf(idDetails);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    private void addList(int current_position, DataDetails idDetails) {
        data.add(current_position, idDetails);
        notifyItemInserted(current_position);
    }*/

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void dismiss(int position){
        data.remove(position);
        this.notifyItemRemoved(position);
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textview1,textview2;
        EditText search_item;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textview1 = (TextView) itemView.findViewById(R.id.list_fs_item);
            //textview2 = (TextView) itemView.findViewById(R.id.eventDesc);
            //search_item = (EditText)itemView.findViewById(R.id.edt_search_input);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Item Clicked at position "+getPosition(), Toast.LENGTH_SHORT).show();

        }
    }
}


