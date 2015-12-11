# 如何在Android使用Notification
家都知道在iOS中Controller之间传递数据最常用的就是delegate和通知了,特别是通知,可以很方便在任何对象直接传递数据,而且是很好的解耦设计.  在Android之中 传递数据一般用Intent的data功能, 但是如果数据传递比较复杂,这就比较麻烦. 在Android中有广播组建,但是一般用于应用之间,效率比较低.而且做界面更新的时候也比较困难. 今天我要给大家介绍的是一个Android版本的Notification,使用的api和iOS的 Notification几乎一样.

1.注册通知

```
//向通知中心注册通知
          NotificationCenter.getInstance().addObserver(this,this.getClass().getMethod("onNotification",Notification.class),"NotificationName",null);

//当监听到通知
public void onNotification(Notification notification){
       System.out.println("接收到通知"+notification);
       //TODO 界面更新和其他处理
 } 

//当Activity销毁时从通知中心取消注册
@Override
protected void onDestroy() {
super.onDestroy();
    NotificationCenter.getInstance().removeObserver(this);
 }
     
```

2.发送通知

```
//发布通知
Map<String,Object> userInfo = new HashMap<>();
userInfo.put("key","value");

NotificationCenter.getInstance().postNotification(this,"NotificationName",userInfo);
```
