package SHA1;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Cripto {

	public static void main(String[] argv) {

		String mensagem = "tistpi ampp viepmdi xlex wsjxaevi mw rsx e tvshygx; csy ywi mx xs fymph e tvshygx. pmryw xsvzephw";

		String sha1 = "";

		// Com a biblioteca JAVA
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(mensagem.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("O SHA1 da mensagem \"" + mensagem + "\" �:");
		System.out.println(sha1);
		System.out.println();

	}

}
