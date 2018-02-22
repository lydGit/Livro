package lyd.github.livro.data.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import lyd.github.livro.data.config.DataFieldConfig;
import lyd.github.livro.data.config.DataTableConfig;

/**
 * @author shawn
 * @date 18/2/21
 * <p>
 * 二级分类
 */

@Entity(tableName = DataTableConfig.CLASS_TWO)
public class ClassTwoEntity {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataFieldConfig.CT_ID)
    private int classId;

    @ColumnInfo(name = DataFieldConfig.CT_NAME)
    private String className;

    @ColumnInfo(name = DataFieldConfig.CT_SORT)
    private int sort;

    @NonNull
    @ColumnInfo(name = DataFieldConfig.CT_CATEGORY_ID)
    private int categoryId;

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @NonNull
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(@NonNull int categoryId) {
        this.categoryId = categoryId;
    }
}
