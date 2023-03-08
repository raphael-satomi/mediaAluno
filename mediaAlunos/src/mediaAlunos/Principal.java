package mediaAlunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		int qtdAlunos = 0;
		try {
			qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos alunos deseja resgistrar?"));

		} catch (NumberFormatException e) {

		}

		int qtdDisciplinas = 0;
		try {
			qtdDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Quantas disciplinas possui?"));

		} catch (NumberFormatException e) {

		}

		List<String> disciplinas = new ArrayList<String>();
		for (int i = 0; i < qtdDisciplinas; i++) {
			String nome = JOptionPane.showInputDialog("Qual nome da Disciplina " + (i + 1) + " ?");
			disciplinas.add(nome);

		}

		List<Aluno> listaAlunos = new ArrayList<Aluno>();

		HashMap<String, List<Aluno>> listaStatusAlunos = new HashMap<String, List<Aluno>>();
		listaStatusAlunos.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		listaStatusAlunos.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		listaStatusAlunos.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

		for (int i = 0; i < qtdAlunos; i++) {
			Aluno aluno = new Aluno();

			String nome = JOptionPane.showInputDialog("Qual nome do aluno " + (i + 1) + " ?");
			aluno.setNome(nome);

			for (String disciplinaNome : disciplinas) {
				Disciplina disciplina = new Disciplina();
				double nota = Double.valueOf(JOptionPane.showInputDialog(
						"Qual a nota do aluno " + nome + " na disciplina de " + disciplinaNome + " ?"));
				disciplina.setNome(disciplinaNome);
				disciplina.setNota(nota);

				aluno.getDisciplinas().add(disciplina);

			}
			aluno.getMediaAluno();
			if (aluno.getStatusAluno().equalsIgnoreCase(StatusAluno.APROVADO)) {
				listaStatusAlunos.get(StatusAluno.APROVADO).add(aluno);

			} else if (aluno.getStatusAluno().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				listaStatusAlunos.get(StatusAluno.RECUPERACAO).add(aluno);

			} else if (aluno.getStatusAluno().equalsIgnoreCase(StatusAluno.REPROVADO)) {
				listaStatusAlunos.get(StatusAluno.REPROVADO).add(aluno);

			}

			listaAlunos.add(aluno);

		}
		System.out.println("----------------------");
		System.out.println("---- Lista Alunos ----");
		System.out.println("----------------------");
		for (Aluno aluno : listaAlunos) {
			System.out.println("Aluno: " + aluno.getNome() + " | Média geral: " + aluno.getMedia());
		}
		System.out.println("");

		for (String key : listaStatusAlunos.keySet() ) {
			if( listaStatusAlunos.get(key).size() > 0) {
				System.out.println("--------------------------");
				System.out.println("---- Alunos "+key+" ----");
				System.out.println("--------------------------");
				for (Aluno aluno : listaStatusAlunos.get(key)) {
					System.out.println("Aluno: " + aluno.getNome());
					
					for (Disciplina disciplina : aluno.getDisciplinas()) {
						System.out.println("Nota disciplina " + disciplina.getNome() + ": " + disciplina.getNota());
						
					}
					System.out.println("Média Geral: "+aluno.getMedia());
					System.out.println("");
				}
				
			}			
			
		}

	}

}
