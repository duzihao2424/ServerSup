package test;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by wdlh on 4/25.
 * 业务接口定义
 */

public interface BussinessService {
    //获取学生信息
    @GET("api/data/Android/10/1")
    Observable<Beantest> getInfo();
}


