package domain;

public enum FuelType {DIESEL("Diesel"), UNLEADED("Unleaded"), PREMIUM("Premium");
    private String description;

    private FuelType(String description) {
        this.description = description;
    }
}
