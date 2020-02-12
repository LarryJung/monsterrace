import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RaceTest {

    @Test
    public void 몬스터_초기화_테스트() {
        Monster monster1 = new Monster("크롱", "달리기");
        assertThat(monster1.getUserName(), is("크롱"));
    }

    @Test
    public void 이동테스트_달리기() {
        Monster monster1 = new Monster("크롱", "달리기");
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(1));
    }

    @Test
    public void 이동테스트_비행() {
        Monster monster1 = new Monster("크롱", "비행");
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertThat(monster1.getDistance(), is(3));
    }

    @Test
    public void 이동테스트_에스퍼() {
        NumberGenerator numberGenerator = new StubNumberGenerator();
        EsperStrategy esperStrategy = new EsperStrategy(numberGenerator);
        Monster monster1 = new Monster("크롱", esperStrategy);
        assertThat(monster1.getDistance(), is(0));
        monster1.move();
        assertTrue(monster1.getDistance() == 50);
    }

    @Test
    public void 여러번_이동() {

    }
}
