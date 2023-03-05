package HomeWork;

public class hw_2 {

    public static void main(String args[]) {
        int[] sortPyr = {12, 6, 4, 1, 15, 10, 3, 48};
        heapSort(sortPyr);
        for(int i = 0; i < sortPyr.length; i++){
            System.out.print(sortPyr[i] + "\n");
        }
    }

    private static int left(int i) {
        return (2 * i + 1);
    }
    private static int rignt(int i) {
        return (2 * i + 2);
    }
    private static void swap(int[] sortPyr, int i, int j) {
        int swap = sortPyr[i];
        sortPyr[i] = sortPyr[j];
        sortPyr[j] = swap;
    }
    private static void heapify(int[] sortPyr, int i, int size) {
        int left = left(i);
        int right = rignt(i);
        int largest = i;
        if (left < size && sortPyr[left] > sortPyr[i]) largest = left;
        if (right < size && sortPyr[right] > sortPyr[largest]) largest = right;
        if (largest != i) {
            swap(sortPyr, i, largest);
            heapify(sortPyr, largest, size);
        }
    }
    public static int pop(int[] sortPyr, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = sortPyr[0];
        sortPyr[0] = sortPyr[size-1];
        heapify(sortPyr, 0, size - 1);
        return top;
    }
    public static void heapSort(int[] sortPyr) {

        int n = sortPyr.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortPyr, i--, n);
        }
        while (n > 0) {
            sortPyr[n - 1] = pop(sortPyr, n);
            n--;
        }
    }
}
