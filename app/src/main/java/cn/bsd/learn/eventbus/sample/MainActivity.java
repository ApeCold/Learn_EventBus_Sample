package cn.bsd.learn.eventbus.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.bsd.learn.eventbus.library.EventBus;
import cn.bsd.learn.eventbus.library.ThreadMode;
import cn.bsd.learn.eventbus.library.annotation.Subscribe;
import cn.bsd.learn.eventbus.sample.bean.EventBean;

//订阅事件
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册
        EventBus.getDefault().register(this);
//        rxBux();
    }

//    //RxBus订阅
//    private void rxBux(){
//        RxBus.getInstance().take(RxBean.class)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(rxBean -> {
//                    Log.e("RxBus >>1>> ","Time = " + System.currentTimeMillis());
////                    Log.e("RxBus >>1>> ",rxBean.getName());
//                });
//    }

    //EventBus订阅
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getMessage(EventBean bean){
//        Log.e("EventBus >>1>> ","Time = " + System.currentTimeMillis());
        Log.e("EventBus >>1>> ","thread = "+Thread.currentThread().getName());
        Log.e("EventBus >>1>> ",bean.getName());
    }

    //点击
    public void click(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        EventBus.getDefault().unregister(this);
//    }

}
