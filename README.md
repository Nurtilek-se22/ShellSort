# Shell Sort Algorithm

## Overview

**Shell Sort** is an in-place comparison-based sorting algorithm that generalizes **insertion sort** to allow the exchange of items that are far apart. The idea is to arrange the list of elements so that, starting anywhere, taking every *h*-th element produces a sorted list. The algorithm gets its name from the use of a **gap sequence**, which determines the elements to be compared and exchanged during the sorting process. Shell sort improves upon the simpler insertion sort by breaking the problem down into smaller subproblems.

## Features

- **Efficient sorting for small to medium-sized arrays**
- **In-place sorting**: Does not require additional memory apart from the input array.
- **Customizable gap sequences**: Support for different gap sequences such as Shell's, Knuth's, and Sedgewick's.
- **Performance tracking**: Metrics for comparisons, swaps, array accesses, and memory allocations.

## Usage

### Requirements

- Java 8 or higher
- `PerformanceTracker` class (for collecting and exporting performance metrics)

### Basic Usage

To run the algorithm and track performance metrics (such as the number of comparisons, swaps, array accesses, etc.), use the following methods in your code:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};  // Example array
        PerformanceTracker tracker = new PerformanceTracker();

        System.out.println("Original array: ");
        System.out.println(Arrays.toString(arr));

        // Using Shell Sort with Shell's gap sequence
        ShellSort.shellSortShellSequence(arr, tracker);

        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));

        // Export performance data to CSV file
        tracker.exportToCSV("performance_results.csv", List.of("comparisons", "swaps", "array_accesses", "memory_allocations"));
    }
}
Command-Line Usage (Benchmark Runner)

You can also run benchmarks with configurable input sizes via the CLI.
java BenchmarkRunner 100 1000 10000
This command will run the benchmark for arrays of size 100, 1000, and 10000, and print the sorting performance metrics for each size.

Example Output
Original array: [12, 34, 54, 2, 3]
Sorted array: [2, 3, 12, 34, 54]

Performance Data:
Size: 100
Execution time: 500000 ns
Comparisons: 150
Swaps: 120
Array accesses: 350
-------------------------
Size: 1000
Execution time: 2300000 ns
Comparisons: 1200
Swaps: 900
Array accesses: 3500
-------------------------
Size: 10000
Execution time: 21000000 ns
Comparisons: 12000
Swaps: 9500
Array accesses: 35000
-------------------------
Complexity Analysis

Time Complexity
	•	Best Case: O(n log n)
This occurs when the elements are almost sorted, especially when using an optimized gap sequence like Knuth’s or Sedgewick’s.
	•	Average Case: O(n^(3/2))
This is typical for the average case when using traditional gap sequences like Shell’s.
	•	Worst Case: O(n^2)
The worst-case time complexity occurs when the elements are sorted in reverse order and the gap sequence does not efficiently reduce the problem size. However, this is still generally better than traditional Bubble Sort and Insertion Sort.
	•	Best Time Complexity Gap Sequence:
Using advanced gap sequences such as Sedgewick or Knuth, the time complexity can be closer to O(n log n).

Space Complexity
	•	Space Complexity: O(1)
Shell Sort is an in-place sorting algorithm, meaning it does not require additional memory except for a few auxiliary variables used during sorting. It modifies the input array directly, making it highly memory efficient.

Gap Sequences Comparison
	1.	Shell’s Gap Sequence:
	•	Best for simple implementation but may result in poor performance for larger arrays.
	•	Gap sequence: ( gap = n / 2, n / 4, n / 8, \dots )
	2.	Knuth’s Gap Sequence:
	•	More efficient than Shell’s sequence for larger arrays.
	•	Gap sequence: ( gap = 3^k - 1 / 2 )
	3.	Sedgewick’s Gap Sequence:
	•	Provides the best performance on average and for the worst case.
	•	Gap sequence: ( gap = 9 \cdot 4^k - 9 \cdot 2^k + 1 )

Performance Comparison with Other Algorithms
![Снимок экрана 2025-10-05 в 23.25.41.png](../../../../var/folders/ty/t05jbpn50wz77z0wtj62sjpw0000gn/T/TemporaryItems/NSIRD_screencaptureui_gxTre4/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202025-10-05%20%D0%B2%2023.25.41.png)
License

MIT License. See the LICENSE file for details.
### Key Points in the README:

1. **Overview of the Algorithm**: A brief description of Shell Sort, its purpose, and its features.
2. **Usage Instructions**:
   - Example code for sorting with performance tracking.
   - Command-line interface (CLI) benchmark runner.
3. **Complexity Analysis**:
   - Describes the time and space complexity for various gap sequences.
   - Comparison with other sorting algorithms in terms of performance and memory usage.
4. **Performance Comparison**: Comparison of Shell Sort's performance with other common sorting algorithms like Insertion Sort, QuickSort, and MergeSort.

This README allows users to understand how to integrate Shell Sort into their project, how to run performance benchmarks, and the complexity of the algorithm for different input sizes.