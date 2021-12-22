package com.example.scorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> code;
    ArrayList<String> name;
    ArrayList<String> score;
    ArrayList<String> id;
    Context c;



    public CustomAdapter(ArrayList<String> code, ArrayList<String> name, ArrayList<String> score, ArrayList<String> id, Context c) {
        this.code = code;
        this.name = name;
        this.score = score;
        this.id = id;
        this.c = c;


    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //notifyDataSetChanged();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        holder.code.setText(code.get(holder.getAdapterPosition()));
        holder.name.setText(name.get(holder.getAdapterPosition()));
        holder.score.setText((CharSequence) score.get(holder.getAdapterPosition()));
        holder.id.setText(id.get(holder.getAdapterPosition()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c,code.get(holder.getAdapterPosition()),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return code.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView code,name,score,id;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            code=itemView.findViewById(R.id.code);
            name=itemView.findViewById(R.id.name);
            score=itemView.findViewById(R.id.score);
            id=itemView.findViewById(R.id.id);
        }
    }
}








