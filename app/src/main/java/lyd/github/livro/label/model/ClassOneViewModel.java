package lyd.github.livro.label.model;

import android.arch.lifecycle.LiveData;

import java.util.List;

import lyd.github.livro.base.model.BaseViewModel;
import lyd.github.livro.data.Entity.ClassOneEntity;

/**
 * @author shawn
 * @date 18/2/23
 * @desription
 */

public class ClassOneViewModel extends BaseViewModel{

    private LiveData<List<ClassOneEntity>> mClassOneLiveData;

    public LiveData<List<ClassOneEntity>> getClassOneLiveData() {
        if(mClassOneLiveData==null){
            mClassOneLiveData = dataDao.getClassOneEntity();
        }
        return mClassOneLiveData;
    }

    public void insertClassOneEntity(final ClassOneEntity entity){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dataDao.insertClassOneEntity(entity);
            }
        };
        addThreadExecutor(runnable);
    }
}
