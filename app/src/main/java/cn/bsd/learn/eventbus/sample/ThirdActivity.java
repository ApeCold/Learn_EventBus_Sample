//package cn.bsd.learn.eventbus.sample;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//import cn.bsd.learn.eventbus.sample.bean.EventBean;
//
//public class ThirdActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_third);
//    }
//
//    //点击
//    public void getMessage(View view) {
//        //注册
//        EventBus.getDefault().register(this);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
//    public void receiveEventBus(EventBean bean){
//        Log.e("EventBus >>3>> ","thread = "+Thread.currentThread().getName());
//        Log.e("EventBus >>3>> ",""+bean.getName());
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //解注册
//        EventBus.getDefault().removeAllStickyEvents();
//        EventBus.getDefault().unregister(this);
//    }
//}
