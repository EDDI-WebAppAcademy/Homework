package dice.test.reviewExample.schoolBells.entity;

import lombok.Getter;

@Getter
public enum SyllableNames {
    DO("도", 1),
    RE("레", 2),
    MI("미", 3),
    FA("파", 4),
    SOL("솔", 5),
    RA("라", 6),
    SI("시", 7);

    private final String name;
    private final int value;

    SyllableNames(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
