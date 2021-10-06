package nia.chapter1;

import org.junit.Test;

import java.net.Socket;

import static org.junit.Assert.*;

/**
 * 启动server, 阻塞在accept, 然后启动client
 */
public class BlockingIoExampleTest {

    private static final int portNum = 8080;

    @Test
    public void serve() {
        try {
            BlockingIoExample blockingIoExample = new BlockingIoExample();
            blockingIoExample.serve(portNum);
        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
    }

    @Test
    public void client() {
        try {
            Socket socket = new Socket("127.0.0.1", portNum);
            socket.getOutputStream().write("HelloServer".getBytes());
            socket.getOutputStream().flush();
            System.out.println("write over");

        } catch (Exception e) {
            System.out.println("exception: " + e);
        }
    }


}