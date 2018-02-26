package lyd.github.livro.base.data;

import android.arch.lifecycle.LiveData;

import java.util.concurrent.ExecutorService;

import lyd.github.livro.base.single.DaoThreadSingle;
import lyd.github.livro.data.AppDataBase;
import lyd.github.livro.data.AppDataDao;

/**
 * @author shawn
 * @date 18/2/23
 * @desription LiveData基类
 */

public abstract class BaseLiveData<T> extends LiveData<T> {

    /**
     * 数据库
     */
    public final AppDataDao dataDao;

    /**
     * 线程池
     */
    public final ExecutorService threadExecutor;

    public BaseLiveData() {
        this.dataDao = AppDataBase.getInstance().getDao();
        threadExecutor = DaoThreadSingle.getInstance().getSingleThreadExecutor();
    }
}
