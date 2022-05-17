package hcmute.edu.vn.foodapp_08.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hcmute.edu.vn.foodapp_08.DetailFoodActivity;
import hcmute.edu.vn.foodapp_08.R;
import hcmute.edu.vn.foodapp_08.entity.Food;

public class CartItemAdapter extends BaseAdapter {
    private Activity activity;
    private int layout;
    List<Food> foodList;

    public CartItemAdapter(Activity activity, int layout, List<Food> foodList) {
        this.activity = activity;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView txtNameFood, txtPriceFood;
        ImageView imgFood;
        Button btnChon;

        if (view == null) {
            view = activity.getLayoutInflater().inflate(layout, null);
            txtNameFood = view.findViewById(R.id.txtNameFood);
            txtPriceFood = view.findViewById(R.id.txtPrice);
            btnChon = view.findViewById(R.id.btnChon);
            imgFood = view.findViewById(R.id.imgFood);

            view.setTag(R.id.txtNameFood, txtNameFood);
            view.setTag(R.id.txtPrice, txtPriceFood);
            view.setTag(R.id.btnChon, btnChon);
            view.setTag(R.id.imgFood, imgFood);
        } else {
            txtNameFood = (TextView) view.getTag(R.id.txtNameFood);
            txtPriceFood = (TextView) view.getTag(R.id.txtPrice);
            btnChon = (Button) view.getTag(R.id.btnChon);
            imgFood = (ImageView) view.getTag(R.id.imgFood);
        }

        Food food = foodList.get(position);

        txtNameFood.setText(food.getNameFood());
        txtPriceFood.setText(food.getPriceFood());
        imgFood.setImageResource(food.getImgFood());

        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailFoodActivity.class);
                intent.putExtra("food_key", food);
                activity.startActivityForResult(intent, 100);
            }
        });

        return view;
    }
}
