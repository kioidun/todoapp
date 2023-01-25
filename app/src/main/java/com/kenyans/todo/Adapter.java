package com.kenyans.todo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    //View view;
    Context context;
    ArrayList<String> arrayList;
    TodoListener todoListener;
    ArrayList<String> arrayList_0 = new ArrayList<>();

    public Adapter(Context context, ArrayList<String> arrayList, TodoListener todoListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.todoListener = todoListener;
    }

//   public View getView(){
//        return view;
//   }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(arrayList != null && arrayList.size() > 0){
            holder.checkBox.setText(arrayList.get(position));
            //holder.checkBox.setTextColor(Color.BLACK);
            holder.checkBox.setOnClickListener(view -> {
                if(holder.checkBox.isChecked()){
                    arrayList_0.add(arrayList.get(position));
                }else{
                    arrayList_0.remove(arrayList.get(position));
                }
                todoListener.onTodoChange(arrayList_0);
            });

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.simpleRadioButton);
        }
    }
}
