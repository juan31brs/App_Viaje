package com.angel.juan.app_tuviaje;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.angel.juan.app_tuviaje.db.DbHelper;

public class RegisterActivity extends AppCompatActivity implements OnClickListener {

    private EditText edit_nombre, edit_contraseña, edit_fecha, edit_email;
    private Button finalizar;
    private DbHelper dbHelper;

    Spinner spinner;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DbHelper(this);

        finalizar = (Button) findViewById(R.id.button_finalizar);
        finalizar.setOnClickListener(this);

        edit_nombre = (EditText) findViewById(R.id.register_name);
        /*if (AppUtil.nombre != "vacio"){
            edit_nombre.setText(AppUtil.nombre);}
*/
        edit_contraseña = (EditText) findViewById(R.id.register_contra);
        /*if (AppUtil.password != "vacio"){
            edit_contraseña.setText(AppUtil.password);}
*/
        edit_fecha = (EditText) findViewById(R.id.register_fecha);
       /* if (AppUtil.fecha != "vacio"){
            edit_fecha.setText(AppUtil.fecha);}
*/
        edit_email = (EditText) findViewById(R.id.register_email);
     /*   if (AppUtil.email != "vacio"){
            edit_email.setText(AppUtil.email);}
*/
        //region spinner
        spinner = (Spinner) findViewById(R.id.spinner);
        items = getResources().getStringArray(R.array.viajes_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //endregion


        /*preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        String newname = edit_nombre.getText().toString();
        String newcontra = edit_contraseña.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(newname + newcontra + "data", newname);
        editor.commit();
        */


    }
/*
    @Override
    protected void onDestroy() {

        // se le pasa la informacion ingresada por el usuario a la variable global
        AppUtil.nombre = edit_nombre.getText().toString();

        // R1_nombre.KEY_NOM = nombre;
        super.onDestroy();
    }
*/
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_finalizar:
                /*AppUtil.nombre = edit_nombre.getText().toString();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);*/
                register();
                break;

            default:
                break;

        }

    }

    private void register(){
        String name = edit_nombre.getText().toString();
        String pass = edit_contraseña.getText().toString();
        if(name.isEmpty() && pass.isEmpty()){
            displayToast("Nombre/Contraseña estan vacios");
        }else{
            dbHelper.addUser(name, pass);
            displayToast("Usuario registrado");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
