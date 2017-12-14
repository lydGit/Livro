package lyd.github.livro.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import lyd.github.livro.base.BaseApplication;
import lyd.github.livro.data.Entity.ClassOneEntity;

/**
 * Created by shawn on 17/12/13.
 */

@Database(entities = {ClassOneEntity.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    private static volatile AppDataBase instance;

    public abstract AppDataDao getDao();

    public static AppDataBase getInstance() {
        if (instance == null) {
            synchronized (AppDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(BaseApplication.getAppContext(),
                            AppDataBase.class, "Livro.db").build();
                }
            }
        }
        return instance;
    }

}
