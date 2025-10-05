package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShellSortTest {

    // Тестирование пустого массива
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker); // Применяем алгоритм сортировки
        assertArrayEquals(new int[]{}, arr); // Массив должен остаться пустым
    }

    // Тестирование массива с одним элементом
    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);
        assertArrayEquals(new int[]{5}, arr); // Массив с одним элементом не изменяется
    }

    // Тестирование массива с одинаковыми элементами
    @Test
    public void testArrayWithIdenticalElements() {
        int[] arr = {7, 7, 7, 7};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);
        assertArrayEquals(new int[]{7, 7, 7, 7}, arr); // Массив не должен измениться
    }

    // Тестирование уже отсортированного массива
    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr); // Массив уже отсортирован, не меняется
    }

    // Тестирование массива в обратном порядке
    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);  // Применяем алгоритм сортировки
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);  // Массив должен быть отсортирован
    }

    // Тестирование массива с повторяющимися элементами
    @Test
    public void testArrayWithDuplicateElements() {
        int[] arr = {4, 5, 4, 3, 5, 2};
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);  // Применяем алгоритм сортировки
        assertArrayEquals(new int[]{2, 3, 4, 4, 5, 5}, arr);  // Проверяем, что массив отсортирован
    }

    // Тестирование массива с большим количеством элементов
    @Test
    public void testLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 1000 - i;  // Массив в обратном порядке
        }
        PerformanceTracker tracker = new PerformanceTracker();
        ShellSort.shellSortShellSequence(arr, tracker);  // Применяем алгоритм сортировки

        // Проверяем, что массив отсортирован
        for (int i = 0; i < 999; i++) {
            assertTrue(arr[i] <= arr[i + 1]);  // Каждый следующий элемент не меньше предыдущего
        }
    }

}