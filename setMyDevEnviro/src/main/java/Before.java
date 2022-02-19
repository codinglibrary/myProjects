package main.java;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Before {
    static Logger log = LoggerFactory.getLogger(Before.class);

    static final Map<String,String> existedVariables = getExistedVariable();

    private static Map getExistedVariable(){
        return System.getenv();
    }

    public static String addNewAddrToTheVariableValue(String addr,String theVariable){
        if(existedVariables.containsKey(theVariable)){
            System.out.println("Already exists.");
            String valuePlain = existedVariables.get(theVariable);

            //切割字符串
            boolean isTheValueExist = false;
            String [] strArr = valuePlain.split(";");
            List<String> valueList = new ArrayList<>();
            for( String str: strArr){
                if(str.equals(addr)){
                    isTheValueExist = true;
                }
                valueList.add(str);
            }

            //添加新地址
            if(isTheValueExist==false){
                valueList.add(addr);
            }else{
                System.out.println("The value has been in ,it will not be added.");
            }

            //拼接字符串
            StringBuilder desValueBuilder = new StringBuilder();
            for(int i=0;i<valueList.size();i++){
                desValueBuilder.append(valueList.get(i));
                desValueBuilder.append(";");
            }
            //返回变量


            return desValueBuilder.toString();
        }else{
            System.out.println("The variable given doesn't exist.There will be create a new.");

            return addr+";";
        }
    }
    public static boolean refreshTxt(String string,String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            log.debug("Create new file.");
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(string);
        bufferedWriter.close();
        return true;
    }
}
