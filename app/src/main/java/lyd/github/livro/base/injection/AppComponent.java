package lyd.github.livro.base.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import lyd.github.livro.base.BaseApplication;

/**
 * Created by shawn on 17/11/18.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

}