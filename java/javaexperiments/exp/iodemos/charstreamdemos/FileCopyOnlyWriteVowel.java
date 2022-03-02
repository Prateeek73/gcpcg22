package exp.iodemos.charstreamdemos;

import java.io.*;

public class FileCopyOnlyWriteVowel {

    public static void main(String args[]) {
        FileCopyOnlyWriteVowel demo = new FileCopyOnlyWriteVowel();
        demo.execute();
    }

    public void execute() {
        File inputFile = new File("/home/vineet/Documents/novel_cg/mydir/fruits.txt");
        File outFile = new File("/home/vineet/Documents/novel_cg/mydir/fruitscopyvowel.txt");
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(inputFile);
            writer = new FileWriter(outFile);
            int redChar;
            int charsCount=0;
            int vowelCount=0;
            while ((redChar= reader.read()) != -1) {
                char ch=(char)redChar;
                charsCount++;
                if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                    writer.write(redChar);
                    vowelCount++;
                }
            }
            System.out.println("vowels written in the file");
            System.out.println("chars found="+charsCount+" vowelscount="+vowelCount);
            writer.flush();
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

