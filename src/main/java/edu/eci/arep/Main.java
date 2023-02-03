package edu.eci.arep;




import java.net.URL;
import java.io.*;



public class Main {
    public static void main(String[] args)  {
        try {
            URL personalSite = new URL("http://www.google.com/");
            System.out.println("Protocol: " + personalSite.getProtocol());
            System.out.println("Authority: " + personalSite.getAuthority());
            System.out.println("Host: " + personalSite.getHost());
            System.out.println("Port: " + personalSite.getPort());
            System.out.println("Path: " + personalSite.getPath());
            System.out.println("File: " + personalSite.getFile());
            System.out.println("Query: " + personalSite.getQuery());
            System.out.println("Ref.: " + personalSite.getRef());

        }catch (IOException x){
            System.err.println(x);
        }

    }
}