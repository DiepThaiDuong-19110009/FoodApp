package hcmute.edu.vn.foodapp_08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CartItemActivity extends AppCompatActivity {

    TextView txtBackDetailFood, txtBuyMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_item);

        addControl();

        txtBackDetailFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtBuyMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        txtBackDetailFood = (TextView) findViewById(R.id.txtBackDetailFood);
        txtBuyMore = (TextView) findViewById(R.id.txtBuyMore);
    }
}