package dice.test.reviewExample.schoolBells.entity;

public class SelectSyllableNames {
    private String syllableNames = "";
    public String startSchoolBellsSong(int selectSyllableNames) {
        if (selectSyllableNames == SyllableNames.DO.getValue()) {
            syllableNames += SyllableNames.DO.getName();

        } else if (selectSyllableNames == SyllableNames.RE.getValue()) {
            syllableNames += SyllableNames.RE.getName();

        } else if (selectSyllableNames == SyllableNames.MI.getValue()) {
            syllableNames += SyllableNames.MI.getName();

        } else if (selectSyllableNames == SyllableNames.FA.getValue()) {
            syllableNames += SyllableNames.FA.getName();

        } else if (selectSyllableNames == SyllableNames.SOL.getValue()) {
            syllableNames += SyllableNames.SOL.getName();

        } else if (selectSyllableNames == SyllableNames.RA.getValue()) {
            syllableNames += SyllableNames.RA.getName();

        } else if (selectSyllableNames == SyllableNames.SI.getValue()) {
            syllableNames += SyllableNames.SI.getName();
        }
        return syllableNames;
    }
}
