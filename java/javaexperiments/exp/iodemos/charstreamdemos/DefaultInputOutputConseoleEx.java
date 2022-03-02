package exp.iodemos.charstreamdemos;

import java.io.*;

public class DefaultInputOutputConseoleEx {

    public static void main(String[] args) throws Exception {
        DefaultInputOutputConseoleEx demo = new DefaultInputOutputConseoleEx();
        demo.execute();
    }

    public void execute() {
        InputStream defaultInputStream = System.in;
        Reader reader = new InputStreamReader(defaultInputStream);
        OutputStream defaultOutputStream = System.out;
        Writer writer = new OutputStreamWriter(defaultOutputStream);
        try {
            char redChar;
            while ((redChar = (char) reader.read()) != 'z') {
                writer.write(redChar);
            }
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


