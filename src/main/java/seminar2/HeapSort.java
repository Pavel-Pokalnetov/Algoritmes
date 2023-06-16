package seminar2;

public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heap_rebuilding(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            heap_rebuilding(array, i, 0);
        }
    }

    // Перестроение кучи
    private static void heap_rebuilding(int[] arr, int n, int i) {
        int root_element = i; //корень
        int left_element = 2 * i + 1; //левый элемент
        int right_element = 2 * i + 2; //правый элемент

        if (left_element < n && arr[left_element] > arr[root_element]) root_element = left_element;

        if (right_element < n && arr[right_element] > arr[root_element]) root_element = right_element;

        if (root_element != i) {
            int swap = arr[i];
            arr[i] = arr[root_element];
            arr[root_element] = swap;

            // Рекурсивно перестраиваем кучу
            heap_rebuilding(arr, n, root_element);
        }
    }
}