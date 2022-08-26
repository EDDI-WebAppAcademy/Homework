package kr.eddi.demo.entity.basic.eighteenth;

import lombok.Getter;

@Getter
public class SyllableNameManager {

    private String[] syllables;
    private int[] syllablesNumber;

    private final int ERROR = -1;

    public SyllableNameManager(String syllables) {
        System.out.println(syllables);
        this.syllables = syllables.split("");
        System.out.println(syllables);
        for (int i = 0; i < this.syllables.length; i++) {
            System.out.println(this.syllables[i]);
        }
        syllablesNumber = new int[syllables.length()];
    }

    public void analysisSyllables() {
        int cnt = 0;

        for (String oneChar: syllables) {
            syllablesNumber[cnt++] = matchOneSyllable(oneChar);
        }
    }

    public int matchOneSyllable(String oneChar) {

        for (SyllableNameMap syllable: SyllableNameMap.values()) {
            if (syllable.getName().equals(oneChar)) {
                return syllable.getValue();
            }
        }
        return ERROR;
    }

}
