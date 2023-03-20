package framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubMenuItems {
    MEN("MEN"),
    WOMEN("WOMEN"),
    STATIONERY("STATIONERY"),
    HOMEACCESSORIES("HOME ACCESSORIES");

    private final String valueName;
}
