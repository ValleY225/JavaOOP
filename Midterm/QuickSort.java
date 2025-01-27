package Midterm;

import java.util.Arrays;

class QuickSort {
    public static void Quicksort(Product[] products, int low, int high) {
        if (low < high) {
            int pi = partition(products, low, high);
            Quicksort(products, low, pi - 1);
            Quicksort(products, pi + 1, high);
        }
    }

    private static int partition(Product[] products, int low, int high) {
        int pivot = products[high].price;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (products[j].price <= pivot) {
                i++;
                swap(products, i, j);
            }
        }
        swap(products, i + 1, high);
        return i + 1;
    }

    private static void swap(Product[] products, int i, int j) {
        Product temp = products[i];
        products[i] = products[j];
        products[j] = temp;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Product A", 300, new Category(1, "Electronics")),
                new Product(2, "Product B", 200, new Category(2, "Books")),
                new Product(3, "Product C", 400, new Category(1, "Electronics"))
        };

        Quicksort(products, 0, products.length - 1);
        System.out.println(Arrays.toString(products));
    }
}
