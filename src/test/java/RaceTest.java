import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RaceTest {

    @Test
    public void 몬스터_초기화_테스트() {
        Monster monster1 = new Monster("크롱", "달리기");
        assertThat(monster1.getUserName(), is("크롱"));
    }

    @Test
    public void 이동테스트_달리기_성공() {
        Monster monster1 = new Monster("크롱", new RunStrategy(new StubNumberGenerator(4)));
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(1));
    }

    @Test
    public void 이동테스트_달리기_실패() {
        Monster monster1 = new Monster("크롱", new RunStrategy(new StubNumberGenerator(3)));
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(0));
    }

    @Test
    public void 이동테스트_비행_성공() {
        Monster monster1 = new Monster("크롱", new FlightStrategy(new StubNumberGenerator(6)));
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(3));
    }

    @Test
    public void 이동테스트_비행_실패() {
        Monster monster1 = new Monster("크롱", new FlightStrategy(new StubNumberGenerator(5)));
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(0));
    }

    @Test
    public void 이동테스트_에스퍼_성공() {
        NumberGenerator numberGenerator = new StubNumberGenerator(9);
        NumberGenerator distanceGenerator = new StubNumberGenerator(50);
        EsperStrategy esperStrategy = new EsperStrategy(distanceGenerator, numberGenerator);
        Monster monster1 = new Monster("크롱", esperStrategy);
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertTrue(monster1.getDistance() == 50);
    }

    @Test
    public void 이동테스트_에스퍼_실패() {
        NumberGenerator numberGenerator = new StubNumberGenerator(8);
        NumberGenerator distanceGenerator = new StubNumberGenerator(50);
        EsperStrategy esperStrategy = new EsperStrategy(distanceGenerator, numberGenerator);
        Monster monster1 = new Monster("크롱", esperStrategy);
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertTrue(monster1.getDistance() == 0);
    }

    @Test
    public void 여러번_이동() {
        Monster monster1 = new Monster("크롱", new FlightStrategy(new StubNumberGenerator(6)));

        monster1.move();
        monster1.move();
        assertTrue(monster1.getDistance() == 6);
    }

    @Test
    public void 우승자_선출() {
        Monster esper = new Monster("크롱에스퍼", "에스퍼");
        Monster flight = new Monster("크롱비행", "비행");
        Monster run = new Monster("크롱달리기", "달리기");

        List<Monster> monsters = Arrays.asList(run, flight, esper);

        for (int i = 0; i < 10; i++) {
            monsters.forEach(monster -> monster.move());
        }

        int max = 0;
        List<Monster> winners = new ArrayList<>();
        for (Monster m : monsters) {
            max = Math.max(max, m.getDistance());
        }
        for (Monster m : monsters) {
            if (m.getDistance() == max) {
                winners.add(m);
            }
        }

        System.out.println("originals");
        monsters.forEach(System.out::println);

        System.out.println("winners");
        winners.forEach(System.out::println);

    }
}
