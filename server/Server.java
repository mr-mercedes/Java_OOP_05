package ru.geekbrains.oop05.mvp.homework.calculator.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            for(;;) {
                Socket socket = serverSocket.accept();
                String pt ="D:\\JavaDev\\NewJava\\GeekBrains_java_basic\\src\\main\\java\\ru\\ru\\geekbrains\\oop05\\http_server\\";
                System.out.println("Client connected");
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), StandardCharsets.UTF_8));

                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream());

                while (!reader.ready()) ;

                while (reader.ready()) {
                    String[] arr = reader.readLine().split(" ");
                    String[] str = arr[1].split("/");
                    Path path = Paths.get(pt + str[1]);
                    System.out.println(path);
                    if (Files.exists(path)){
                        path = Paths.get( path + "/" + str[2]);
                        if (Files.exists(path)){
                            System.out.println("Everything is ok");
                        }
                    } else {
                        System.out.println("System error 404");
                    }
                    break;

                }



                writer.println("HTTP/1.1 200 OK");
                writer.println("Content-Type: text/html; charset=utf-8");
                writer.println();
                writer.println("<h1>Hello world!!!</h1>");
                writer.flush();

                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
