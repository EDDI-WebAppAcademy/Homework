package dice.test.fifthExample.third.controller;

import dice.test.fifthExample.third.entity.Sequence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class SequenceNumController {
    private final int EVENNum_TOKEN = 2;
    private final int MULTIPLE_3_TOKEN = 3;
    private final int MULTIPLE_4_TOKEN = 4;
    private final int MULTIPLE_RANDOM_NUM_TOKEN = 5;
    private final int RANDOM_NUM_CYCLE = 6;
    private final int CREATE_RANDOM_NUM_MOVEMENT = 7;
    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 100;

    @ResponseBody
    @GetMapping("/even")
    public String printMultiple() {
        Sequence sequence = new Sequence(EVENNum_TOKEN, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(EVENNum_TOKEN);
    }

    @ResponseBody
    @GetMapping("/multiple-of-3")
    public String printMultiple3() {
        Sequence sequence = new Sequence(MULTIPLE_3_TOKEN, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(MULTIPLE_3_TOKEN);
    }

    @ResponseBody
    @GetMapping("/multiple-of-4")
    public String printMultiple4() {
        Sequence sequence = new Sequence(MULTIPLE_4_TOKEN, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(MULTIPLE_4_TOKEN);
    }

    @ResponseBody
    @GetMapping("/multiple-of-random")
    public String printMultipleOFRandom() {
        Sequence sequence = new Sequence(MULTIPLE_RANDOM_NUM_TOKEN, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(MULTIPLE_RANDOM_NUM_TOKEN);
    }

    @ResponseBody
    @GetMapping("/random-num-cycle")
    public String printRandomNumCycle() {
        Sequence sequence = new Sequence(RANDOM_NUM_CYCLE, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(RANDOM_NUM_CYCLE);
    }

    @ResponseBody
    @GetMapping("/random-num-to-movement")
    public String printRandomNumToMovement() {
        Sequence sequence = new Sequence(CREATE_RANDOM_NUM_MOVEMENT, MIN_RANGE, MAX_RANGE);

        return sequence.findAccordingToStatus(CREATE_RANDOM_NUM_MOVEMENT);
    }

}
