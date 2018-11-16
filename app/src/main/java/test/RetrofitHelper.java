package test;

import android.content.Context;


import com.dzh.netlibrary.DzhHttpClient;
import com.dzh.netlibrary.network.DzhConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


public class RetrofitHelper {

    private Retrofit  businessRetrofit = null;
    private Context mContext;

    OkHttpClient client = DzhHttpClient.getHttpClient();

    private static RetrofitHelper instance = null;

    public static RetrofitHelper getInstance(Context context) {
        if (instance == null) {
            instance = new RetrofitHelper(context);
        }
        return instance;
    }

    public RetrofitHelper(Context context) {
        mContext = context;
    }



    public void initBusinessRetrofit() {
        businessRetrofit = null;
        businessRetrofit = new Retrofit.Builder()
                .baseUrl("https://gank.io/")
                .client(client)
                .addConverterFactory(DzhConverterFactory.getFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }



    public void clearAllRetrofit(){
        businessRetrofit = null;
    }


    public BussinessService getService() {
        if (businessRetrofit == null){
            initBusinessRetrofit();
        }
        return businessRetrofit.create(BussinessService.class);
    }
}
