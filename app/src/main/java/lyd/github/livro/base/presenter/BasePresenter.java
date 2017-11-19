package lyd.github.livro.base.presenter;

/**
 * Created by shawn on 17/11/18.
 */

public abstract class BasePresenter {

    /**
     * Should be called by the view every time it starts
     *
     * @param firstStart is it the first start?
     */
    public void onStart(boolean firstStart) {
    }

}
