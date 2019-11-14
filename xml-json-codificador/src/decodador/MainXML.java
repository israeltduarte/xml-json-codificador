package decodador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Scanner;

public class MainXML {
	
	public static void main(String[] args) throws Exception {
		ArrayList<String> pilha = new ArrayList<String>();
		Scanner entrada = new Scanner(System.in);
		System.out.print("XML:");
//		String XML = entrada.nextLine();
		String XML = "<livro><codigo>10</codigo><titulo linguagem=\"linguagem1\">titulo1</titulo><titulo linguagem=\"linguagem2\">titulo2</titulo><publicacao>2019-08-09</publicacao><editora>editora1</editora><autores><autor>autor1</autor><autor>autor2</autor><autor>autor3</autor></autores><capa formato=\"jpg\">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</capa></livro>";
		
		System.out.print("MD5:");

		String hex = "";
		for (byte b: MessageDigest.getInstance("MD5").digest(XML.getBytes(StandardCharsets.UTF_8))) hex += String.format("%02X", b);
		
		if ("3AE984C0CB62C9768D3244A6F0FE84BB".equalsIgnoreCase(hex)) {
			while (XML.length() > 0) {
				int posicao = (XML.charAt(0) == '<') ? XML.indexOf(">") + 1 : XML.indexOf("<");
				String tmp1 = XML.substring(0, posicao);
				XML = XML.substring(posicao);
				if (tmp1.charAt(1) == '/') {
					String tmp2 = pilha.remove(pilha.size() - 1);
					if (tmp2.charAt(0) != '<') {
						tmp1 = pilha.remove(pilha.size() - 1);
						System.out.println(tmp1 + tmp2);
					}
				} else {
					pilha.add(tmp1);
				}
			}
		} else {
			System.out.println("Erro de MD5");
		}
	}

}
