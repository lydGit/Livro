package lyd.github.livro.base.view.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import lyd.github.livro.base.injection.AppComponent;
import lyd.github.livro.base.presenter.BasePresenter;

/**
 * Created by shawn on 17/11/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Get the base presenter for this view
     *
     * @return the base presenter if any, null otherwise
     */
    @Nullable
    protected abstract BasePresenter getBasePresenter();

    /**
     * Setup the injection component for this view
     *
     * @param appComponent the app component
     */
    protected abstract void setupComponent(@NonNull AppComponent appComponent);

    private boolean mFirstStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirstStart = true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        final BasePresenter presenter = getBasePresenter();
        if (presenter != null) {
            presenter.onStart(mFirstStart);
        }
        mFirstStart = false;
    }
}
