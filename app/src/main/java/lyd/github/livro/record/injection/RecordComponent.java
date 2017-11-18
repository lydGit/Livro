package lyd.github.livro.record.injection;

import lyd.github.livro.record.view.impl.RecordActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = RecordModule.class)
public interface RecordComponent {
    void inject(RecordActivity activity);
}