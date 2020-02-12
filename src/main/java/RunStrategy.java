public class RunStrategy implements MoveStrategy {

    private NumberGenerator numberGenerator;

    public RunStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getDistance() {
        return numberGenerator.getInt() >= 4 ? 1 : 0;
    }

    @Override
    public String getType() {
        return "달리기";
    }

}
