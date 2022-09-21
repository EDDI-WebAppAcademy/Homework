package kr.eddi.demo.entity.basic.practiceQuestion;

import java.util.LinkedList;
import java.util.List;

public class SchoolBellRings {
    private List<ScaleCode> schoolBellRingsScaleCode;
public SchoolBellRings(){
    schoolBellRingsScaleCode = new LinkedList<>();
    //schoolBellRingsScaleCode.add(0 ,ScaleCode.G.toString());
    //schoolBellRingsScaleCode.add(0 ,ScaleCode.;
    //schoolBellRingsScaleCode.add(1 ,ScaleCode.valueOf("G"));
    //schoolBellRingsScaleCode.add(2 ,ScaleCode.valueOf("G"));
    //schoolBellRingsScaleCode.add(3 ,ScaleCode.valueOf("G"));
    //schoolBellRingsScaleCode.add(4 ,ScaleCode.valueOf("G"));
    //schoolBellRingsScaleCode.add(5 ,ScaleCode.valueOf("G"));
    //schoolBellRingsScaleCode.add(2 ,ScaleCode.A.name());
    //schoolBellRingsScaleCode.add(3 ,ScaleCode.A.name());
   // schoolBellRingsScaleCode.add(4 ,ScaleCode.G.name());
    //schoolBellRingsScaleCode.add(5 ,ScaleCode.G.name());
    //schoolBellRingsScaleCode.add(6 ,ScaleCode.E.name());

    for (int i = 0; i < schoolBellRingsScaleCode.size(); i++) {
        System.out.print(schoolBellRingsScaleCode.get(i));
        }
    }
}
