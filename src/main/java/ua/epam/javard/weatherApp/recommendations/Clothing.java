package ua.epam.javard.weatherApp.recommendations;

public enum Clothing {

    // ACCESSORIES

    UMBRELLA("Umbrella"),
    SUNGLASSES("Sunglasses"),

    // HEAD
    PANAMA_HAT("Panama hat"),
    BASEBALL_HAT("Baseball hat"),
    BEANIE("Beanie"),
    SCARF("Scarf"),

    // TORSO
    T_SHIRT("T-Shirt"),
    JACKET("Jacket"),
    WINTER_JACKET("Winter Jacket"),

    // LEGS
    SHORTS("Shorts"),
    LIGHT_PANTS("Light pants"),
    WARM_PANTS("Warm pants"),

    // FEET
    SANDALS("Sandals"),
    BOOTS("Boots"),
    SNEAKERS("Sneaker");

    private String name;

    Clothing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}