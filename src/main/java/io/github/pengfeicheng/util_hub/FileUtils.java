package io.github.pengfeicheng.util_hub;

import java.io.*;

/**
 * @Description: 文件工具处理类
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/3 3:39 PM
 * @Version: 1.0
 */
public final class FileUtils {


    private FileUtils() { }

    /**
     * 获取文件后缀名称
     * @param filePath 文件路径
     * @return 文件的后缀格式
     */
    public static String getFileSuffix(String filePath){
        if(StringUtils.isEmpty(filePath)) return null;
        int index = filePath.lastIndexOf(".");
        if(index > 0 && index + 1 < filePath.length() - 1){
            return filePath.substring(index + 1);
        }
        return null;
    }


    /**
     * 创建目录，如果目录已经存在则直接返回
     * @param dirPath
     * @return true -> 目录创建成功、目录已经存在;false -> 目录创建失败
     */
    public static boolean createDirectory(String dirPath){
        File file = new File(dirPath);
        if(!file.exists())
            return file.mkdirs();
        return true;
    }


    /**
     * 如果指定路径的文件/目录不存在，则创建此路径文件/目录
     * @param path
     * @return true -> 创建成功
     */
    public static boolean createFile(String path){

        String suffix = getFileSuffix(path);
        if(StringUtils.isEmpty(suffix)){
            return createDirectory(path);
        }

        String separator = File.separator;
        int index = path.lastIndexOf(separator);
        if(index > 0){
            String dir = path.substring(0,index);
            if(!createDirectory(dir)){
                return false;
            }
        }
        boolean result = createFile(path);
        return result;
    }


    /**
     * 删除指定目录、文件
     * @param path 目录或者文件路径
     * @return
     */
    public static void delete(String path){
        File file = new File(path);
        if(file.exists()){
            if(file.isFile()){
                file.delete();
            }else{
                String parentPath = file.getAbsolutePath();
                String[] subFile = file.list();
                if(subFile == null || subFile.length == 0){         // 子文件列表为空则删除空目录
                    file.delete();
                }
                else{
                    for(String name : subFile){
                        String filePath = parentPath + File.separator + name;
                        delete(filePath);
                    }
                }
            }
        }
    }


    /**
     * 打开文件输入流
     * @param filePath
     * @return 文件输入流或者null（如果文件不存在或者打开输入流失败）
     */
    public static InputStream openFileInputStream(String filePath){
        File file = new File(filePath);
        if(file.exists() && file.canRead()){
            try {
                FileInputStream input = new FileInputStream(file);
                return input;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 打开文件输出流
     * @param filePath
     * @return 文件输出流或者null（如果文件不存在或者打开输出流失败）
     */
    public static OutputStream openFileOutputStream(String filePath){
        File file = new File(filePath);
        if(file.exists() && file.canWrite()){
            try {
                FileOutputStream output = new FileOutputStream(file);
                return output;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 关闭流
     * @param stream
     */
    public static void closeStream(Closeable stream){
        if(null == stream) return;
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将指定内容追加到指定路径的文件
     * @param filePath
     * @param content
     */
    public static synchronized void append(String filePath,String content){

        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(filePath);
            if (!f.exists()){
                f.createNewFile();
            }

            fw = new FileWriter(f, true);
            fw.write(content);
            fw.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将输入流写入到指定的文件中，写入结束后，别忘记关闭处理输入流
     * @param input 输入流
     * @param destFilePath 存储目标文件路径
     * @return -1 表示文件写入过程中异常；>= 0 表示写入数据长度
     */
    public static long writeToFile(InputStream input, String destFilePath){
        if(createFile(destFilePath)){
            OutputStream output = openFileOutputStream(destFilePath);
            if(null != output){
                byte[] buffer = new byte[1024];
                int readLength;
                long count = 0;
                try {
                    while((readLength = input.read(buffer)) != -1){
                        output.write(buffer,0,readLength);
                        count += readLength;
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return -1;
                }
                finally {
                    closeStream(output);
                }
                return count;
            }
        }
        return -1;
    }
}
