package ru.mirea.kabo0222;
public class RoadCounter {
    private final int numOfCities;
    private final int[][] adjacencyMatrix;
    private final int numOfRoads;

    public RoadCounter(int numOfCities, int[][] adjacencyMatrix) {
        this.numOfCities = numOfCities;
        this.adjacencyMatrix = adjacencyMatrix;

        checkValidData();
        this.numOfRoads = countTheRoads();
    }

    private void checkValidData() {
        if (numOfCities <= 0) {
            throw new IllegalArgumentException("Количество городов должно быть положительным числом.");
        }

        if (adjacencyMatrix.length != numOfCities || adjacencyMatrix[0].length != numOfCities) {
            throw new IllegalArgumentException("Размерность матрицы смежности не соответствует количеству городов.");
        }

        for (int i = 0; i < numOfCities; i++) {
            for (int j = i; j < numOfCities; j++) {
                if ((adjacencyMatrix[i][j] != adjacencyMatrix[j][i]) ||
                        (i == j && adjacencyMatrix[i][j] != 0)) {
                    throw new IllegalArgumentException("Матрица смежности некорректна!");
                }
            }
        }
    }

    private int countTheRoads() {
        int cnt = 0;
        for (int i = 0; i < numOfCities; i++) {
            for (int j = i; j < numOfCities; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    cnt += adjacencyMatrix[i][j];
                }
            }
        }
        return cnt;
    }

    public int getNumOfCities() {
        return numOfCities;
    }

    public int getNumOfRoads() {
        return numOfRoads;
    }
}