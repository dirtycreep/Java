import java.io.*;
public class Test {
    public static void main(String[] args) throws Exception, UnsupportedEncodingException, FileNotFoundException, IOException {
        int k1 = 2;
        int k2 = 9;
    newFile(k1, k2);
}


    public static void newFile(int k1, int k2) throws Exception, UnsupportedEncodingException, FileNotFoundException, IOException {
         String UTF8 = "UTF-8";
        FileWriter nFile = new FileWriter("file1.txt");

        for (int i = k1; i <= k2; i++) {

            nFile.write(i+"\n");

        }

        nFile.close();
    }
}

