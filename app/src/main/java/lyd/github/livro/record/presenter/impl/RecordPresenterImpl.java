package lyd.github.livro.record.presenter.impl;

import android.os.Bundle;

import lyd.github.livro.record.presenter.RecordPresenter;
import lyd.github.livro.record.view.RecordView;
import lyd.github.livro.record.interactor.RecordInteractor;

import javax.inject.Inject;

public final class RecordPresenterImpl extends RecordPresenter {
    private final RecordView mView;
    private final RecordInteractor mInteractor;
    private final RecordModel mRecordModel;

    @Inject
    public RecordPresenterImpl(RecordView view, RecordInteractor interactor, RecordModel recordModel) {
        mView = view;
        mInteractor = interactor;
        mRecordModel = recordModel;
    }

    @Override
    public void onStart(boolean firstStart) {

    }
}