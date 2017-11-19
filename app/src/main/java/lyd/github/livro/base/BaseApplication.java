package lyd.github.livro.base;

import android.app.Application;

import lyd.github.livro.base.injection.AppComponent;
import lyd.github.livro.base.injection.AppModule;
import lyd.github.livro.base.injection.DaggerAppComponent;

/**
 * Created by shawn on 17/11/18.
 */

public class BaseApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
