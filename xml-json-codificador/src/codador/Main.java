package codador;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner entrada = new Scanner(System.in);
		Livro livro = new Livro();
		System.out.print("Codigo:");
		livro.setCodigo(entrada.nextLine());

		System.out.print("Quantidade de titulos:");
		int quantidade = entrada.nextInt();

		entrada.nextLine();
		for (int i = 0; i < quantidade; i++) {
			Titulo titulo = new Titulo();
			System.out.print("Linguagem:");
			titulo.linguagem = entrada.nextLine();
			System.out.print("Titulo:");
			titulo.titulo = entrada.nextLine();
			livro.setTitulo(titulo);
		}
		System.out.print("Publicacao:");
		livro.setPublicacao(LocalDate.parse(entrada.nextLine()));
		System.out.print("Editora:");
		livro.setEditora(entrada.nextLine());
		System.out.print("Quantidade de autores:");
		quantidade = entrada.nextInt();
		
		entrada.nextLine();
		for (int i = 0; i < quantidade; i++) {
			System.out.print("Nome:");
			livro.setAutor(entrada.nextLine());
		}
		
		Capa capa = new Capa();
		System.out.print("Formato:");
		capa.formato = entrada.nextLine();
		System.out.print("Imagem:");
		capa.setImagem(entrada.nextLine());
		livro.setCapa(capa);
		
		String XML = livro.toXML();
		String JSON = livro.toJSON();
		
		System.out.println(XML);
		System.out.println(JSON);
		
		String hexXML = "";
		for (byte b: MessageDigest.getInstance("MD5").digest(XML.getBytes(StandardCharsets.UTF_8))) hexXML += String.format("%02X", b);
		
		String hexJSON = "";
		for (byte b: MessageDigest.getInstance("MD5").digest(JSON.getBytes(StandardCharsets.UTF_8))) hexJSON += String.format("%02X", b);
		
		System.out.println("hex xml: "+hexXML);
		System.out.println("hex json: "+hexJSON);
	}

}
