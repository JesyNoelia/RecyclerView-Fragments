package com.example.recyclerview_fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    public interface ItemClicked{
        void onItemClicked(int index);
    }
     ItemClicked activity;
    private ArrayList<Car> cars;

    public CarAdapter(Context context, ArrayList<Car> list){
        cars=list;
        activity= (ItemClicked) context;
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView ivMake2;
        TextView tvModel2, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMake2 = itemView.findViewById(R.id.ivMake2);
            tvModel2= itemView.findViewById(R.id.tvModel2);
            tvOwner= itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(cars.indexOf((Car) view.getTag()));
                }
            });


        }
    }

    @NonNull

    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder viewHolder, int position) {

        viewHolder.itemView.setTag(cars.get(position));

        viewHolder.tvOwner.setText(cars.get(position).getOwnerName());
        viewHolder.tvModel2.setText(cars.get(position).getModel());

        if(cars.get(position).getMake().equals("volkswagen")){
            viewHolder.ivMake2.setImageResource(R.drawable.volkswagen);
        }else if(cars.get(position).getMake().equals("nissan")){
            viewHolder.ivMake2.setImageResource(R.drawable.nissan);

        }else{
            viewHolder.ivMake2.setImageResource(R.drawable.mercedes);

        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
