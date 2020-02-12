public class FlightStrategy implements MoveStrategy {

    @Override
    public int getDistance() {
        return 3;
    }

    @Override
    public String getType() {
        return "비행";
    }
}
