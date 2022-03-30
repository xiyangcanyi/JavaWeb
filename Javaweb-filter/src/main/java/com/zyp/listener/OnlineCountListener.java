package com.zyp.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener  implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount =(Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);

        }else {
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        Integer onlineCount =(Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(0);

        }else {
            int count=onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);
    }
}
