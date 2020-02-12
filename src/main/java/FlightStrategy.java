public class FlightStrategy implements MoveStrategy {

    private NumberGenerator numberGenerator;

    public FlightStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public int getDistance() {
        return numberGenerator.getInt() >= 6 ? 3 : 0;
    }

    @Override
    public String getType() {
        return "비행";
    }
}
