package exp.iodemos;

import java.io.*;

public class GoodFileCopyEx {
    public static void main(String args[]) {
        GoodFileCopyEx demo = new GoodFileCopyEx();
        demo.execute();
    }

    void execute() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File inputFile = new File("/home/vineet/Documents/novel_cg/mydir/fruits.txt");
            File outFile = new File("/home/vineet/Documents/novel_cg/mydir/fruitscopy.txt");

            inputStream = new FileInputStream(inputFile);
            BufferedInputStream bufferedInputStream= new BufferedInputStream(inputStream);
            outputStream = new FileOutputStream(outFile);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
           byte[] bytes=new byte[1024];
            int newBytesReadCount=0;
            int totalBytesRead=0;
            while ((newBytesReadCount=bufferedInputStream.read(bytes))>0) {
                outputStream.write(bytes,0,newBytesReadCount);
                totalBytesRead=totalBytesRead+newBytesReadCount;
            }
            System.out.println("file written bytes count=" + totalBytesRead);

        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                close(inputStream);
            }
            if (outputStream != null) {
                close(outputStream);
            }
        }

    }

    void close(InputStream inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void close(OutputStream outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
