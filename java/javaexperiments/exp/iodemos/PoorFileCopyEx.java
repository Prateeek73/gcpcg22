package exp.iodemos;

import java.io.*;

public class PoorFileCopyEx {

    public static void main(String args[]) {
        PoorFileCopyEx demo = new PoorFileCopyEx();
        demo.execute();
    }

    void execute() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File inputFile = new File("/home/vineet/Documents/novel_cg/mydir/fruits.txt");
            File outFile = new File("/home/vineet/Documents/novel_cg/mydir/fruitscopy.txt");
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outFile);
            int redByte;
            int redBytesCount = 0;
            while ((redByte = inputStream.read()) != -1) {
                outputStream.write(redByte);
                redBytesCount++;
            }

            System.out.println("file written bytes count=" + redBytesCount);


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
