package mmj.com.jihanislam007.hatermuthoibangladesh.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.Model.LoginModel;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.MyApplication;
import mmj.com.jihanislam007.hatermuthoibangladesh.R;
import mmj.com.jihanislam007.hatermuthoibangladesh.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        retrieveLogin();
    }

    public void retrieveLogin() {


        RealmResults<LoginModel> loginModels = MyApplication.getRealm().where(LoginModel.class).findAll();

        realm = Realm.getDefaultInstance();

        for (LoginModel model : loginModels) {
            //    users.setText("");
            binding.user.append(model.getUser_name() + "\n");
            binding.pass.append(model.getPass() + "\n");


        }
    }
}