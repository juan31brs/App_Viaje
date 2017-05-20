package com.angel.juan.app_tuviaje;

import android.app.Application;

import com.angel.juan.app_tuviaje.models.DaoMaster;
import com.angel.juan.app_tuviaje.models.DaoSession;

import org.greenrobot.greendao.database.Database;

public class App extends Application{

    DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "reservas.db");
        Database db = helper.getWritableDb();

        DaoMaster master = new DaoMaster(db);
        session = master.newSession();
    }
}
