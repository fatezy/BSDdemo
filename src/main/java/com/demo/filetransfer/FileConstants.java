package com.demo.filetransfer;

/**
 * Created by 张亚飞 on 2018/12/10.
 */
public class FileConstants {
    //此配置为服务端配置，客户端无需配
    public final static String RECEIVE_FILE_PATH = "G:\\receive\\";

    // 此文件夹暂时无需配置，配置此文件夹调用，client的service方法可实现整个文件夹内容的传输
    public final static String SEND_FILE_PATH = "G:\\send";

    public final static int DEFAULT_BIND_PORT = 10000;
    //服务端ip
    public final static String DEFAULT_IP = "localhost";

}

 