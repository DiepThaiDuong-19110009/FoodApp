package hcmute.edu.vn.foodapp_08.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import hcmute.edu.vn.foodapp_08.dao.FoodDao;
import hcmute.edu.vn.foodapp_08.dao.StoreDao;
import hcmute.edu.vn.foodapp_08.dao.UserDao;
import hcmute.edu.vn.foodapp_08.entity.Cart;
import hcmute.edu.vn.foodapp_08.entity.CartItem;
import hcmute.edu.vn.foodapp_08.entity.Food;
import hcmute.edu.vn.foodapp_08.entity.Store;
import hcmute.edu.vn.foodapp_08.entity.Users;


@Database(entities = {Users.class, Food.class, Store.class, Cart.class, CartItem.class},version=1)
public abstract class DatabaseConnection extends RoomDatabase{
    private static final String DATABASE_NAME = "foodapp.db";
    private static DatabaseConnection instance;
    public static synchronized DatabaseConnection getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),DatabaseConnection.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
    public abstract FoodDao foodDao();
    public abstract StoreDao storeDao();
}
