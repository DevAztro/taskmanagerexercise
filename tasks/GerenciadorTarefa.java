import java.util.List;
import java.util.ArrayList;

public class GerenciadorTarefa {
    private final List<Tarefa> tarefas;
    public GerenciadorTarefa() {

        tarefas = new ArrayList<>();
    }
    public void addTarefa (Tarefa tarefa) {

        tarefas.add(tarefa);
    }
    public List<Tarefa> getTarefas() {

        return tarefas;
    }
    public void marcarTarefaComoConcluida (int marcador) {

        tarefas.get(marcador).markAsCompletada();
    }
    public void removerTarefa (int marcador) {

        tarefas.remove(marcador);
    }
}
