package Midterm;

class Product {
    int id;
    String name;
    int price;
    Category category;

    public Product(int id, String name, int price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.price + ")";
    }
}

class Category {
    int id;
    String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
}