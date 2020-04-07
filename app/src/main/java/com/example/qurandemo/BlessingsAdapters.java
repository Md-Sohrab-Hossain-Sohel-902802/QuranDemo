package com.example.qurandemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlessingsAdapters extends RecyclerView.Adapter<BlessingsAdapters.MyViewHolder> {


    private OnItemClickListner listner;
    private Context context;
private List<SuraHandelar> suraHandelarList;

    public BlessingsAdapters(Context context, List<SuraHandelar> suraHandelarList) {
        this.context = context;
        this.suraHandelarList = suraHandelarList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(context).inflate(R.layout.blessing_fragments_parent_sample_layout,parent,false);



        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SuraHandelar suraHandelar=suraHandelarList.get(position);

        holder.valuesTextview.setText(suraHandelar.getName());
        holder.serialTextview.setText(suraHandelar.getSerial());



    }

    @Override
    public int getItemCount() {
        return suraHandelarList.size();
    }


    public class MyViewHolder  extends  RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView valuesTextview;
        private  TextView serialTextview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            valuesTextview=itemView.findViewById(R.id.blessingParentValueTextviewid);
            serialTextview=itemView.findViewById(R.id.blessingParentSerialTextviewid);




            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listner!=null){
                int position=getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){
                    listner.OnItemClick(position);
                }
            }
        }

    }

    public interface  OnItemClickListner{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListner listener){
        this.listner=listener;

    }
}
