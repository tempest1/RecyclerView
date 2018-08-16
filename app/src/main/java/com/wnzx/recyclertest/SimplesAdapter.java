package com.wnzx.recyclertest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zd on 2017/9/29.
 */
public class SimplesAdapter extends RecyclerView.Adapter<MyViewHolder> {

    LayoutInflater mInflater;
    private Context context;
    private List<String> mDatas;
    OnItemClickListener mOnItemClickListener;

    SimplesAdapter(Context context, List<String> datas){
        mInflater = LayoutInflater.from(context);
        this.context =context;
        this.mDatas = datas;
    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        holder.tv.setText(mDatas.get(position));
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(position);
                }
            });
        }
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.getTag()
                Toast.makeText(context,position+"succe",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_simple,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);


        return viewHolder;
    }

    public interface OnItemClickListener{
        void onItemClick( int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
}


 class MyViewHolder extends RecyclerView.ViewHolder  {
    TextView tv;
    ImageView img;
    Button btn;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView)itemView.findViewById(R.id.id_tv);
        img = (ImageView)itemView.findViewById(R.id.img);
        btn = (Button)itemView.findViewById(R.id.btn);
    }

 }
