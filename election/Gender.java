package election;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHERS("OTHERS");

    String value;

    Gender(String value) {
        this.value = value;
    }

    static Gender getByValue(String value) {
        for (Gender g : Gender.values()) {
            if (g.value.equals(value)) {
                return g;
            }
        }
        return null;
    }

}