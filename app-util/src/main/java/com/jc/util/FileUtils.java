package com.jc.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-10-10
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */
public class FileUtils {
    private static final Logger log = Logger.getLogger(FileUtils.class);
    public static void create(String pathStr,String fileName,String fileStr){
        File path = new File(pathStr);
        if(!path.exists()){
            path.mkdirs();
        }
        FileOutputStream outputStream = null;
        OutputStreamWriter writer = null;
        try {
            File file = new File(pathStr,fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            writer = new OutputStreamWriter(outputStream,"utf-8");
            writer.write(fileStr);
            writer.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally{
            try {
                outputStream.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void create(String pathStr,String fileName,byte[] bytes){
        File path = new File(pathStr);
        if(!path.exists()){
            path.mkdirs();
        }
        FileOutputStream outputStream = null;
        try {
            File file = new File(pathStr,fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally{
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 创建文件或目录
     * @param path
     * @return
     */
    public static boolean creatFile(String path){
        File file = new File(path);
        if(file.isDirectory()&&(file.exists()==false)){
            file.mkdirs();
            return true;
        }else {
            File pf = file.getParentFile() ;
            if(pf!=null && (pf.exists()==false)){
                pf.mkdirs();
                try {
                    file.createNewFile();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }
}
