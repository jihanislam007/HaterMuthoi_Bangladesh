package mmj.com.jihanislam007.hatermuthoibangladesh.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.Model.LoginModel;
import mmj.com.jihanislam007.hatermuthoibangladesh.DB.MyApplication;
import mmj.com.jihanislam007.hatermuthoibangladesh.R;
import mmj.com.jihanislam007.hatermuthoibangladesh.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding mbinding;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        //users = findViewById(R.id.user_text);
        //pass = findViewById(R.id.pass);

        realm  = Realm.getDefaultInstance();
        //retrieve();

        mbinding.LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveLogin();
                Toast.makeText(LoginActivity.this, "here i am", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void retrieveLogin(){


        RealmResults<LoginModel> loginModels = MyApplication.getRealm().where(LoginModel.class).findAll();

        realm  = Realm.getDefaultInstance();

        for(LoginModel model: loginModels){
        //    users.setText("");
        //    users.append(model.getUser_name()+"\n");
        //    pass.append(model.getPass()+"\n");

            String user = mbinding.usernameLogInEditText.getText().toString();
            String pass = mbinding.passwordLogInEditText.getText().toString();

            //String DbUser =
            // Boolean checkmail = model.em

            if(user.equals(model.getUser_name()) || pass.equals(model.getPass())){

                startActivity(new Intent(getApplication(),MainActivity.class));

            }else{
                Toast.makeText(LoginActivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
            }


        }

        /***********Done*/
        /*RealmResults<LoginModel> states= MyApplication.getRealm().where(LoginModel.class).findAll();
        //ArrayList<RequestState> stateList=new ArrayList<>();
        System.out.println("jihan"+states.size());
        //binding.userText.setText("");
        //binding.userText.setText(states.get(0).getUser_name());
        users.setText(states.getUser_name());
        pass.setText(states.get(0).getPass());*/


    }
}
