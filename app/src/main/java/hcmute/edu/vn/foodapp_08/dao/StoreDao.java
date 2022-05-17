package hcmute.edu.vn.foodapp_08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.foodapp_08.entity.Store;

@Dao
public interface StoreDao {
    @Query("SELECT * FROM store")
    List<Store> getAll();

    @Query("SELECT * FROM store WHERE store_id IN (:storeIds)")
    List<Store> loadAllByIds(int[] storeIds);

    @Query("SELECT * FROM Store WHERE store_id=:idStore")
    List<Store> FindStoreIdByStoreName(String idStore);

    @Query("SELECT * FROM Store WHERE nameStore=:nameStore")
    List<Store> FindFoodByStoreName(String nameStore);

    @Query("SELECT * FROM Store order by random() limit 10")
    List<Store> Random();

    @Query("SELECT *FROM Store WHERE nameStore LIKE '%'|| :search ||'%'")
    List<Store>searchStore(String search);


    @Insert
    void insert(Store store);
    @Update
    void update(Store store);
    @Delete
    void delete(Store store);
}
