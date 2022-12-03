import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição: Java para iniciantes");
        curso1.setCargaHoraria(100);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Descrição: Python para iniciantes");
        curso2.setCargaHoraria(120);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao(("Descrição: Descomplicando Java"));
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Mentoria Python");
        mentoria2.setDescricao(("Descrição: O que podemos fazer com Python"));
        mentoria2.setData(LocalDate.now());

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Java Beginners");
        bootcamp1.setDescricao("Descrição: Uma trilha com conteúdos completos, desafios de projetos, mentorias ao vivo e networking com a comunidade.");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(mentoria1);

        Bootcamp bootcamp2 = new Bootcamp();
        bootcamp2.setNome("Python Inittial");
        bootcamp2.setDescricao("Descrição: Aprenda Python rápido com conteúdos completos e mentorias ao vivo.");
        bootcamp2.getConteudos().add(curso2);
        bootcamp2.getConteudos().add(mentoria2);

        Dev dev1 = new Dev();
        dev1.setNome("Patrícia Souza");
        dev1.increverBootcamp(bootcamp1);
        System.out.println("Conteúdos Inscritos: " + dev1.getNome() + dev1.getConteudosInscritos());
        dev1.progresso();
        System.out.println("Conteúdos Concluídos: " + dev1.getNome() + dev1.getConteudosConcluidos());
        System.out.println("Total XP: " + dev1.getNome() + " " + dev1.calcularTotalXp());


        Dev dev2 = new Dev();
        dev2.setNome("Joaquim Silva");
        dev2.increverBootcamp(bootcamp2);
        System.out.println("Conteúdos Inscritos: " + dev2.getNome() + " " + dev2.getConteudosInscritos());
        dev2.progresso();
        dev2.progresso();
        System.out.println("Conteúdos Concluídos: " + dev2.getNome() + " " + dev2.getConteudosConcluidos());
        System.out.println("Total XP: " + dev2.getNome() + " " + dev2.calcularTotalXp());

        Dev dev3 = new Dev();
        dev3.setNome("Joana Lima");
        dev3.increverBootcamp(bootcamp1);
        System.out.println("Conteúdos Inscritos: " + dev3.getNome() + " " + dev3.getConteudosInscritos());
        dev3.progresso();
        dev3.progresso();
        dev3.progresso();
        System.out.println("Conteúdos Concluídos: " + dev3.getNome() + " " + dev3.getConteudosConcluidos());
        System.out.println("Total XP: " + dev3.getNome() + " " + dev3.calcularTotalXp());

    }
}