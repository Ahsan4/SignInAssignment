package com.example.ahsan.signinassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button reg;
    private TextView  tvLogin;
    private EditText etPass, etEmail;

    private DbHelper db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db= new DbHelper(this);

        reg = (Button)findViewById(R.id.btnReg);
        tvLogin=(TextView)findViewById(R.id.tvLogin);

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText)findViewById(R.id.etPass);


        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

                /*
        reg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
*/


        /*
            tvLogin.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            });
*/

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnReg:
                register();
                break;

            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;
            default:
        }
    }



    private void register(){

        String email =  etEmail.getText().toString();
        String pass = etPass.getText().toString();
        //String pass = etPass.getText().toString();

        if(email.isEmpty() && pass.isEmpty()){
            displayToast("Username/password field empty");
        }
        else {
            db.addUser(email,pass);
            displayToast("USer Register");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }



}
