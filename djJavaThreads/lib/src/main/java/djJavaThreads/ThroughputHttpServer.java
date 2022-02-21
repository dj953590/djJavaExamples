/**
 * 
 */
package djJavaThreads;

import com.sun.net.httpserver.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author dj153
 * Through put server takes the request from the http client for the word search and searches
 * the word in the war and peace novel
 *
 */
public class ThroughputHttpServer {

    public static final String INPUT_FILE = "./resources/war_and_peace.txt";
    public static final int NUMBER_OF_THREADS=1; 
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	
	Path p = Paths.get(ThroughputHttpServer.INPUT_FILE);
	System.out.println ("Path to the file to read : " + p.toString());
	String text = new String(Files.readAllBytes(p));
	startServer(text);
	
    }
    
    private static void startServer(String text) throws IOException {
	HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
	server.createContext("/search", new WordCountHandler(text));
	Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
	server.setExecutor(executor);
	server.start();
    }

    private static class WordCountHandler implements HttpHandler {
	private String text;
	public WordCountHandler(String text) {
	    super();
	    this.text = text;
	}
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
	    
	    String query = httpExchange.getRequestURI().getQuery();
	    String[] keyValue = query.split("=");
            String action = keyValue[0];
            String word = keyValue[1];
            if (!action.equals("word")) {
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }

            long count = countWord(word);

            byte[] response = Long.toString(count).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWord(String word) {
            long count = 0;
            int index = 0;
            while (index >= 0) {
                index = text.indexOf(word, index);

                if (index >= 0) {
                    count++;
                    index++;
                }
            }
            return count;
	}
	
    }
}
