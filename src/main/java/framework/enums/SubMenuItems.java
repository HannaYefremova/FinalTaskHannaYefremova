package framework.enums;

import lombok.Getter;

@Getter
public enum SubMenuItems {
    MEN("MEN"),
    WOMEN("WOMEN"),
    STATIONERY("STATIONERY"),
    HOMEACCESSORIES("HOME ACCESSORIES");

    private final String valueName;

    SubMenuItems(String valueName) {
        this.valueName = valueName;
    }
}
