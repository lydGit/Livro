package lyd.github.livro.record.injection;

import android.support.annotation.NonNull;

import lyd.github.livro.record.view.RecordView;
import lyd.github.livro.record.interactor.RecordInteractor;
import lyd.github.livro.record.interactor.impl.RecordInteractorImpl;
import lyd.github.livro.record.model.RecordModel;
import lyd.github.livro.record.presenter.RecordPresenter;
import lyd.github.livro.record.presenter.impl.RecordPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class RecordModule {
    private final RecordView mView;
    private final RecordModel mRecordModel;

    public RecordModule(@NonNull RecordView view) {
        mView = view;
        mRecordModel = new RecordModel();
    }

    @Provides
    public RecordView provideView() {
        return mView;
    }

    @Provides
    public RecordModel provideViewModel() {
        return mRecordModel;
    }

    @Provides
    public RecordInteractor provideInteractor() {
        return new RecordInteractorImpl();
    }

    @Provides
    public RecordPresenter providePresenter(RecordView view, RecordInteractor interactor, RecordModel recordModel) {
        return new RecordPresenterImpl(view, interactor, recordModel);
    }
}
