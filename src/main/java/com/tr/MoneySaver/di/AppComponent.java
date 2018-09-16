package com.tr.MoneySaver.di;

import com.tr.MoneySaver.ui.ItemDetailsActivity;
import com.tr.MoneySaver.ui.ItemListFragment;
import com.tr.MoneySaver.ui.MainActivity;
import com.tr.MoneySaver.ui.StatsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(ItemDetailsActivity itemDetailsActivity);

    void inject(ItemListFragment itemListFragment);

    void inject(StatsActivity statsActivity);
}
