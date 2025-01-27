package Midterm;

import java.util.Arrays;

class InversionCount {
    public static int countInversions(Product[] products) {
        return mergeSortAndCount(products, 0, products.length - 1);
    }

    private static int mergeSortAndCount(Product[] products, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(products, left, mid);
            count += mergeSortAndCount(products, mid + 1, right);
            count += mergeAndCount(products, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(Product[] products, int left, int mid, int right) {
        Product[] leftArray = Arrays.copyOfRange(products, left, mid + 1);
        Product[] rightArray = Arrays.copyOfRange(products, mid + 1, right + 1);
        int i = 0, j = 0, k = left, swaps = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].price <= rightArray[j].price) {
                products[k++] = leftArray[i++];
            } else {
                products[k++] = rightArray[j++];
                swaps += (mid + 1) - (left + i);
            }
        }

        while (i < leftArray.length) products[k++] = leftArray[i++];
        while (j < rightArray.length) products[k++] = rightArray[j++];
        return swaps;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Product A", 300, new Category(1, "Electronics")),
                new Product(2, "Product B", 200, new Category(2, "Books")),
                new Product(3, "Product C", 400, new Category(1, "Electronics"))
        };

        int inversions = countInversions(products);
        System.out.println("Number of inversions: " + inversions);
    }
}
