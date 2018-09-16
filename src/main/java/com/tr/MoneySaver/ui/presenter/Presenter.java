package com.tr.MoneySaver.ui.presenter;

import com.tr.MoneySaver.ui.view.BaseView;

public interface Presenter<V extends BaseView> {
    void bind(V view);
    void unbind();
}
