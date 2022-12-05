package kr.eddi.demo.entity.basic.augusttwelve;

import java.util.HashMap;
import java.util.Map;

public class SongMaker {

    Map<String, String> majorScale;
    Map<String, Integer> lyricAndScale;

    private String[] lyrics;
    private String[] scales;


    public SongMaker() {
        lyricAndScale = new HashMap<>();
    }



    public void setLyricToPitch(String lyric, String pitch) {
        lyricAndScale.put(lyric, CMajorScale.getFrequency(pitch));
    }


    // 가사와 스케일이 길이가 맞는지 비교하고 맞을 시에는 true, 아닐 시에 false 를 리턴하는 메소드를 만드는 것도 좋을듯...


    /**
     * 가사를 받아 분리
     * @param lyrics
     */
    public void inputLyrics(String lyrics) {
        this.lyrics = lyrics.split(",");
    }

    /**
     * 가사에 맞는 스케일을 받아 분리
     * @param scales
     */
    public void inputScale(String scales){
        this.scales = scales.split(",");
    }



    public void makeLyricsAndScore(String lyrics, String scales) {
        inputLyrics(lyrics);
        inputScale(scales);

        for (int i = 0; i < this.lyrics.length; i++) {
            setLyricToPitch(this.lyrics[i], this.scales[i]);
        }
    }

}
