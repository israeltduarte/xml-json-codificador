package codador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String codigo;
	private List<Titulo> titulos = new ArrayList<Titulo>();
	private LocalDate publicacao;
	private String editora;
	private List<String> autores = new ArrayList<String>();
	private Capa capa;

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulos.add(titulo);
	}

	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public void setAutor(String autor) {
		this.autores.add(autor);
	}

	public void setCapa(Capa capa) {
		this.capa = capa;
	}

	public String toXML() {
		String retorno = "<livro><codigo>" + codigo + "</codigo>";
		for (Titulo titulo : this.titulos) {
			retorno += titulo.toXML();
		}
		retorno += "<publicacao>" + this.publicacao.toString() + "</publicacao><editora>" + this.editora
				+ "</editora><autores>";
		for (String autor : this.autores) {
			retorno += "<autor>" + autor + "</autor>";
		}
		retorno += "</autores>" + this.capa.toXML() + "</livro>";
		return (retorno);
	}
	
	public String toJSON() {
		String retorno = "{codigo:\"" + codigo + "\",titulo:[";
		for (Titulo titulo : this.titulos) {
			retorno += titulo.toJSON() + ",";
		}
		
		retorno = retorno.substring(0, retorno.length() - 1);
		
		retorno += "],publicacao:\"" + this.publicacao.toString() + "\",editora:\"" + this.editora + "\",autores:[";
		for (String autor : this.autores) {
			retorno += "\"" + autor + "\",";
		}
		
		retorno = retorno.substring(0, retorno.length() - 1);
		
		retorno += "]," + this.capa.toJSON() + "}";
		return (retorno);
	}

}
