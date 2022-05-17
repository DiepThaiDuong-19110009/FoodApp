package hcmute.edu.vn.foodapp_08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.foodapp_08.entity.Food;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM food")
    List<Food> getAll();

    @Query("SELECT * FROM Food WHERE food_id IN (:foodIds)")
    List<Food> loadAllByIds(int[] foodIds);

    @Query("SELECT * FROM Food WHERE nameFood=:nameFood")
    List<Food> FindFoodByFoodName(String nameFood);

    @Query("SELECT * FROM Food order by random() limit 10")
    List<Food> Random();

    @Query("SELECT * FROM Food  WHERE store_id=:id")
    List<Food> findByStoreId(int id);

    //Delete
    @Query("SELECT * FROM Food WHERE food_id=:id")
    Food findFoodById(int id);

    @Insert
    void insert(Food foods);
    @Update
    void update(Food foods);
    @Delete
    void delete(Food foods);

}
