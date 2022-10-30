package com.example.supermarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<ShopItem> shopItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        RecyclerView mainRecycleView=findViewById(R.id.recycle_view_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecycleView.setLayoutManager(layoutManager);

        mainRecycleView.setAdapter(new MyRecyclerViewAdapter(shopItems));
    }


    public void initData(){
        shopItems=new ArrayList<ShopItem>();
        shopItems.add(new ShopItem("青菜",R.drawable.a1,5.6));
        shopItems.add(new ShopItem("萝卜",R.drawable.a2,8.6));
        shopItems.add(new ShopItem("西红柿",R.drawable.a3,4.6));
        for(int i=1;i<=10;i++)
        {
            shopItems.add(new ShopItem("西红柿"+ i,R.drawable.a3,4.6+i));

        }
        shopItems.add(new ShopItem("萝卜",R.drawable.a2,111.6));
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter {
        private List<ShopItem> shopItems;

        public MyRecyclerViewAdapter(List<ShopItem> shopItems) {
            this.shopItems=shopItems;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.shop_item_holder, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder Holder, int position) {
            MyViewHolder holder= (MyViewHolder)Holder;

            holder.getImageView().setImageResource(shopItems.get(position).getPictureId());
            holder.getTextViewName().setText(shopItems.get(position).getName());
            holder.getTextViewPrice().setText(shopItems.get(position).getPrice()+"");
        }

        @Override
        public int getItemCount() {
            return shopItems.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            private final ImageView imageView;
            private final TextView textViewName;
            private final TextView textViewPrice;

            public MyViewHolder(View view) {
                super(view);

                this.imageView=view.findViewById(R.id.image_view_shop_item);
                this.textViewName=view.findViewById(R.id.text_view_shop_item_name);
                this.textViewPrice=view.findViewById(R.id.text_view_shop_item_price);

            }

            public ImageView getImageView() {
                return imageView;
            }

            public TextView getTextViewName() {
                return textViewName;
            }

            public TextView getTextViewPrice() {
                return textViewPrice;
            }
        }
    }
}