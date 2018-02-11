package week;

// поломано
class BadooTestCase {
    public static void main(String[] args) {
        int[] a = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        System.out.println(search(3, a));
    }

    static int search(int item, int[] array) {
        int mid = array.length / 2;
        int last = array[array.length - 1];

        int[] sortedPart = new int[mid];
        int[] unsortedPart = new int[mid];

        if (array[0] < array[mid]) {
            for (int i = 0; i < sortedPart.length; i++) {
                sortedPart[i] = array[i];
                unsortedPart[i] = array[mid + i];
            }
        }
        if (array[mid] < array[last]) {
            for (int i = 0; i < sortedPart.length; i++) {
                sortedPart[i] = array[mid + i];
                unsortedPart[i] = array[i];
            }
        }

        int lastSorted = sortedPart[sortedPart.length - 1];
        if (item <= lastSorted) {
            // бинарный поиск
            return indexOf(sortedPart, item);
        } else {
            return search(item, unsortedPart);
        }
    }

    private static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
