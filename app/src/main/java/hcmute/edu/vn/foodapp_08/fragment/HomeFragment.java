package hcmute.edu.vn.foodapp_08.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foodapp_08.Adapter.StoreAdapter;
import hcmute.edu.vn.foodapp_08.MainActivity;
import hcmute.edu.vn.foodapp_08.R;
import hcmute.edu.vn.foodapp_08.database.DatabaseConnection;
import hcmute.edu.vn.foodapp_08.entity.Store;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        EditText edtSearch = (EditText) view.findViewById(R.id.edtSearch);
        TextView txtSearch = (TextView) view.findViewById(R.id.txtSearch);

        LinearLayout nearMe = (LinearLayout) view.findViewById(R.id.nearMe);
        LinearLayout food = (LinearLayout) view.findViewById(R.id.food);
        LinearLayout drink = (LinearLayout) view.findViewById(R.id.drink);
        LinearLayout fruit = (LinearLayout) view.findViewById(R.id.fruit);
        LinearLayout cake = (LinearLayout) view.findViewById(R.id.cake);

        ListView lvHome = (ListView) view.findViewById(R.id.lvHome);

        List<Store> storeList = DatabaseConnection.getInstance(getActivity()).storeDao().getAll();
        StoreAdapter adapter = new StoreAdapter(getActivity(), R.layout.row_item_list_store, storeList);
        lvHome.setAdapter(adapter);

//        //Click Gần tôi
//        nearMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentNearMe = new Intent(getActivity(), NearMeActivity.class);
//                startActivity(intentNearMe);
//            }
//        });
//
//        //Click Đồ ăn
//        food.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentFood = new Intent(getActivity(), FoodActivity.class);
//                startActivity(intentFood);
//            }
//        });
//
//        //Click Đồ uống
//        drink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentDrink = new Intent(getActivity(), DrinkActivity.class);
//                startActivity(intentDrink);
//            }
//        });
//
//        //Click Trái cây
//        fruit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentFruit = new Intent(getActivity(), FruitActivity.class);
//                startActivity(intentFruit);
//            }
//        });
//
//        //Click Bánh
//        cake.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentCake = new Intent(getActivity(), CakeActivity.class);
//                startActivity(intentCake);
//            }
//        });
//
//        txtSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String search=edtSearch.getText().toString().trim();
//                if(TextUtils.isEmpty(search)){
//                    Toast.makeText(getActivity(), "Vui lòng nhập từ khóa tìm kiếm", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.equals(search,"tất cả")){
//                    lvHome.setAdapter(adapter);
//                }
//                else {
//                    List<Food> listSearch = DatabaseConnection.getInstance(getActivity()).foodDao().searchFood(search);
//                    NearMeAdapter adapter = new NearMeAdapter(getActivity(), R.layout.row_item_list_food, listSearch);
//                    lvHome.setAdapter(adapter);
//                }
//            }
//        });

        return view;
    }
}