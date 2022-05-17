package hcmute.edu.vn.foodapp_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.edu.vn.foodapp_08.entity.Food;
import hcmute.edu.vn.foodapp_08.entity.Store;

public class DetailFoodActivity extends AppCompatActivity {

    ImageView imgFoodDetail;
    TextView txtNameFoodDetail, txtPriceFoodDetail, txtBackStore, txtQuantity;
    Button btnTru, btnCong, btnAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        addControl();

        Intent intent = getIntent();
        Food food= (Food) intent.getSerializableExtra("food_key");
        txtNameFoodDetail.setText(food.getNameFood());
        txtPriceFoodDetail.setText(food.getPriceFood());
        imgFoodDetail.setImageResource(food.getImgFood());

        txtBackStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(txtQuantity.getText().toString());
                if(quantity == 0){
                    Toast.makeText(DetailFoodActivity.this, "Vui lòng kiểm tra", Toast.LENGTH_SHORT).show();
                } else {
                    String tru = String.valueOf(quantity - 1);
                    txtQuantity.setText(tru);
                }
            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(txtQuantity.getText().toString());
                String cong = String.valueOf(quantity + 1);
                txtQuantity.setText(cong);
            }
        });

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(txtQuantity.getText().toString());
                if(quantity == 0){
                    Toast.makeText(DetailFoodActivity.this, "Vui lòng chọn số lượng", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DetailFoodActivity.this, CartItemActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void addControl() {
        imgFoodDetail = (ImageView) findViewById(R.id.imgFoodDetail);
        txtNameFoodDetail = (TextView) findViewById(R.id.txtNameFoodDetail);
        txtPriceFoodDetail = (TextView) findViewById(R.id.txtPriceFoodDetail);
        txtBackStore = (TextView) findViewById(R.id.txtBackStore);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnAddCart = (Button) findViewById(R.id.btnAddCart);
    }
}