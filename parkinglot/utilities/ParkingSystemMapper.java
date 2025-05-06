package parkinglot.utilities;

import parkinglot.models.SlotType;

public class ParkingSystemMapper {
    public static SlotType mapSlotTypeStringToSlotType(String slotTypeStr) {
        SlotType slotTypeEnum = null;
        switch(slotTypeStr.toUpperCase()) {
            case "S":
                slotTypeEnum = SlotType.SMALL;
                break;
            case "M":
                slotTypeEnum = SlotType.MEDIUM;
                break;
            case "L":
                slotTypeEnum = SlotType.LARGE;
                break;
        }
        return slotTypeEnum;
    }
}
