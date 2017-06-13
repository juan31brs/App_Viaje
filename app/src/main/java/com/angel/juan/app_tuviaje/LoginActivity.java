package com.angel.juan.app_tuviaje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.angel.juan.app_tuviaje.databinding.ActivityLoginBinding;
import com.angel.juan.app_tuviaje.models.SimpleResponse;
import com.angel.juan.app_tuviaje.models.User;
import com.angel.juan.app_tuviaje.net.UserService;
import com.angel.juan.app_tuviaje.util.DataService;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    UserService service;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("preference", MODE_PRIVATE);
        boolean logged = preferences.getBoolean("logged",false);
        if(logged){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);

        service = DataService.retrofit.create(UserService.class);
    }

    public void goToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(){
        final String usuario =  binding.usuario.getText().toString();
        String pass =  binding.password.getText().toString();
        User user = new User(usuario, pass);

        final Call<SimpleResponse> request = service.login(user);
        request.enqueue(new Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if(response.isSuccessful()){
                    SimpleResponse res = response.body();
                    if(res.isSuccess()){
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("logged", true);
                        editor.putString("usuario", usuario);
                        editor.apply();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
