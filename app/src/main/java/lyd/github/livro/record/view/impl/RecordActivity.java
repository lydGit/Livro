package lyd.github.livro.record.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import lyd.github.livro.base.injection.AppComponent;
import lyd.github.livro.base.presenter.BasePresenter;
import lyd.github.livro.base.view.impl.BaseActivity;
import lyd.github.livro.record.injection.DaggerRecordComponent;
import lyd.github.livro.record.injection.RecordModule;
import lyd.github.livro.record.model.RecordModel;
import lyd.github.livro.record.presenter.RecordPresenter;
import lyd.github.livro.record.view.RecordView;

public final class RecordActivity extends BaseActivity implements RecordView {
    @Inject
    RecordPresenter mPresenter;
    @Inject
    RecordModel mRecordModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO
    }

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerRecordComponent.builder().appComponent(parentComponent)
                .recordModule(new RecordModule(this)).build().inject(this);
    }

    @Override
    protected BasePresenter getBasePresenter() {
        return mPresenter;
    }
}
