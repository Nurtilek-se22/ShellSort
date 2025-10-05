package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;

import java.util.Arrays;

public class BenchmarkRunner {

    // Метод для запуска бенчмарков с различными размерами входных данных
    public static void runBenchmark(int[] sizes) {
        for (int size : sizes) {
            System.out.println("Running benchmark for size: " + size);

            // Генерация случайных данных для сортировки
            int[] arr = generateRandomArray(size);

            // Инициализация PerformanceTracker для сбора метрик
            PerformanceTracker tracker = new PerformanceTracker();

            // Запуск сортировки
            long startTime = System.nanoTime();
            ShellSort.shellSortShellSequence(arr, tracker);
            long endTime = System.nanoTime();

            // Измеряем время сортировки
            long duration = endTime - startTime;

            // Выводим результаты
            System.out.println("Size: " + size);
            System.out.println("Execution time: " + duration + " ns");
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Swaps: " + tracker.getSwaps());
            System.out.println("Array accesses: " + tracker.getArrayAccesses());
            System.out.println("-------------------------");
        }
    }

    // Генерация случайного массива указанного размера
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000); // Заполнение массива случайными числами
        }
        return arr;
    }

    // Метод для обработки аргументов командной строки и запуска бенчмарков
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input sizes provided. Using default sizes: 100, 1000, 10000");
            runBenchmark(new int[]{100, 1000, 10000});
        } else {
            int[] sizes = Arrays.stream(args)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            runBenchmark(sizes);
        }
    }
}