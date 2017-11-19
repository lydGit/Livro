package lyd.github.livro.record.injection;

import dagger.Component;
import lyd.github.livro.base.injection.ActivityScope;
import lyd.github.livro.base.injection.AppComponent;
import lyd.github.livro.record.view.impl.RecordActivity;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = RecordModule.class)
public interface RecordComponent {
    void inject(RecordActivity activity);
}