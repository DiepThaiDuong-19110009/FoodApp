package hcmute.edu.vn.foodapp_08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hcmute.edu.vn.foodapp_08.entity.Users;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<Users> getAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<Users> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE username =:name and password=:pass")
    Users Login(String name, String pass);

    @Query("SELECT * FROM users WHERE username=:name")
    Users FindUserByUserName(String name);

    @Query("SELECT * FROM users WHERE email=:email")
    Users FindUserByUserEmail(String email);

    @Query("SELECT * FROM users WHERE phone=:phone")
    Users FindUserByUserPhone(String phone);

    @Insert
    void insert(Users user);
    @Update
    void update(Users user);
    @Delete
    void delete(Users user);
}
