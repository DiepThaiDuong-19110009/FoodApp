package hcmute.edu.vn.foodapp_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import hcmute.edu.vn.foodapp_08.Adapter.FoodAdapter;
import hcmute.edu.vn.foodapp_08.Adapter.StoreAdapter;
import hcmute.edu.vn.foodapp_08.database.DatabaseConnection;
import hcmute.edu.vn.foodapp_08.entity.Food;
import hcmute.edu.vn.foodapp_08.entity.Store;

public class DetailPlaceActivity extends AppCompatActivity {

    ImageView imgStoreDetail;
    TextView txtNameStoreDetail, txtLocationStoreDetail, txtBackHome;
    ListView lvFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);

        addControl();

        Intent intent = getIntent();
        Store store= (Store) intent.getSerializableExtra("store_key");
        imgStoreDetail.setImageResource(store.getImageStore());
        txtNameStoreDetail.setText(store.getNameStore());
        txtLocationStoreDetail.setText(store.getLocationStore());


        List<Food> foodList = DatabaseConnection.getInstance(DetailPlaceActivity.this).foodDao().findByStoreId(store.getStore_id());
        FoodAdapter adapter = new FoodAdapter(DetailPlaceActivity.this, R.layout.row_item_list_food, foodList);
        lvFood.setAdapter(adapter);

        txtBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        imgStoreDetail = (ImageView) findViewById(R.id.imgStoreDetail);
        txtNameStoreDetail = (TextView) findViewById(R.id.txtNameStoreDetail);
        txtLocationStoreDetail = (TextView) findViewById(R.id.txtLocationStoreDetail);
        txtBackHome = (TextView) findViewById(R.id.txtBackHome);
        lvFood = (ListView) findViewById(R.id.lvFoodOfStore);
    }
}