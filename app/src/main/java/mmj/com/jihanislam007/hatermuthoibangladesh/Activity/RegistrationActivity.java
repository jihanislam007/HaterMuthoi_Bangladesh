package mmj.com.jihanislam007.hatermuthoibangladesh.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.realm.Realm;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.Model.LoginModel;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.MyApplication;
import mmj.com.jihanislam007.hatermuthoibangladesh.R;
import mmj.com.jihanislam007.hatermuthoibangladesh.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    ActivityRegistrationBinding binding;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_registration);
        binding = DataBindingUtil.setContentView(RegistrationActivity.this, R.layout.activity_registration);

        realm  = Realm.getDefaultInstance();

        binding.SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                //Toast.makeText(RegistrationActivity.this, "That's ok", Toast.LENGTH_SHORT).show();
            }
        });

        binding.AlreadyRegisteredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplication(),LoginActivity.class));
            }
        });

    }

    private void saveData(){

        final String user_text = binding.usernameSignUpEditText.getText().toString().trim();
        final String pass_text = binding.passwordSignUpEditText.getText().toString().trim();

        MyApplication.getRealm().beginTransaction();

        LoginModel loginModel = new LoginModel();
        loginModel.setUser_name(user_text);
        loginModel.setPass(pass_text);

        MyApplication.getRealm().copyToRealm(loginModel);

        MyApplication.getRealm().commitTransaction();

        Toast.makeText(RegistrationActivity.this, "Insert successfully ...", Toast.LENGTH_SHORT).show();


        /*realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                *//*LoginModel loginModel = bgRealm.createObject(LoginModel.class);
                loginModel.setUser_name(user_text);
                loginModel.setPass(pass_text);*//*
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Toast.makeText(RegistrationActivity.this, "Insert successfully ...", Toast.LENGTH_SHORT).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Toast.makeText(RegistrationActivity.this, "Not Inserted...", Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
