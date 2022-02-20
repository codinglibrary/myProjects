package main.java;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.IOException;

public class SetVariablesMain {

    static Logger log = LoggerFactory.getLogger(SetVariablesMain.class);
    static String desKey="SCRIPT_HOME";
    static String newAddress = "D:\\DevSources\\myProjects\\MyScripts\\bin";

    static final String keyFilePath=".\\src\\main\\resources\\key.txt";
    static final String valueFilePath=".\\src\\main\\resources\\value.txt";
    public static void main(String[] args) throws IOException, InterruptedException {

        //================================设置key和value===============================
        String desValueString = FileOperation.addNewAddressToTheVariableValue(newAddress,desKey);
        FileOperation.refreshTxt(desValueString,valueFilePath);
        FileOperation.refreshTxt(desKey,keyFilePath);

        //================================调用cmd======================================
        //调用我们在项目目录下准备好的bat文件，如果不是在项目目录下，则把“你的文件名.bat”改成文件所在路径。
        RunCmd.setCommand("cmd /c start  .\\src\\main\\resources\\ps.bat");
        RunCmd.run();  //调用上面的run_cmd方法执行操作

    }
}
