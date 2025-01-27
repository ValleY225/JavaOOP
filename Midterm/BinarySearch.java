package Midterm;

public class BinarySearch {
    public static int binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].name.compareTo(name);

            if (comparison == 0)
                return mid;
            if (comparison < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;  // Not found
    }
}
