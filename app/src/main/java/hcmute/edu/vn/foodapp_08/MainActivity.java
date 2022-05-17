package hcmute.edu.vn.foodapp_08;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import hcmute.edu.vn.foodapp_08.database.DatabaseConnection;
import hcmute.edu.vn.foodapp_08.entity.Food;
import hcmute.edu.vn.foodapp_08.entity.Store;
import hcmute.edu.vn.foodapp_08.fragment.HomeFragment;
import hcmute.edu.vn.foodapp_08.fragment.NotificationFragment;
import hcmute.edu.vn.foodapp_08.fragment.OrderFragment;
import hcmute.edu.vn.foodapp_08.fragment.SavedFragment;
import hcmute.edu.vn.foodapp_08.fragment.UserFragment;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SavedFragment savedFragment = new SavedFragment();
    OrderFragment orderFragment = new OrderFragment();
    NotificationFragment notificationFragment = new NotificationFragment();
    UserFragment userFragment = new UserFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        Food food = new Food();

        Store a = new Store("Bánh canh Bà Tư", "Bánh canh - hủ tiểu - mì", "123 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.banhcanhghe);
        Store a1 = new Store("Quán lẩu 365", "Lẩu cá - lẩu Thái", "323 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.lau);
        Store a2 = new Store("Quán cơm Cây Nhãn", "Cơm tấm - cơm chiên", "339 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.com);
        Store a3 = new Store("Quán Trà sữa Cô Sáu", "Trà sữa - trà đào", "13 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.trausua);
        Store a4 = new Store("Quán sinh tố 120", "Sinh tố trái cây", "120 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.sinhto);
        Store a5 = new Store("Quán hủ tiếu Cây Sứ", "Hủ tiếu - mì quảng", "189 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.hutieu2);
        Store a6 = new Store("Tiệm trái cây tươi Cô Chín", "Trái cây tươi - trái cây nhập khẩu", "11 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.traicay);
        Store a7 = new Store("Quán hủ tiếu 77", "Hủ tiếu - mì - bún bò", "189 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.hutieu);
        Store a8 = new Store("Quán cơm 333", "Cơm chiên - cơm hải sản - cơm gà", "103 Võ Văn Ngân, Thủ Đức, TPHCM", R.drawable.comtam);

//        DatabaseConnection.getInstance(this).storeDao().insert(a);
//        DatabaseConnection.getInstance(this).storeDao().insert(a1);
//        DatabaseConnection.getInstance(this).storeDao().insert(a2);
//        DatabaseConnection.getInstance(this).storeDao().insert(a3);
//        DatabaseConnection.getInstance(this).storeDao().insert(a4);
//        DatabaseConnection.getInstance(this).storeDao().insert(a5);
//        DatabaseConnection.getInstance(this).storeDao().insert(a6);
//        DatabaseConnection.getInstance(this).storeDao().insert(a7);
//        DatabaseConnection.getInstance(this).storeDao().insert(a8);

        Food f1 = new Food(4 ,"Trà sữa trân châu", "30000", R.drawable.trasua);
        Food f2 = new Food(4 ,"Trà đào", "20000", R.drawable.tradao);
        Food f3 = new Food(4 ,"Trà chanh", "15000", R.drawable.trachanh);
        Food f4 = new Food(4 ,"Cam ép", "15000", R.drawable.camep);

//        DatabaseConnection.getInstance(this).foodDao().insert(f1);
//        DatabaseConnection.getInstance(this).foodDao().insert(f2);
//        DatabaseConnection.getInstance(this).foodDao().insert(f3);
//        DatabaseConnection.getInstance(this).foodDao().insert(f4);


        //Delete
//        Food food1 = DatabaseConnection.getInstance(this).foodDao().findFoodById(10);
//        DatabaseConnection.getInstance(this).foodDao().delete(food1);



        //List<Food> l=DatabaseConnection.getInstance(this).foodDao().findByStoreId(1);
        //Toast.makeText(this,l.size()+"", Toast.LENGTH_LONG).show();



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.action_saved:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, savedFragment).commit();
                        return true;
                    case R.id.action_order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, orderFragment).commit();
                        return true;
                    case R.id.action_notification:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, notificationFragment).commit();
                        return true;
                    case R.id.action_user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, userFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}