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

import hcmute.edu.vn.foodapp_08.DetailPlaceActivity;
import hcmute.edu.vn.foodapp_08.R;
import hcmute.edu.vn.foodapp_08.entity.Store;

public class StoreAdapter extends BaseAdapter {
    private Activity activity;
    private int layout;
    List<Store> storeList;

    public StoreAdapter(Activity activity, int layout, List<Store> storeList) {
        this.activity = activity;
        this.layout = layout;
        this.storeList = storeList;
    }

    @Override
    public int getCount() {
        return storeList.size();
    }

    @Override
    public Object getItem(int i) {
        return storeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        TextView txtNameStore, txtLocationStore;
        ImageView imgStore;
        Button btnXem;

        if (view == null) {
            view = activity.getLayoutInflater().inflate(layout, null);
            txtNameStore = view.findViewById(R.id.txtNameStore);
            txtLocationStore = view.findViewById(R.id.txtLocationStore);
            btnXem = view.findViewById(R.id.btnXem);
            imgStore = view.findViewById(R.id.imgStore);

            view.setTag(R.id.txtNameStore, txtNameStore);
            view.setTag(R.id.txtLocationStore, txtLocationStore);
            view.setTag(R.id.btnXem, btnXem);
            view.setTag(R.id.imgStore, imgStore);
        } else {
            txtNameStore = (TextView) view.getTag(R.id.txtNameStore);
            txtLocationStore = (TextView) view.getTag(R.id.txtLocationStore);
            btnXem = (Button) view.getTag(R.id.btnXem);
            imgStore = (ImageView) view.getTag(R.id.imgStore);
        }

        Store store = storeList.get(position);
//        int cate = store.getNumCategoryFood();
//        if (cate == 1) {
//            imgFood.setImageResource(R.drawable.food);
//        } else if (cate == 2) {
//            imgFood.setImageResource(R.drawable.drink);
//        } else if (cate == 3) {
//            imgFood.setImageResource(R.drawable.fruit);
//        } else if (cate == 4) {
//            imgFood.setImageResource(R.drawable.cake);
//        }

        txtNameStore.setText(store.getNameStore());
        txtLocationStore.setText(store.getLocationStore());
        imgStore.setImageResource(store.getImageStore());

        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(activity, DetailPlaceActivity.class);
               intent.putExtra("store_key", store);
               activity.startActivityForResult(intent, 100);
            }
        });

        return view;
    }
}
