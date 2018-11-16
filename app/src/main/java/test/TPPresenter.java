package test;

import android.content.Context;

import com.dzh.netlibrary.presenter.BasePresenter;
import com.dzh.netlibrary.util.NetUtil;


import rx.android.schedulers.AndroidSchedulers;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class TPPresenter extends BasePresenter {
    private Context context;
    private TPView tpView;
    private ServiceManager serviceManager;


    public TPPresenter(Context context, TPView tpView){
        this.context = context;
        this.tpView = tpView;
        this.serviceManager = new ServiceManager(context);
    }


    public void getInfo(){
        if (NetUtil.isConnectNetwork(context)){
            mCompositeSubscription.clear();
        }
        mCompositeSubscription.add(serviceManager.getInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Beantest>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(Beantest beantest) {
                        tpView.onSuccess(beantest);
                    }

                }));
    }



}
