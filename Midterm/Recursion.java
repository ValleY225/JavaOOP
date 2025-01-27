package Midterm;

import java.util.Arrays;

public class Recursion {
        public static void generateCombinations(Product[] products, int k) {
            Product[] combination = new Product[k];
            generateCombinationsRecursive(products, combination, 0, 0, k);
        }
        private static void generateCombinationsRecursive(Product[] products, Product[] combination, int start, int index, int k) {
            if (index == k) {
                System.out.println(Arrays.toString(combination));
                return;
            }
            for (int i = start; i < products.length; i++) {
                combination[index] = products[i];
                generateCombinationsRecursive(products, combination, i + 1, index + 1, k);
            }
        }

        public static void main(String[] args) {
            Product[] products = {
                    new Product(1, "Product A", 300, new Category(1, "Electronics")),
                    new Product(2, "Product B", 200, new Category(2, "Books")),
                    new Product(3, "Product C", 400, new Category(1, "Electronics"))
            };

            generateCombinations(products, 2);
        }
}
