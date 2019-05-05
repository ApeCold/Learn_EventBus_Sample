//package cn.bsd.learn.eventbus.sample.bus;
//
//import rx.functions.Func1;
//import rx.subjects.PublishSubject;
//import rx.subjects.SerializedSubject;
//import rx.subjects.Subject;
//
//public class RxBus {
//    private static volatile RxBus mInstance;
//    //PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
//    private final Subject<Object,Object> bus = new SerializedSubject<>(PublishSubject.create());
//
//    private RxBus(){
//
//    }
//
//    public static RxBus getInstance(){
//        if (mInstance == null){
//            synchronized (RxBus.class){
//                if (mInstance==null) {
//                    mInstance=new RxBus();
//                }
//            }
//        }
//        return mInstance;
//    }
//
//    //发送一个新的事件
//    public void send(Object event) {bus.onNext(event);}
//
//    //根据传递的eventType 类型返回特定类型（eventType）的被观察者
//    public <T> rx.Observable<T> take(final Class<T> eventType){
//        return bus.filter((Func1)(o)->{
//            return eventType.isInstance(o);
//        }).cast(eventType);
//    }
//}
