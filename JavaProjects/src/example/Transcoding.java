package example;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Base64;

public final class Transcoding {
    public static boolean transcode(String sourcePath,String sourceName,String sourceFormat,String destinationPath) {
        String source = sourcePath+"\\"+sourceName+"."+sourceFormat;
        String destination = sourcePath+"\\"+sourceName+"_base64.txt";
        File file = new File(destination);
        if(file.exists()){
            System.out.println("存在同名文件");
            return false;
        }

        String base64 = fileToBase64(source);
        byte[] bytes = new byte[base64.length()];
        bytes = base64.getBytes();
        //输出到新文件
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try{
            file.createNewFile();
            fos = new FileOutputStream(file);
            //fos.write(bytes,0,base64.length());
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String  fileToBase64(String path){
        String base64 = null;
        InputStream inputStream = null;
        try{
            File file = new File(path);
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            //System.out.println(Arrays.toString(bytes));
            base64 = Base64.getEncoder().encodeToString(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }
        }
        return base64;
    }
    private static boolean base64ToFile(String base64, String path,String fileName,String imageFormat){

        FileInputStream in = null;
        try{
            File old = new File(path+"\\"+fileName+'.'+imageFormat);
            in = new FileInputStream(old);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if( in !=null){
                System.out.println("目的地址存在同名文件");
                return false;
            }
        }
        File file = null;
        //目录不存在则创建目录
        File dir = new File(path);
        if(!dir.exists() && !dir.isDirectory()){
            dir.mkdir();//创建目录
        }
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try{
            byte[] bytes = Base64.getDecoder().decode(base64);//解码base64字符流到byte数组
            file = new File(path+"\\"+fileName+'.'+imageFormat);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bos != null){
                try {
                    bos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
