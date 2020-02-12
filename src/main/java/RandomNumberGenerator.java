import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private int from;
    private int to;

    public RandomNumberGenerator(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public RandomNumberGenerator() {
    }

    public int getInt() {
        return (to == 0 ? new Random().nextInt() : new Random().nextInt(to)) + from;
    }
}
