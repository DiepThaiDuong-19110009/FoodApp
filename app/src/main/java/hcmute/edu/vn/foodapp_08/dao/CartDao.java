package hcmute.edu.vn.foodapp_08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.foodapp_08.entity.Cart;

@Dao
public interface CartDao {
    @Query("SELECT * FROM cart")
    List<Cart> getAll();

    @Query("SELECT * FROM cart WHERE id IN (:cartId)")
    List<Cart> loadAllByIds(int[] cartId);


    @Insert
    void insert(Cart cart);
    @Update
    void update(Cart cart);
    @Delete
    void delete(Cart cart);
}
