package com.angel.juan.app_tuviaje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.angel.juan.app_tuviaje.db.DbHelper;


public class LoginActivity extends AppCompatActivity implements OnClickListener {


    private DbHelper dbHelper;
    private EditText name, pass;
    private Session session;
    private Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        dbHelper = new DbHelper(this);
        session = new Session(this);
        name = (EditText)findViewById(R.id.name);
        pass = (EditText)findViewById(R.id.editText);
        login = (Button)findViewById(R.id.button_login);
        login.setOnClickListener(this);
        register = (Button)findViewById(R.id.button_register);
        register.setOnClickListener(this);

        if (session.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_login:
                login();
                break;
            case R.id.button_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:

        }
    }


    private void login(){
        String nombre = name.getText().toString();
        String pasword = pass.getText().toString();

        if(dbHelper.getUser(nombre, pasword)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Ingresa Usuario y Contraseña", Toast.LENGTH_SHORT).show();
        }
    }


}
