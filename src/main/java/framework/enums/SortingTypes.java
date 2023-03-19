package framework.enums;

import lombok.Getter;

@Getter
public enum SortingTypes {
    NAME_A_Z("Name, A to Z"),
    NAME_Z_A("Name, Z to A"),
    PRICE_LOW_HIGH("Price, low to high"),
    PRICE_HIGH_LOW("Price, high to low");

    private final String valueName;

    SortingTypes(String valueName) {
        this.valueName = valueName;
    }
}
