import com.gmail.buckartz.DanceTournament;
import com.gmail.buckartz.Producer;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void main(String[] args) {
        DanceTournament danceTournament = new DanceTournament();
        Producer producer = new Producer.ProducerBuilder("Any").build();
        danceTournament.startTournament();

        List<String> testPrograms = new ArrayList<>();
        testPrograms.add("2 0 7");
        testPrograms.add("8");
        testPrograms.add("2 2 1");
        testPrograms.add("4 2 0 2 3");
        testPrograms.add("4 2 9 2 3");
        testPrograms.add("6 2 2 4 9 1 3");
        testPrograms.add("6 9 5 9 9 6 1 7 7 5 5 9");
        testPrograms.add("2 1 1");
        testPrograms.add("2 3 4 5 6 7 8 9 ");
        testPrograms.add("2 4 6 8 8 6 4 2 1 2 5 2 1 ");

        testPrograms.forEach(program -> {
            System.out.println("Sequence: " + program);
            System.out.println("Result: " + danceTournament.nextDancer(program) + '\n');
        });

        System.out.println(danceTournament.getWinner());
        danceTournament.endTournament();
    }
}
