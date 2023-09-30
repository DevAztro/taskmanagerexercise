import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarefa {
    private final String descricao;
    private boolean completada;
    private final Date dataTarefa;

    public Tarefa (String descricao, Date dataTarefa) {
        this.descricao = descricao;
        this.dataTarefa = dataTarefa;
        this.completada = false;
    }
    public String getDescricao () {
        return descricao;
    }
    public boolean isCompletada() {
        return completada;
    }
    public void markAsCompletada() {
        completada = true;
    }
    public Date getDataTarefa() {
        return dataTarefa;
    }
}
