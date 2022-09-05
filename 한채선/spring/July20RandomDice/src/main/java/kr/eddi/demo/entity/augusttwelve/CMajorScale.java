package kr.eddi.demo.entity.augusttwelve;

import lombok.Getter;

@Getter
public enum CMajorScale {
    TONIC("C4", 0),
    SUPERTONIC("D4", 1),
    MEDIANT("E4", 2),
    SUBDOMINANT("F4", 3),
    DOMINANT("G4", 4),
    SUBMEDIANT("A4", 5),
    LEADING_TONE("B4", 6);

    private String scaleDegree;
    private int pitch;

    private static final int ERROR = -1;

    private CMajorScale(String scaleDegree, int pitch) {
        this.scaleDegree = scaleDegree;
        this.pitch = pitch;
    }

    public static int getFrequency(String scaleDegree) {
        return switch (scaleDegree) {
            case "C4" -> TONIC.getPitch();
            case "D4" -> SUPERTONIC.getPitch();
            case "E4" -> MEDIANT.getPitch();
            case "F4" -> SUBDOMINANT.getPitch();
            case "G4" -> DOMINANT.getPitch();
            case "A4" -> SUBMEDIANT.getPitch();
            case "B4" -> LEADING_TONE.getPitch();
            default -> ERROR;
        };
    }
}
