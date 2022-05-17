package hcmute.edu.vn.foodapp_08.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

@Entity(foreignKeys =
@ForeignKey(entity = Users.class, parentColumns = "id", childColumns = "user_id"))
public class Cart implements Serializable {
    @PrimaryKey
    @NonNull
    String id;
    @ColumnInfo(name = "user_id")
    public int userId;
    String date;

    public Cart() {
    }

    public Cart(int userId, String date) {
        this.userId = userId;
        this.date = date;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
