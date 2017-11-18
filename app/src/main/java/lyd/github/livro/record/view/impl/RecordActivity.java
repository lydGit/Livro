package lyd.github.livro.record.view.impl;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;

import lyd.github.livro.record.view.RecordView;
import lyd.github.livro.record.presenter.RecordPresenter;
import lyd.github.livro.record.injection.RecordModule;
import lyd.github.livro.record.injection.DaggerRecordComponent;

import javax.inject.Inject;

public final class RecordActivity extends BaseActivity implements RecordView {
    @Inject
    RecordPresenter mPresenter;
    @Inject
    RecordModel mRecordModel;
    ActivityRecordBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_record);
        mBinding.setView(this);
        mBinding.setPresenter(mPresenter);
        mBinding.setModel(mRecordModel);
        ButterKnife.bind(this);
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
