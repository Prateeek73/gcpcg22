package exp.iodemos.charstreamdemos;

import java.io.*;

public class RealWriteFileLines {

    public static void main(String args[]) {
        RealWriteFileLines demo = new RealWriteFileLines();
        demo.execute();
    }

    public void execute() {
        File inputFile = new File("/home/vineet/Documents/novel_cg/mydir/fruits.txt");
        File outFile = new File("/home/vineet/Documents/novel_cg/mydir/filelinesstartA.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            writer = new FileWriter(outFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String redLine;
            int redLinesCount = 0;
            int writeLinesCount = 0;
            while ((redLine = bufferedReader.readLine()) != null) {
                redLinesCount++;
                if (redLine.startsWith("a")) {
                    writeLinesCount++;
                    bufferedWriter.write(redLine+"\r\n");
                }
            }
            System.out.println("all line starting with a written in the file");
            System.out.println("red lines count=" + redLinesCount + " lins starting with a=" + writeLinesCount);
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                close(reader);
            }
            if (writer != null) {
                close(writer);
            }
        }
    }

    void close(Reader inputStream) {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void close(Writer outputStream) {
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

