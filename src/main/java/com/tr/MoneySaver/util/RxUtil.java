package com.tr.MoneySaver.util;

import rx.Subscription;

public final class RxUtil {
    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
