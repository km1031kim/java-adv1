package buffer;

import java.io.*;

public class MyBufferTest {

    // 10MB
    private static final int FILE_SIZE = 10 * 1024 * 1024;
    private static final String SOURCE_FILE = "C:\\Users\\user\\Desktop\\apache-tomcat-9.0.98.tar.gz";
    public static void main(String[] args) throws IOException {
        // 버퍼
        copyWithoutBuffer();
        copyWithBuffer();

    }

    public static void copyWithoutBuffer() throws IOException {
        System.out.println("버퍼 없는 복사 시작");
        long startTime = System.currentTimeMillis();

        byte[] myBuffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(SOURCE_FILE)) {
            while (fis.read(myBuffer) != -1) {
            }
        }

        byte b = myBuffer[0];
        System.out.println("b = " + b);
        long endTime = System.currentTimeMillis();

        System.out.println("완료.. 소요시간 : " + (endTime - startTime) + "ms");
    }

    public static void copyWithBuffer() throws IOException {
        System.out.println("버퍼를 통한 복사 시작");
        long startTime = System.currentTimeMillis();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(SOURCE_FILE), 1024)) {
            while (bis.read() != -1) {
            }
            int read = bis.read();
            System.out.println("read = " + read);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("완료.. 소요시간 : " + (endTime - startTime) + "ms");
    }

}
