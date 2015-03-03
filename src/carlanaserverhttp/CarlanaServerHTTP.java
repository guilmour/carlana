package carlanaserverhttp;
/**
 *
 * @author guilmour.com
 */

import java.lang.*;
import java.lang.System;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.io.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class CarlanaServerHTTP {


    public static void main(String[] args) throws Exception  {
        
        System.out.println(":::::: Carlava HTTP Server v0.1 ::::::");
        HttpServer carlanaserver = HttpServer.create(new InetSocketAddress(8000), 0);
        carlanaserver.createContext("/", new MyHandler());
        carlanaserver.setExecutor(null);
        carlanaserver.start();

        
    }
    
    static class MyHandler implements HttpHandler{
        public void handle (HttpExchange t) throws IOException {
            
            /*String response = "Testando";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
            */
            
            // a PDF (you provide your own!)
            File file = new File ("/home/todos/alunos/ct/a1559648/NetBeansProjects/www/index.html");
            byte [] bytearray  = new byte [(int)file.length()];
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            bis.read(bytearray, 0, bytearray.length);

            // ok, we are ready to send the response.
            t.sendResponseHeaders(200, file.length());
            OutputStream os = t.getResponseBody();
            os.write(bytearray,0,bytearray.length);
            os.close();
        }
        
        
        
    }
    
}
