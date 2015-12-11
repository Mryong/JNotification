package org.jerry.test.jnotification;

import org.jerry.jnotification.Notification;

public class Observer {

    public void onNotification(Notification notification) {
        System.out.println(notification);
    }

}
