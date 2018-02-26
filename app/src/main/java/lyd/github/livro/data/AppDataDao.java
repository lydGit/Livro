package lyd.github.livro.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import lyd.github.livro.data.Entity.ClassOneEntity;
import lyd.github.livro.data.config.DataTableConfig;

/**
 * Created by shawn on 17/12/13.
 */

@Dao
public interface AppDataDao {

    @Query("SELECT * FROM "+ DataTableConfig.CLASS_ONE)
    LiveData<List<ClassOneEntity>> getClassOneEntity();

    @Insert
    void insertClassOneEntity(ClassOneEntity classOneEntity);
}
