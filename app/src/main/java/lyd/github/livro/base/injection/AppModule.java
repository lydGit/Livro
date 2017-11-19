package lyd.github.livro.base.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import lyd.github.livro.base.BaseApplication;

/**
 * Created by shawn on 17/11/18.
 */

@Module
public class AppModule {

    @NonNull
    private final BaseApplication mApp;

    public AppModule(@NonNull BaseApplication app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public BaseApplication provideApp() {
        return mApp;
    }

}
