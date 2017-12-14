package lyd.github.livro.data.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import lyd.github.livro.data.config.DataFieldConfig;
import lyd.github.livro.data.config.DataTableConfig;

/**
 * Created by shawn on 17/12/13.
 */
@Entity(tableName = DataTableConfig.CLASS_ONE)
public class ClassOneEntity {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataFieldConfig.CO_ID)
    private int classId;

    @ColumnInfo(name = DataFieldConfig.CO_NAME)
    private String className;

    @NonNull
    public int getClassId() {
        return classId;
    }

    public void setClassId(@NonNull int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
