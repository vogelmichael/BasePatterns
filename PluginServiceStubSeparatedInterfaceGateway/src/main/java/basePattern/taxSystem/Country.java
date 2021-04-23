package main.java.basePattern.taxSystem;

public class Country {

    private String _countryName;

    public Country(String countryName){
        _countryName = countryName;
    }

    public String get_countryName() {
        return _countryName;
    }

    public Country set_countryName(String _countryName) {
        this._countryName = _countryName;
        return this;
    }
}
