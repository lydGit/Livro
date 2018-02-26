package lyd.github.livro.base.model;

import android.arch.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;

import lyd.github.livro.base.single.DaoThreadSingle;
import lyd.github.livro.data.AppDataBase;
import lyd.github.livro.data.AppDataDao;

/**
 * @author shawn
 * @date 18/2/23
 * @desription ViewModel基类
 */

public class BaseViewModel extends ViewModel{

    /**
     * 数据库
     */
    public final AppDataDao dataDao;

    /**
     * 线程池
     */
    private final ExecutorService threadExecutor;

    public BaseViewModel() {
        this.dataDao = AppDataBase.getInstance().getDao();
        threadExecutor = DaoThreadSingle.getInstance().getSingleThreadExecutor();
    }

    public void addThreadExecutor(Runnable runnable){
        threadExecutor.execute(runnable);
    }

}
