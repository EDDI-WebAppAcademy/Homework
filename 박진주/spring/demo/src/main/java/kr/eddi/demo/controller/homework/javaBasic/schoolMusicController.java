//package kr.eddi.demo.controller.homework.javaBasic;
//
//import kr.eddi.demo.homework.basic.total2.PitchName;
//import kr.eddi.demo.homework.basic.total2.SchoolMusic;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@RequestMapping("/homework")
//public class schoolMusicController {
//
//
//    @GetMapping("/playEnumMusic")
//    public String playMusic(){
//        SchoolMusicPitch();
//
//        return "2";
//    }
//
//
//
//    public void SchoolMusicPitch(){ // pitch랑 Map<String, Integer> schoolMusicPitch 맞추기
//
//        SchoolMusic schoolMusic = new SchoolMusic();
//        schoolMusic.playSchoolMusic();
//
//        List<String> musicpitchResult = new ArrayList<>();
//
//        for (int i = 0; i <schoolMusic.schoolMusic.length ; i++) {
//            for(PitchName pitchName : PitchName.values()){
//                schoolMusic.schoolMusicPitch.get();
//            }
//
//        // for (PockerCardPattern pockerCardPattern : PockerCardPattern.values()){
//                    //            System.out.println(pockerCardPattern.getName() + ". " +pockerCardPattern.ordinal());
//                    //        }
//
//
//            musicpitchResult.add("계이름");
//        }
//
//
//
//
//        //schoolMusicPitch.put(schoolMusic[i], pitch[i]);
//
//        System.out.println("학교종이 땡땡땡의 계이름은" + musicpitchResult);
//
//    }
//
//
//}
////2. enum 문제
//
////학교종이 땡땡땡의 음계표를 enum을 활용해서 구현해보자.
////"솔솔라라 솔솔미" <<<--- 요기까지만
//
////[출처] 자바 과정 종합 연습 문제 [ 1 ] (에디로봇아카데미) | 작성자 링크쌤