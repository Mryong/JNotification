package org.jerry.test.jnotification;

import org.jerry.jnotification.Notification;
import org.jerry.jnotification.NotificationCenter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong_pliang on 15/12/11.
 */

public class NotificationTester {

    @Test
    public void test() throws NoSuchMethodException {
        Observer observer = new Observer();
        NotificationCenter notificationCenter = NotificationCenter.getInstance();
        notificationCenter.addObserver(observer, Observer.class.getMethod("onNotification", Notification.class), "NotificationName", null);


        Sender sender = new Sender();
        Map<String, Object> userInfo =  new HashMap<String, Object>();
        userInfo.put("key","value");
        notificationCenter.postNotification(sender,"NotificationName",userInfo);
    }

}
