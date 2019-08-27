package SHA1;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RequisicaoPOST {
	
	public static void main(String[] args) throws IOException {
        postUser();
    }

    public static void postUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=6cd0100af830f8244ed55302a1950ab14354e5af");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "multipart/form-data");
            String json = "{\r\n" +
                    "  \"numero_casas\": \"2\",\r\n" +
                    "  \"token\": \"6cd0100af830f8244ed55302a1950ab14354e5af\",\r\n" +
                    "  \"cifrado\": \"rgqrng yknn tgcnkbg vjcv uqhvyctg ku pqv c rtqfwev; aqw wug kv vq dwknf c rtqfwev. nkpwu vqtxcnfu\",\r\n" +
                    "  \"decifrado\": \"tistpi ampp viepmdi xlex wsjxaevi mw rsx e tvshygx; csy ywi mx xs fymph e tvshygx. pmryw xsvzephw\",\r\n" +
                    "  \"resumo_criptografico\": \"997DBF7EBC77419A9F953C33CBEB49460D381486\",\r\n" +
                   "}";
                        
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler < String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
  
}
