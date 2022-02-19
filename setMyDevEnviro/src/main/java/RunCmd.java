package main.java;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;

public class RunCmd {
    static Logger log = LoggerFactory.getLogger(RunCmd.class);

    private static String command;
    public static void setCommand(String command){
        RunCmd.command = command;
    }
    public static boolean run(){
        if(RunCmd.command ==null){
            log.error("Command haven't be set.");
            return false;
        }
        Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
        Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
        try {
            ps = rt.exec(RunCmd.command);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            ps.waitFor();  //等待子进程完成再往下执行。
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i = ps.exitValue();  //接收执行完毕的返回值
        if (i == 0) {
            System.out.println("执行完成.");
        } else {
            System.out.println("执行失败.");
        }

        ps.destroy();  //销毁子进程
        ps = null;
        return true;
    }

    public static boolean run(String command) {
        if(command != null){
            Runtime rt = Runtime.getRuntime(); //Runtime.getRuntime()返回当前应用程序的Runtime对象
            Process ps = null;  //Process可以控制该子进程的执行或获取该子进程的信息。
            try {
                ps = rt.exec(command);   //该对象的exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
                ps.waitFor();  //等待子进程完成再往下执行。
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            int i = ps.exitValue();  //接收执行完毕的返回值
            if (i == 0) {
                System.out.println("执行完成.");
            } else {
                System.out.println("执行失败.");
            }

            ps.destroy();  //销毁子进程
            ps = null;
        }
        return false;
    }
    public static boolean run(String[] command) throws IOException {
        if(command != null){
            Process ps = Runtime.getRuntime().exec(command);

            return true;
        }
        return false;
    }
}
