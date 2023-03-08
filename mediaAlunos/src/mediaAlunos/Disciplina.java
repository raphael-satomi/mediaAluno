package mediaAlunos;

import java.util.Objects;

public class Disciplina {
	private double nota;
	private String nome;
	
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nome, other.nome) && Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}
	
	
	@Override
	public String toString() {
		return "Disciplina [nota=" + nota + ", nome=" + nome + "]";
	}
	
}
