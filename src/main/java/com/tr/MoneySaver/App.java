package com.tr.MoneySaver;

import android.app.Application;

import com.tr.MoneySaver.di.AppComponent;
import com.tr.MoneySaver.di.AppModule;
import com.tr.MoneySaver.di.DaggerAppComponent;

public class App extends Application {
    private static App sApp;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return sApp.mAppComponent;
    }
}
