package codador;
public class Titulo {
	public String linguagem;
	public String titulo;
	
	//{ codigo: "1", titulo: [ { linguagem: "english", valor: "Sex, Drugs and Rock'n'Roll" }, { linguagem: "portugues", valor: "Sexo, Drogas e Rock'n'Roll" } ], publicacao: "2000-06-15", editora: "Editora Abril", autores: [ "José da Silva", "Maria Brasil" ], capa: { formato: "png", valor: "..." } }


	public String toXML() {
		return "<titulo linguagem=\"" + this.linguagem + "\">" + this.titulo + "</titulo>";
	}
	
	public String toJSON() {
		return "{linguagem:\"" + this.linguagem + "\",valor:\"" + this.titulo + "\"}";
	}

}
