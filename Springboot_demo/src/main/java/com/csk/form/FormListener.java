package com.csk.form;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author csk
 * @date 2023/11/22 21:38
 */
@WebListener
public class FormListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre){
        System.out.println("FormListener初始化");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("FormListener被销毁");
    }


}
