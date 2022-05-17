package hcmute.edu.vn.foodapp_08;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class LoginActivity extends AppCompatActivity {

    TextView txtRegister;
    Button btnLogin;
    EditText edtLoginUsername, edtLoginPassword;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControl();
        Login();
        Register();
    }

    private void addControl() {
        pref = getSharedPreferences("login",MODE_PRIVATE);
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtLoginPassword = (EditText) findViewById(R.id.edtLoginPassword);
        edtLoginUsername = (EditText) findViewById(R.id.edtLoginUsername);
    }

    public void Login(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckLogin();
            }
        });
    }

    private void CheckLogin() {
        String username = edtLoginUsername.getText().toString().trim();
        String password = edtLoginPassword.getText().toString().trim();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Vui lòng điền đủ thông tin đăng nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        Users user = DatabaseConnection.getInstance(this).userDao().Login(username, password);
        if (user == null) {
            Toast.makeText(this, "Username hoặc Password chưa đúng", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("username", username);
            editor.putString("password", password);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void Register(){
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}