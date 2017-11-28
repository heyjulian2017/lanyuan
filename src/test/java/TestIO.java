import java.io.*;

/**
 * Created by ln on 2017/1/22.
 */
public class TestIO {

    public static void main(String[] args) {
        try {
//            System.out.println(System.getProperty("user.dir"));
            FileReader fis = new FileReader("d:\\test.txt");//字符流
//            BufferedReader br = new BufferedReader(fis);//包装流
            FileWriter fw = new FileWriter("d:\\test2.txt");
            char[] content = new char[1024];
            while (fis.read(content) > 0) {
                System.out.println("1");
                fw.write(content);
            }
            fis.close();
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
