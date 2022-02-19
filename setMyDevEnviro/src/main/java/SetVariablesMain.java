package main.java;

import java.io.IOException;
import java.util.Map;

public class SetVariablesMain {

    static String myDevProgramsLocale = "D:\\DevPrograms\\";
    static String myDevSourcesLocale = "D:\\DevSources\\";
    static String[] setCmd = {"cmd","setx AA \"D:\\\""};
    static String cmd =" set aa \"D:\\1\"";
    public static void main(String[] args) throws IOException, InterruptedException {
        RunCmd.run(setCmd);
//        Map existedVariables = System.getenv();
//        if(existedVariables.containsKey(Variables.DEV_HOME)){
//
//        }else{
//            ;
//        }
    }
}
