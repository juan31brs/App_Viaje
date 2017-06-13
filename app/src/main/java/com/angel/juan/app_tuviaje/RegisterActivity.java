package com.angel.juan.app_tuviaje;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.angel.juan.app_tuviaje.databinding.ActivityRegisterBinding;
import com.angel.juan.app_tuviaje.models.SimpleResponse;
import com.angel.juan.app_tuviaje.models.User;
import com.angel.juan.app_tuviaje.net.UserService;
import com.angel.juan.app_tuviaje.util.DataService;

public class RegisterActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityRegisterBinding binding;
    UserService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.setHandler(this);
        service = DataService.retrofit.create(UserService.class);
    }

    public void register(){
        String usuario =  binding.usuario.getText().toString();
        String pass =  binding.password.getText().toString();
        String name =  binding.nombre.getText().toString();
        User user = new User(name, usuario, pass);
        Call<SimpleResponse> request = service.registro(user);
        request.enqueue(this);
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse res = response.body();
            if(res.isSuccess()){
                Toast.makeText(this, "Registro exitoso !", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(RegisterActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }
}
