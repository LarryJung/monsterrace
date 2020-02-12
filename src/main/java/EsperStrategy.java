public class EsperStrategy implements MoveStrategy {

    private NumberGenerator numberGenerator;
    private NumberGenerator randomDistanceGenerator;

    public EsperStrategy(NumberGenerator randomDistanceGenerator, NumberGenerator numberGenerator) {
        this.randomDistanceGenerator = randomDistanceGenerator;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getDistance() {
        return numberGenerator.getInt() >= 9 ? randomDistanceGenerator.getInt() : 0;
    }

    @Override
    public String getType() {
        return "에스퍼";
    }
}
