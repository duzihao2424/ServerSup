package com.dzh.netlibrary.presenter;


import com.dzh.netlibrary.util.Logger;

import rx.subscriptions.CompositeSubscription;


/**
 * Created by wdlh on 5/30.
 */

public abstract class BasePresenter {
    public Logger logger = Logger.getLogger();
    public CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public void onDestory(){
        mCompositeSubscription.unsubscribe();
    }
}
