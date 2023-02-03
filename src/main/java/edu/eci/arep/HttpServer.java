package edu.eci.arep;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        boolean running = true;
        ServerSocket serverSocket = null;
        String cacheData = "";
        String path = " ";



        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        while (running){
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean firstLine = true;
            while ((inputLine = in.readLine()) != null) {
                if (firstLine){
                    firstLine = false;
                    path = inputLine.split(" ")[1];
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {break;}
            }
            URL urlprincipal = new URL("http://www.localhost:35000" + path);
            String pathForm = urlprincipal.getQuery();
                if (pathForm != null) {
                    if (Cache.containCache(pathForm)){
                        cacheData = Cache.getCache(pathForm);
                    } else {
                        cacheData = HttpConection.HttpConectionExample(pathForm);
                        Cache.saveCache(pathForm, cacheData);
                    }
                }

            System.out.println(cacheData);
            outputLine = "HTTP/1.1 200 OK\r\n"   + "\r\n" + htmlWithForms(cacheData); // jsonSimple

//            outputLine= jsonSimple(cacheData);
            out.println(outputLine);

            out.close();
            in.close();
            clientSocket.close();


        }
        serverSocket.close();

    }



    private static String get(String p) {
        return p;
    }

    // devolver JSON
    public static String jsonSimple(String cacheData){
        return "HTTP/1.1 200 OK\r\n"+ "Content-Type: text/json\r\n "  + cacheData;
    }


//    public static String htmlSimple(){
//        return "<!DOCTYPE html>"  + "<html>" + "<head>" + "<meta charset=\"UTF-8\">"
//                + "<title>Title of the document</title>\n"
//                + "</head>"
//                + "<body>"
//                + "My Web Site"
//                + "</body>" + "</html>";
//    }


    public static String htmlWithForms(String cacheData){

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Form Example</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body style=\"background-color:lightsteelblue;\">\n" +
                "        <h1>Consultar Peliculas </h1>\n" +
                "        <form action=\"localhost:35000\" onsubmit=\"return false\" >\n" +
                "            <label for=\"t\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"t\" name=\"t\" value=\"pelicula\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div  id=\"getrespmsg\"> " + cacheData + "</div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"t\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" + "console.log(this.responseText);" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/?t=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";

    }

}
