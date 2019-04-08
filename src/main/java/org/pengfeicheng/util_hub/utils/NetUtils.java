package org.pengfeicheng.util_hub.utils;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;

/**
 * @Description: 网络工具类
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/3 4:03 PM
 * @Version: 1.0
 */
public class NetUtils {

    private NetUtils() {}


    /**
     * 获取当前 IP 地址
     * @return
     */
    public static String getIPAddress(){
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] addressBuffer = address.getAddress();
        String ipAddress = "";
        for (int i = 0; i < addressBuffer.length; i++) {
            if (i > 0) {
                ipAddress += ".";
            }
            ipAddress += addressBuffer[i] & 0xFF;
        }
        return ipAddress;
    }


    /**
     * 获取当前设备端口号
     * @return
     */
    public static String getDevicePort(){
        String port = null;
        try{
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            Set<ObjectName> objectNames = mBeanServer.queryNames(new ObjectName("*:type=Connector,*"),
                    Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
            port = objectNames.iterator().next().getKeyProperty("port");
        }catch (MalformedObjectNameException e){
            e.printStackTrace();
        }
        return port;
    }
}
