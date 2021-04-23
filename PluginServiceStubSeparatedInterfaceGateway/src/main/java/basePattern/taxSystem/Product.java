package main.java.basePattern.taxSystem;

public class Product {

    private String _product;

    public Product(String _product) {
        this._product = _product;
    }

    public String get_product() {
        return _product;
    }

    public Product set_product(String _product) {
        this._product = _product;
        return this;
    }
}
