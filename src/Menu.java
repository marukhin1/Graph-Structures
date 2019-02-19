import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException{
        App app = new App(new Graph());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sig = 0;
        String sw;
        System.out.println("\nДанная программа представляет консольную утилиту, позволяющую создавать графовые" +
                " структуры, добавлять узлы и связи.\nКаждый узел определяется именем и описанием, а каждая связь" +
                " именем узла источника, узла приемника и описанием отношения.\nПолученный граф можно вывести в консоль," +
                " в форматах матриц смежности и инцидентности.\nДоступные команды:\n1) Добавить узел\n2) Добавить" +
                " связь\n3) Построить и отобразить матрицу смежности\n4) Построить и отобразить матрицу инцидентности" +
                "\n0) Выйти из программы");
        while (sig ==0){
            System.out.println("\nВведите номер команды: ");
            sw = reader.readLine();
            switch (sw){
                case "1":
                    app.add_node();
                    break;
                case "2":
                    app.add_connection();
                    break;
                case "3":
                    app.build_and_show_adjacency_matrix();
                    break;
                case "4":
                    app.build_and_show_incidence_matrix();
                    break;
                case "0":
                    System.out.print("Выход...");
                    sig++;
                    break;
                default:
                    System.out.println("Неверный номер команды!");
                    break;
            }
        }
    }
}
