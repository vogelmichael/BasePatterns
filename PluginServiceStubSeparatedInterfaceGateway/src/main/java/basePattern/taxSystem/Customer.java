package main.java.basePattern.taxSystem;

public class Customer {

    private String _customer;

    public Customer(String _customer) {
        this._customer = _customer;
    }

    public String get_customer() {
        return _customer;
    }

    public Customer set_customer(String _customer) {
        this._customer = _customer;
        return this;
    }
}
