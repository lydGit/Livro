package lyd.github.livro.record.presenter;

import lyd.github.livro.base.presenter.BasePresenter;

public abstract class RecordPresenter extends BasePresenter {

    /**
     * Should be called by the view every time it starts
     *
     * @param firstStart is it the first start?
     */
    public void onStart(boolean firstStart){};


}