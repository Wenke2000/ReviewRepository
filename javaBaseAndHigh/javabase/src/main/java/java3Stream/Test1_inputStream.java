package java3Stream;

import java.io.*;

public class Test1_inputStream {

    public static void main(String[] args) throws IOException {
        //创建一个目录
        String dirPath="E:\\JAVA_LAB\\IOTest";
        File dir=new File(dirPath);
        if (!dir.exists())
        {
            dir.mkdirs();
        }

        //创建源文件
        File srcFile=new File("E:\\JAVA_LAB\\A.txt");

        //创建目的文件
        File desFile=new File(dirPath+"B.txt");
        if (!desFile.exists()){
            desFile.createNewFile();
        }

        //创建输入输出文件流
        InputStream is=new FileInputStream(srcFile);
        OutputStream os=new FileOutputStream(desFile);

        //转换字节符输出流
        InputStreamReader isr=new InputStreamReader(is,"UTF-8");
        OutputStreamWriter osw=new OutputStreamWriter(os,"UTF-8");

        //添加字节流缓冲区
        BufferedReader br=new BufferedReader(isr);
        BufferedWriter bw=new BufferedWriter(osw);

        //得到srcfile的大小
        int size=is.available();
        int c;
        while((c=br.read())>=0){
            bw.write(c);
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
