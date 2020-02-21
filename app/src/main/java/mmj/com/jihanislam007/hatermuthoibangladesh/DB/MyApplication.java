package mmj.com.jihanislam007.hatermuthoibangladesh.DB;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;

public class MyApplication extends Application{

    private static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

    }

    public static Realm getRealm(){
        if(realm==null){
            RealmConfiguration realmConfiguration = new RealmConfiguration
                    .Builder()
                    .name("jihan.realm")
                    .deleteRealmIfMigrationNeeded()
                    .build();
            try {
                realm = Realm.getInstance(realmConfiguration);
            } catch (RealmMigrationNeededException r) {
                Realm.deleteRealm(realmConfiguration);
                realm = Realm.getInstance(realmConfiguration);
            }
        }
        //Log.d("SIMILAR CHANNEL SIZE6","listItems "+(realm==null));
        return realm;
    }

}
