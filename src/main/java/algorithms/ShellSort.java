package algorithms;

import metrics.PerformanceTracker;

import java.util.List;

public class ShellSort {

    // Реализация сортировки с последовательностью Shell с отслеживанием метрик
    public static void shellSortShellSequence(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                tracker.incrementArrayAccesses();  // Доступ к элементу arr[i]
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    tracker.incrementComparisons();  // Сравнение
                    tracker.incrementArrayAccesses();  // Доступ к arr[j - gap]
                    tracker.incrementSwaps();  // Обмен
                }
                arr[j] = temp;
                tracker.incrementSwaps();  // Обмен с arr[j]
                tracker.incrementArrayAccesses();  // Доступ к arr[j]
            }
        }
    }

    // Реализация сортировки с последовательностью Knuth с отслеживанием метрик
    public static void shellSortKnuthSequence(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        int[] gaps = generateKnuthSequence(n);
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                tracker.incrementArrayAccesses();  // Доступ к элементу arr[i]
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    tracker.incrementComparisons();  // Сравнение
                    tracker.incrementArrayAccesses();  // Доступ к arr[j - gap]
                    tracker.incrementSwaps();  // Обмен
                }
                arr[j] = temp;
                tracker.incrementSwaps();  // Обмен с arr[j]
                tracker.incrementArrayAccesses();  // Доступ к arr[j]
            }
        }
    }

    // Реализация сортировки с последовательностью Sedgewick с отслеживанием метрик
    public static void shellSortSedgewickSequence(int[] arr, PerformanceTracker tracker) {
        int n = arr.length;
        int[] gaps = generateSedgewickSequence(n);
        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                tracker.incrementArrayAccesses();  // Доступ к элементу arr[i]
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    tracker.incrementComparisons();  // Сравнение
                    tracker.incrementArrayAccesses();  // Доступ к arr[j - gap]
                    tracker.incrementSwaps();  // Обмен
                }
                arr[j] = temp;
                tracker.incrementSwaps();  // Обмен с arr[j]
                tracker.incrementArrayAccesses();  // Доступ к arr[j]
            }
        }
    }

    // Генерация последовательности Knuth
    private static int[] generateKnuthSequence(int n) {
        int k = 0;
        while (Math.pow(3, k) - 1 / 2 <= n) {
            k++;
        }

        int[] gaps = new int[k];
        for (int i = 0; i < k; i++) {
            gaps[i] = (int)(Math.pow(3, i) - 1) / 2;
        }
        return gaps;
    }

    // Генерация последовательности Sedgewick
    private static int[] generateSedgewickSequence(int n) {
        int k = 0;
        while (9 * Math.pow(4, k) - 9 * Math.pow(2, k) + 1 <= n) {
            k++;
        }

        int[] gaps = new int[k];
        for (int i = 0; i < k; i++) {
            gaps[i] = (int) (9 * Math.pow(4, i) - 9 * Math.pow(2, i) + 1);
        }
        return gaps;
    }

    // Метод для вывода массива
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 54, 2, 3 };

        // Инициализация PerformanceTracker
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.println("Original array: ");
        printArray(arr);

        // Запуск сортировки с последовательностью Shell и запись метрик в CSV
        shellSortShellSequence(arr, tracker);
        tracker.exportToCSV("performance_results.csv", List.of("comparisons", "swaps", "array_accesses", "memory_allocations"));

        System.out.println("Sorted array (Shell Sequence): ");
        printArray(arr);
    }

    public static void shellSort(int[] arr) {
    }


    public static void sort(int[] arr, String gapType, PerformanceTracker tracker) {
    }
}