package exp.iodemos;

import java.io.File;

public class FileApiEx {

    public static void main(String args[]) {
        File dir = new File("/home/vineet/Documents/novel_cg/mydir");
        boolean isDir = dir.isDirectory();
        boolean exists = dir.exists();
        String name = dir.getName();        ;
        String path = dir.getAbsolutePath();
        System.out.println("exists=" + exists);
        System.out.println("dir name =" + name);
        System.out.println("absolute path=" + path);
        System.out.println("******iterating files");
        if (isDir) {
            File files[] = dir.listFiles();
            for (File iteratedFile : files) {
                System.out.println("iterated file=" + iteratedFile.getName());
            }
        }
    }
}
