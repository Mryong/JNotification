package org.jerry.jnotification;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by Jerry.Yong on 2014/10/20.
 */
public class NotificationCenter {
    private static NotificationCenter instance = new NotificationCenter();
    private Vector<ObserverModel> observerModels = new Vector<ObserverModel>();


    public synchronized static NotificationCenter getInstance() {
        return instance;
    }


    private NotificationCenter() {
    }


    public void postNotification(final Object sender, final String name, final Map userInfo) {
        dispense(new Notification(sender, name, userInfo));
    }


    public void postNotification(final Object sender, final String name) {
        dispense(new Notification(sender, name, null));
    }

    public void addObserver(final Object observer, final Method selector, final String name, final Object sender) {
        observerModels.add(new ObserverModel(observer, selector, name, sender));
    }

    public void removeObserver(Object observer) {
        List<ObserverModel> removes = new ArrayList<ObserverModel>();
        int size = observerModels.size();
        for (int i = 0; i < size; i++) {
            ObserverModel observerModel = observerModels.get(i);
            if (observerModel.getObserver().equals(observer)) {
                removes.add(observerModel);
            }
        }
        observerModels.removeAll(removes);
    }

    public void removeObserver(Object observer, String name) {
        if (name == null) {
            removeObserver(observer);
            return;
        }
        List<ObserverModel> removes = new ArrayList<ObserverModel>();
        int size = observerModels.size();
        for (int i = 0; i < size; i++) {
            ObserverModel observerModel = observerModels.get(i);
            if (observerModel.getObserver().equals(observer) && observerModel.getName().equals(name)) {
                removes.add(observerModel);
            }
        }
        observerModels.removeAll(removes);
    }


    public void dispense(Notification notification) {
        for (int i = 0; i < observerModels.size(); i++) {
            String sendName = notification.getName();
            Object sendSender = notification.getSender();

            ObserverModel observerModel = observerModels.get(i);
            String observeName = observerModel.getName();
            Object observeSender = observerModel.getSender();

            if ((isEmpty(observeName) || observeName.equals(sendName))
                    && (observeSender == null || observeSender.equals(sendSender))) {
                Object observer = observerModel.getObserver();
                Method method = observerModel.getSelector();

                try {
                    method.invoke(observer, notification);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static boolean isEmpty(String str) {
        if (str == null || str.trim().equals("")) {
            return true;
        }
        return false;
    }


    private class ObserverModel {
        private Object observer;
        private Method selector;
        private String name;
        private Object sender;

        public Object getObserver() {
            return observer;
        }

        public void setObserver(Object observer) {
            this.observer = observer;
        }

        public Method getSelector() {
            return selector;
        }

        public void setSelector(Method selector) {
            this.selector = selector;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getSender() {
            return sender;
        }

        public void setSender(Object sender) {
            this.sender = sender;
        }

        private ObserverModel(Object observer, Method selector, String name, Object sender) {
            this.observer = observer;
            this.selector = selector;
            this.name = name;
            this.sender = sender;
        }
    }
}
