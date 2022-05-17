package hcmute.edu.vn.foodapp_08;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.foodapp_08.database.DatabaseConnection;
import hcmute.edu.vn.foodapp_08.entity.Users;

public class RegisterActivity extends AppCompatActivity {

    TextView txtLogin;
    Button btnRegister;
    EditText edtRegisterPhone, edtRegisterEmail, edtRegisterUsername, edtRegisterPassword, edtRegisterConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        addControl();
        Register();
        Login();
    }

    private void addControl() {
        txtLogin = (TextView) findViewById(R.id.txtLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtRegisterPhone = (EditText) findViewById(R.id.edtRegisterPhone);
        edtRegisterEmail = (EditText) findViewById(R.id.edtRegisterEmail);
        edtRegisterUsername = (EditText) findViewById(R.id.edtRegisterUsername);
        edtRegisterPassword = (EditText) findViewById(R.id.edtRegisterPassword);
        edtRegisterConfirmPassword = (EditText) findViewById(R.id.edtRegisterConfirmPassword);
    }

    public void Register(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUser();
            }
        });
    }

    public void Login(){
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void AddUser() {
        String username = edtRegisterUsername.getText().toString().trim();
        String password = edtRegisterPassword.getText().toString().trim();
        String confirm = edtRegisterConfirmPassword.getText().toString().trim();
        //String name = edtName.getText().toString().trim();
        String email = edtRegisterEmail.getText().toString().trim();
        String phone = edtRegisterPhone.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) ||
                TextUtils.isEmpty(phone) || TextUtils.isEmpty(email) || TextUtils.isEmpty(confirm)) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!TextUtils.equals(password,confirm)){
            Toast.makeText(this, "Xác nhận mật khẩu chưa đúng", Toast.LENGTH_SHORT).show();
            return;
        }
        Users u= DatabaseConnection.getInstance(this).userDao().FindUserByUserName(username);
        if(u!=null){
            Toast.makeText(this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
            return;
        }

        Users user = new Users(username, password, phone, email);
//        DatabaseConnection db = Room.databaseBuilder(getApplicationContext(), DatabaseConnection.class, "leafnote.db")
//                .allowMainThreadQueries()
//                .build();
//        UserDao userDao = db.userDao();
//        userDao.insert(user);
//        Toast.makeText(this, user.toString(), Toast.LENGTH_LONG).show();
        DatabaseConnection.getInstance(this).userDao().insert(user);
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        edtRegisterUsername.setText("");
        edtRegisterPassword.setText("");
        edtRegisterEmail.setText("");
        edtRegisterPhone.setText("");
    }
}