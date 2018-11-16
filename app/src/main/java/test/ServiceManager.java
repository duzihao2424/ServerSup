package test;

import android.content.Context;
import rx.Observable;

/**
 * Created by wdlh on 4/25.
 */

public class ServiceManager {
    private BussinessService bussinessService;

    private Context mcontext;
    public ServiceManager(Context context) {
        this.mcontext=context;
        this.bussinessService = RetrofitHelper.getInstance(context).getService();
    }
    /**
     * 获取老师信息
     */
    public Observable<Beantest> getInfo(){
        return bussinessService.getInfo();
    }

}
