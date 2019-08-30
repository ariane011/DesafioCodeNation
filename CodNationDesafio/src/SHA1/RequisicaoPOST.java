package SHA1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RequisicaoPOST {
	
	public static String post(String json) throws IOException {

		URL url = new URL("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=6cd0100af830f8244ed55302a1950ab14354e5af");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-type", "application/json"); connection.setRequestProperty("Accept", "application/json");

		connection.setDoOutput(true);

		PrintStream printStream = new PrintStream(connection.getOutputStream()); printStream.println(json);

		connection.connect();

		String jsonDeResposta = new Scanner(connection.getInputStream()).next();

		return jsonDeResposta; 
		
	}
	
	public static void main(String[] args) throws IOException {
		post("{ \"numero_casas\":2, \"token\":\"6cd0100af830f8244ed55302a1950ab14354e5af\", \"cifrado\":\"rgqrng yknn tgcnkbg vjcv uqhvyctg ku pqv c rtqfwev; aqw wug kv vq dwknf c rtqfwev. nkpwu vqtxcnfu\", \"decifrado\":\"tistpi ampp viepmdi xlex wsjxaevi mw rsx e tvshygx; csy ywi mx xs fymph e tvshygx. pmryw xsvzephw\", \"resumo_criptografico\":\"997DBF7EBC77419A9F953C33CBEB49460D381486\" }\r\n" + 
				"");
	}
  
}
