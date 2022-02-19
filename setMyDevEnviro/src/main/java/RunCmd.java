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

        return true;
    }

    public static boolean run(String command) throws IOException {
        if(command != null){
            Process ps = Runtime.getRuntime().exec(command);

            return true;
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
