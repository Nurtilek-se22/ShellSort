package metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long memoryAllocations = 0;

    // Увеличиваем количество сравнений
    public void incrementComparisons() {
        comparisons++;
    }

    // Увеличиваем количество обменов
    public void incrementSwaps() {
        swaps++;
    }

    // Увеличиваем количество доступов к массиву
    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    // Увеличиваем количество выделений памяти (если нужно)
    public void incrementMemoryAllocations() {
        memoryAllocations++;
    }

    // Записываем данные в CSV файл
    public void exportToCSV(String fileName, List<String> headers) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            if (headers != null) {
                writer.append(String.join(",", headers));
                writer.append("\n");
            }
            writer.append(String.format("%d,%d,%d,%d,%d\n", comparisons, swaps, arrayAccesses, memoryAllocations, System.nanoTime()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Геттеры для метрик
    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public long getMemoryAllocations() {
        return memoryAllocations;
    }

    public Object getAccesses() {
        return null;
    }
}