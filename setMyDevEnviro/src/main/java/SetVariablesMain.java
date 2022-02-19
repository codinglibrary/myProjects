package main.java;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static main.java.Before.addNewAddrToTheVariableValue;

public class SetVariablesMain {

    static Logger log = LoggerFactory.getLogger(SetVariablesMain.class);
    static String desKey="DEV_HOMEss";
    static String newAddr = "K:";

    static final String keyFilePath=".\\src\\main\\resources\\key.txt";
    static final String valueFilePath=".\\src\\main\\resources\\value.txt";
    public static void main(String[] args) throws IOException, InterruptedException {

        //============================================================================
        String desValueString = Before.addNewAddrToTheVariableValue(newAddr,desKey);
        Before.refreshTxt(desValueString,valueFilePath);
        Before.refreshTxt(desKey,keyFilePath);

        //============================================================================
        //调用我们在项目目录下准备好的bat文件，如果不是在项目目录下，则把“你的文件名.bat”改成文件所在路径。
        RunCmd.setCommand("cmd /c start  .\\src\\main\\resources\\ps.bat");
        RunCmd.run();  //调用上面的run_cmd方法执行操作

    }
}
