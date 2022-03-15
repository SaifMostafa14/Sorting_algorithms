import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * MERGE SORTING USING LINKED LIST
 */
class Lnode {

    int data;
    Lnode next;

    Lnode(int data, Lnode next) {
        this.data = data;
        this.next = next;
    }
}

public class Main {

    public long[] arr_10 = new long[10];
    public long[] arr_100 = new long[10];
    public long[] arr_1000 = new long[10];

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++used for printing numay of
     * integers +++++++++++++++++++++++++++++
     *
     * @param num
     */
    public static void printArray(int[] num) {

        System.out.print("[");
        for (int x = 0; x < num.length; x++) {

            System.out.print(" " + num[x]);
        }
        System.out.print(" ]");
        System.out.println();

    }

    public static void printLongArray(long[] num) {

        System.out.print("[");
        for (int x = 0; x < num.length; x++) {

            System.out.print(" " + num[x]);
        }
        System.out.print(" ]");
        System.out.println();

    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++used for printing linked list
     * +++++++++++++++++++++++++++++
     *
     * @param head
     */
    public static void printList(Lnode head) {
        Lnode list = head;

        System.out.print("[");
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }

        System.out.print("]");
        System.out.println();
    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++ ExchangeSort
     * +++++++++++++++++++++++++++++
     *
     * @param num
     * @param n
     */
    public static void ExchangeSort(int[] num, int n) {
        int i, j, t;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (num[i] > num[j]) //sorting into descending order
                {
                    t = num[i];   //exchange
                    num[i] = num[j];
                    num[j] = t;
                }
            }
        }

    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++ insertSorting(int[] num, int
     * n) +++++++++++++++++++++++++++++
     *
     * @param num
     * @param n
     */
    public static void insertSorting(int[] num, int n) {

        for (int i = 1; i < n; ++i) {
            int value = num[i];
            int j = i - 1;

            while (j >= 0 && num[j] > value) {
                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = value;
        }

    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++ BinaryInsertionSort(int[]
     * num) +++++++++++++++++++++++++++++
     *
     * @param num
     */
    public static void BinaryInsertionSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int x = num[i];

            int j = Math.abs(Arrays.binarySearch(num, 0, i, x) + 1);

            System.arraycopy(num, j, num, j + 1, i - j);

            num[j] = x;
        }
    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++ selectionSort
     * +++++++++++++++++++++++++++++
     *
     * @param num
     */
    public static void selectionSort(int[] num) {
        int n = num.length;

        for (int i = 0; i < n - 1; i++) {

            int minV = i;
            for (int j = i + 1; j < n; j++) {
                if (num[j] < num[minV]) {
                    minV = j;
                }
            }

            int temp = num[minV];
            num[minV] = num[i];
            num[i] = temp;
        }
    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++ mergeSortHelper2
     * +++++++++++++++++++++++++++++
     *
     * @param num
     * @param l
     * @param m
     * @param r
     */
    public static void mergeSortHelper2(int[] num, int l, int m, int r) {
        // Find sizes of two subnumays to be merged
        int len1 = m - l + 1;
        int len2 = r - m;

        int[] tmp_lf = new int[len1];
        int[] tmp_rf = new int[len2];

        /*Copy numays*/
        for (int i = 0; i < len1; ++i) {
            tmp_lf[i] = num[l + i];
        }
        for (int j = 0; j < len2; ++j) {
            tmp_rf[j] = num[m + 1 + j];
        }

        /* Merge the temp numays */
        // Initial indexes of first and second subnumays
        int i = 0, j = 0;

        int k = l;
        while (i < len1 && j < len2) {
            if (tmp_lf[i] <= tmp_rf[j]) {
                num[k] = tmp_lf[i];
                i++;
            } else {
                num[k] = tmp_rf[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            num[k] = tmp_lf[i];
            i++;
            k++;
        }

        while (j < len2) {
            num[k] = tmp_rf[j];
            j++;
            k++;
        }
    }

    public static void mergeSort2(int num[], int low, int high) {
        if (low < high) {
            // Find the middle point
            int m = low + (high - low) / 2;

            // Sort first and second halves
            mergeSort2(num, low, m);
            mergeSort2(num, m + 1, high);

            // Merge the sorted halves
            mergeSortHelper2(num, low, m, high);
        }
    }

    /**
     * merge sorting using Linked List start here
     * ++++++++++++++++++++++++++++++++++++++++++++ sortedMerge
     * +++++++++++++++++++++++++++++
     *
     * @param a
     * @param b
     * @return
     */
    public static Lnode sortedMerge(Lnode a, Lnode b) {
        // base cases
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        Lnode result;

        // pick either `a` or `b`, and recur
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    /**
     * mergeWithLinkedListHelper ++++++++++++++++++++++++++++++++++++++++++++
     * Merge sort Using Linked List +++++++++++++++++++++++++++++
     *
     * @param list
     * @return
     */
    public static Lnode[] mergeWithLinkedListHelper(Lnode list) {

        if (list == null || list.next == null) {
            return new Lnode[]{list, null};
        }

        Lnode s = list;
        Lnode f = list.next;

        // advance `fast` two nodes, and advance `slow` one node
        while (f != null) {
            f = f.next;
            if (f != null) {
                s = s.next;
                f = f.next;
            }
        }

        Lnode[] num = new Lnode[]{list, s.next};
        s.next = null;

        return num;
    }

    /**
     * mergesort
     *
     * @param head
     * @return
     */
    public static Lnode mergesort(Lnode head) {

        if (head == null || head.next == null) {
            return head;
        }

        Lnode[] num = mergeWithLinkedListHelper(head);
        Lnode f = num[0];
        Lnode b = num[1];

        f = mergesort(f);
        b = mergesort(b);

        return sortedMerge(f, b);
    }

    //END OF MERGE SORT USING LINKED LIST
    /**
     * HEAP SORT FUNCTIONS START HERE
     * ++++++++++++++++++++++++++++++++++++++++++++ HEAP SORT FUNCTIONS START
     * HERE +++++++++++++++++++++++++++++
     *
     * @param num
     */
    public static void heapSorting(int[] num) {
        int n = num.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            makeHeap(num, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int t = num[0];
            num[0] = num[i];
            num[i] = t;

            makeHeap(num, i, 0);
        }
    }

    /**
     *
     * @param num
     * @param n
     * @param i
     */
    static void makeHeap(int[] num, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int rt = 2 * i + 2;

        // If left child is larger than root
        if (left < n && num[left] > num[max]) {
            max = left;
        }

        // If right child is larger than max so far
        if (rt < n && num[rt] > num[max]) {
            max = rt;
        }

        if (max != i) {
            int swap = num[i];
            num[i] = num[max];
            num[max] = swap;

            makeHeap(num, n, max);
        }
    }

    /**
     * GET MAX NUMBER ++++++++++++++++++++++++++++++++++++++++++++ radixSortING
     * +++++++++++++++++++++++++++++
     *
     * @param num
     * @param n
     * @return
     */
    static int findMax(int[] num, int n) {
        int max = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }
        return max;
    }

    /**
     *
     * @param num
     * @param n
     * @param exp
     */
    static void getLen(int num[], int n, int exp) {
        int result[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(num[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            result[count[(num[i] / exp) % 10] - 1] = num[i];
            count[(num[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            num[i] = result[i];
        }
    }

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++ QUICK SORT METHOD WITH
     * PARTITIONS ++++++++++++++++++++++++++++++++
     *
     * @param num
     * @param i
     * @param j
     */
    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static int partition(int[] num, int low, int high) {

        int pivot = num[high];

        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (num[j] < pivot) {

                i++;
                swap(num, i, j);
            }
        }
        swap(num, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] num, int low, int high) {
        if (low < high) {

            int p = partition(num, low, high);

            quickSort(num, low, p - 1);
            quickSort(num, p + 1, high);
        }
    }

    /**
     *
     * @param num
     * @param n
     */
    static void radixSortING(int num[], int n) {

        int max = findMax(num, n);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            getLen(num, n, exp);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();
        int min = 1;
        int max = 1000;

        Lnode lnode = null;
        Lnode lnode2 = null;

        int arr_size = 10;
        int num_times_running = 100;
        while (arr_size > 0) {

            System.out.print("Enter arr size : ");
            arr_size = sc.nextInt();

            //ARRAYS OF SIZE 10
            int[] arr = new int[arr_size];
            for (int i = 0; i < arr_size; i++) {
                int n = rand.nextInt((max - min) + 1) + min;
                arr[i] = n;
            }

            /*Applying the sorting algorithms on the array and checking before and after
            System.out.println("___Before");
            printArray(arr);
            //ExchangeSort(arr, arr.length);
            //insertSorting(arr, arr.length);
            BinaryInsertionSort(arr);
            //selectionSort(arr);
            //mergeSort2(arr, 0, arr_size-1);
            //mergeSort2(arr, 0, arr_size-1);
            //quickSort(arr, 0, arr.length-1);
            //heapSorting(arr);
            //radixSortING(arr, arr.length);
            System.out.println("___After sorting");
            printArray(arr);
            */

            /* Calculating the time
            //get average for runnign 100 times
            long total = 0;
            long total1 = 0;
            long total2 = 0;
            long total3 = 0;
            long total4 = 0;
            long total5 = 0;
            long total6 = 0;
            long total7 = 0;
            long total8 = 0;
            long total9 = 0;

            for (int x = 0; x < num_times_running; x++) {

                //create the array
                for (int i = 0; i < arr_size; i++) {
                    int n = rand.nextInt((max - min) + 1) + min;
                    arr[i] = n;
                }

                //System.out.println("___Before");
                //printArray(arr);

                //ExchangeSort
                long begin = System.nanoTime(); //start timer

                ExchangeSort(arr,arr.length);

                long end = System.nanoTime();

                long tt = end - begin;
                total += tt;

                // insertSorting
                long begin1 = System.nanoTime(); //start timer

                insertSorting(arr,arr.length);

                long end1 = System.nanoTime();

                long tt1 = end1 - begin1;
                total1 += tt1;

                //BinaryInsertionSort
                long begin2 = System.nanoTime(); //start timer

                BinaryInsertionSort(arr);

                long end2 = System.nanoTime();

                long tt2 = end2 - begin2;
                total2 += tt2;

                //selectionSort
                long begin3 = System.nanoTime(); //start timer

                selectionSort(arr);

                long end3 = System.nanoTime();

                long tt3 = end3 - begin3;
                total3 += tt3;

                //mergeSort2
                long begin4 = System.nanoTime(); //start timer

                mergeSort2(arr, 1, arr_size-1);

                long end4 = System.nanoTime();

                long tt4 = end4 - begin4;
                total4 += tt4;

                //mergesort
                long begin5 = System.nanoTime(); //start timer

                mergesort(lnode);

                long end5 = System.nanoTime();

                long tt5 = end5 - begin5;
                total5 += tt5;

                //quickSort
                long begin6 = System.nanoTime(); //start timer

                quickSort(arr, 1, arr_size-1);


                long end6 = System.nanoTime();

                long tt6 = end6 - begin6;
                total6 += tt6;


                //heapSorting
                long begin7 = System.nanoTime(); //start timer

                heapSorting(arr);

                long end7 = System.nanoTime();

                long tt7 = end7 - begin7;
                total7 += tt7;

                //radixSortING
                long begin8 = System.nanoTime(); //start timer

                radixSortING(arr, arr.length);

                long end8 = System.nanoTime();

                long tt8 = end8 - begin8;
                total8 += tt8;

                //System.out.println("___After");
                //printArray(arr);
            }


            System.out.println("ExchangeSort:           Total "+total+ " Average " + total / num_times_running);
            System.out.println("InsertionSort:          Total "+total1+ " Average " + total1 / num_times_running);
            System.out.println("BinaryInsertionSort:    Total "+total2+ " Average " + total2 / num_times_running);
            System.out.println("selectionSort:          Total "+total3+ " Average " + total3 / num_times_running);
            System.out.println("mergeSort2:             Total "+total4+ " Average " + total4 / num_times_running);
            System.out.println("mergesort:              Total "+total5+ " Average " + total5 / num_times_running);
            System.out.println("quickSort:              Total "+total6+ " Average " + total6 / num_times_running);
            System.out.println("heapSorting:            Total "+total7+ " Average " + total7 / num_times_running);
            System.out.println("radixSortING:           Total "+total8+ " Average " + total8 / num_times_running);
*/
        }

    }

}