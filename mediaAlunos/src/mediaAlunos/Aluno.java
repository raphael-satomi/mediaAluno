package mediaAlunos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
	private String nome;
	private double media;

	List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void getMediaAluno() {
		double tempMedia = 0;
		for (Disciplina disciplina : disciplinas) {
			tempMedia += disciplina.getNota();

		}
		setMedia(tempMedia / disciplinas.size());

	}

	public String getStatusAluno() {
		if (this.media >= 6) {
			return StatusAluno.APROVADO;
			
		} else if (this.media >= 5 && this.media < 6) {
			return StatusAluno.RECUPERACAO;
			
		} else {
			return StatusAluno.REPROVADO;
			
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplinas, media, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(disciplinas, other.disciplinas)
				&& Double.doubleToLongBits(media) == Double.doubleToLongBits(other.media)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", media=" + media + ", disciplinas=" + disciplinas + "]";
	}

}
