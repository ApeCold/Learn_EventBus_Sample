package cn.bsd.learn.eventbus.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.bsd.learn.eventbus.library.EventBus;
import cn.bsd.learn.eventbus.sample.bean.EventBean;

//事件发布
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    //点击
    public void eventBus(View view) {
        //子线程
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                Log.e("EventBus >>2>> ","thread = "+Thread.currentThread().getName());
//                EventBus.getDefault().post(new EventBean("EventBean"));
//            }
//        }.start();
        Log.e("EventBus >>2>> ","thread = "+Thread.currentThread().getName());
        //发布
        EventBus.getDefault().post(new EventBean("EventBean"));
        finish();
//        EventBus.getDefault().postSticky(new EventBean("id=2"));

//        long currentTime = System.currentTimeMillis();
//        for (int i=0;i<20;i++){
//            EventBus.getDefault().post(new EventBean("EventBus"));
//        }
//        long finishTime = System.currentTimeMillis();
//        Log.e("EventBus >>2>> ","Time = "+(finishTime-currentTime));
//        finish();
    }

//    //点击
//    public void rxBus(View view) {
////        Log.e("RxBus >>2>> ","thread = "+Thread.currentThread().getName());
////        RxBus.getInstance().send(new RxBean("RxBus"));
////        finish();
//
//        long currentTime = System.currentTimeMillis();
//        for (int i=0;i<20;i++){
//            RxBus.getInstance().send(new RxBean("RxBus"));
//        }
//        long finishTime = System.currentTimeMillis();
//        Log.e("RxBus >>2>> ","Time = "+(finishTime-currentTime));
//        finish();
//    }
//
//    //点击
//    public void jump(View view) {
//        startActivity(new Intent(this,ThirdActivity.class));
//    }
}
