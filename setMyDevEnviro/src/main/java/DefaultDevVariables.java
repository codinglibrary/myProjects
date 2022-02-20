package main.java;

import lombok.Data;

@Data
public class DefaultDevVariables {
    private static final String DEV_HOME="D:\\DevPrograms";

    //git
    private static String gitPath1=DEV_HOME+"\\Git\\bin";
    private static String gitPath2=DEV_HOME+"\\Git\\cmd";

    //jdk
    private static String javaPath=DEV_HOME+"\\jdk\\jdk_1.8\\bin";

    //python
    private static String pythonPath=DEV_HOME+"\\Python\\Python39-32";

    //myScript
    private static String myScriptPath=DEV_HOME+"\\Scripts\\bin";

}
