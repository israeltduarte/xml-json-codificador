package codador;
import java.io.RandomAccessFile;
import java.util.Base64;

public class Capa {
	public String formato;
	public String imagem;

	public void setImagem(String imagem) throws Exception {
		RandomAccessFile arquivo = new RandomAccessFile(imagem, "r");
		byte conteudo[] = new byte[(int) arquivo.length()];
		arquivo.read(conteudo);
		arquivo.close();
		this.imagem = new String(Base64.getEncoder().encode(conteudo));
	}

	public String toXML() {
		return "<capa formato=\"" + this.formato + "\">" + this.imagem + "</capa>";
	}
	
	public String toJSON() {
		return "capa:{formato:\"" + this.formato + "\",valor:\"" + this.imagem + "\"}";
	}

}
