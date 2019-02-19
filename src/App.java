import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private Graph graph;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public App(Graph graph){
        this.graph = graph;
    }

    public void add_node() throws IOException{
        System.out.print("Введите имя: ");
        String name = reader.readLine();
        int sig1 = 0;
        int sig2 = 0;
        while(sig1 == 0){
            for (int i = 0; i < graph.getNodeArrayList().size(); i++){
                if ((name.equals(graph.getNodeArrayList().get(i).getName()) == true)){
                    sig2++;
                }
            }
            if (sig2 == 0){
                sig1 = 1;
                sig2 = 0;
            }
            else{
                System.out.print("Ошибка (Узел с таким именем уже существует)! Попробуйте снова!\nВведите имя: ");
                name = reader.readLine();
                sig2 = 0;
            }
        }
        System.out.print("Введите описание: ");
        String description = reader.readLine();
        graph.addNode(name,description);
    }

    public void add_connection() throws IOException{
        System.out.print("Доступные узлы: ");
        graph.printNodeArrayList();
        System.out.print("\nВведите номер узла источника: ");
        String source = reader.readLine();
        while ((Integer.parseInt(source) < 0) || (Integer.parseInt(source) >= graph.getNodeArrayList().size())){
            System.out.print("Ошибка (Неверный номер узла источника)! Попробуйте снова!\nВведите номер узла источника: ");
            source = reader.readLine();
        }
        System.out.print("Введите номер узла приемника: ");
        String receiver = reader.readLine();
        while ((Integer.parseInt(receiver) < 0) || (Integer.parseInt(receiver) >= graph.getNodeArrayList().size())){
            System.out.print("Ошибка (Неверный номер узла приемника)! Попробуйте снова!\nВведите номер узла приемника: ");
            receiver = reader.readLine();
        }
        System.out.print("Введите тип связи (OS - Односторонняя; DS - Двухсторонняя):");
        String attitude = reader.readLine();
        while ((attitude.equals("OS") == false) && (attitude.equals("DS") == false)){
            System.out.print("Ошибка (Неверный тип связи)! Попробуйте снова!\nВведите тип связи (OS - Односторонняя; DS - двухсторонняя): ");
            attitude = reader.readLine();
        }
        graph.addConnection(graph.getNodeArrayList().get(Integer.parseInt(source)),
                graph.getNodeArrayList().get(Integer.parseInt(receiver)),attitude);
    }

    public void build_and_show_adjacency_matrix(){
        graph.buildAM();
        System.out.print("Матрица смежности:");
        graph.showAM();
    }

    public void build_and_show_incidence_matrix(){
        graph.buildIM();
        System.out.print("Матрица инцидентности:");
        graph.showIM();
    }
}
