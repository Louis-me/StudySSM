package xyz.shi.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 在Tomcat关闭或重启的时候，会报这样的异常信息。
//web应用程序似乎启动了一个名为[mysql-cj-abandoned-connection-cleanup]的线程，但未停止，可能会造成内存泄漏
//解决方法：设置监听器，在服务器注销的时候运行这句话就不会有问题了
@WebListener
public class Listener_My implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            // 关闭数据库连接
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("销毁工作异常");
        }
    }
}