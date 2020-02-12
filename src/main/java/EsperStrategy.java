public class EsperStrategy implements MoveStrategy {

    private NumberGenerator numberGenerator;

    public EsperStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getDistance() {
        return numberGenerator.getInt();
    }

    @Override
    public String getType() {
        return "에스퍼";
    }
}
