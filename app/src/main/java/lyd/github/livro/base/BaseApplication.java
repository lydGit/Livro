package lyd.github.livro.base;

import android.app.Application;
import android.content.Context;

/**
 *
 * @author shawn
 * @date 17/12/13
 */

public class BaseApplication extends Application{

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
