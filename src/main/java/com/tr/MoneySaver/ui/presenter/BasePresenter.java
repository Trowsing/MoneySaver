package com.tr.MoneySaver.ui.presenter;

import com.tr.MoneySaver.ui.view.BaseView;

public class BasePresenter<V extends BaseView> implements Presenter<V> {
    private V mView;

    @Override
    public void bind(V view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    protected final V getView() {
        return mView;
    }
}

