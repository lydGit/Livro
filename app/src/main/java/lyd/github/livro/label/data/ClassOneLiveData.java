package lyd.github.livro.label.data;

import android.util.Log;

import java.util.List;

import lyd.github.livro.base.data.BaseLiveData;
import lyd.github.livro.data.Entity.ClassOneEntity;

/**
 * @author shawn
 * @date 18/2/23
 * @desription
 */

public class ClassOneLiveData<T> extends BaseLiveData<List<ClassOneEntity>> {

    @Override
    protected void onActive() {
        super.onActive();
//        threadExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                dataDao.getClassOneEntity();
//            }
//        });
//        dataDao.getClassOneEntity().observe();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.e("lyd","  onInactive  ");
    }
}
