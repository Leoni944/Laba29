package ru.mirea.kabo0222;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите кол-во городов в стране: ");
            int N = scanner.nextInt();
            int[][] adjacencyMatrix = new int[N][N];

            RoadCounter roadCounter;

            System.out.println("Введите матрицу смежности городов: ");

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjacencyMatrix[i][j] = scanner.nextInt();
                }
            }
            roadCounter = new RoadCounter(N, adjacencyMatrix);
            System.out.println(roadCounter.getNumOfRoads());
        } catch (Exception e) {
            System.err.println("Ошибка ввода данных: " + e.getMessage());
        }

    }
}
