package hcmute.edu.vn.foodapp_08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.foodapp_08.entity.CartItem;

@Dao
public interface CartItemDao {
    @Query("SELECT * FROM cartItem")
    List<CartItem> getAll();

    @Query("SELECT * FROM cartItem WHERE cartItemId IN (:cartItemId)")
    List<CartItem> loadAllByIds(int[] cartItemId);


    @Insert
    void insert(CartItem cartItem);
    @Update
    void update(CartItem cartItem);
    @Delete
    void delete(CartItem cartItem);
}
