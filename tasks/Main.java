import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int escolha;

        GerenciadorTarefa gerenciadorTarefa = new GerenciadorTarefa();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\n******* GERENCIADOR DE TAREFAS *******");
            System.out.print("\n\n1 - Adicionar Tarefa");
            System.out.print("\n2 - Ver tarefas");
            System.out.print("\n3 - Marcar tarefa como concluída");
            System.out.print("\n4 - Remover Tarefa");
            System.out.print("\n0 - Sair");
            System.out.print("\n\nEscolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("\nDigite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    System.out.print("\nDigite o horário para sua tarefa (Formato HH:mm): ");
                    String horario = scanner.nextLine();
                    SimpleDateFormat data = new SimpleDateFormat("HH:mm");
                    Date dataTarefa;
                    try {
                        dataTarefa = data.parse(horario);
                    } catch (ParseException e) {
                        System.out.print("\nFormato de Horário inválido.  Use o fomato HH:mm.");
                        continue;
                    }
                    Tarefa tarefa = new Tarefa(descricao, dataTarefa);
                    gerenciadorTarefa.addTarefa(tarefa);
                    System.out.print("\nTarefa adicionada com sucesso!");
                    break;
                case 2:
                    List<Tarefa> tarefas = gerenciadorTarefa.getTarefas();
                    SimpleDateFormat verHorario = new SimpleDateFormat("HH:mm");
                    for (int i = 0; i < tarefas.size(); i++) {
                        Tarefa t = tarefas.get(i);
                        System.out.print("\nLista de tarefas: ");
                        System.out.print(i + 1 + ". " + t.getDescricao() + " - Horário: " + verHorario.format(t.getDataTarefa()) + " - Concluída: " + t.isCompletada());
                    }
                case 3:
                    System.out.print("\nDigite o número da tarefa que você quer marcar como concluída: ");
                    int marcadorCompleta = scanner.nextInt() - 1;
                    gerenciadorTarefa.marcarTarefaComoConcluida(marcadorCompleta);
                    System.out.print("\nTarefa marcada como concluída");
                    break;
                case 4:
                    System.out.print("\nDigite o número da tarefa que deseja remover: ");
                    int removedorTarefa = scanner.nextInt();
                    gerenciadorTarefa.removerTarefa(removedorTarefa);
                    System.out.print("\nTarefa Removida");
                    break;
                case 0:
                    System.out.print("\nSaindo do programa, até mais!");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\nOpção inválida, digite um número válido");
            }
        }
    }
}
