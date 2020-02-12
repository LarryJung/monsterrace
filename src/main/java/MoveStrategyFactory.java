public abstract class MoveStrategyFactory {

    public static MoveStrategy of(String name) {
        switch (name) {
            case "달리기":
                return new RunStrategy();
            case "비행":
                return new FlightStrategy();
            case "에스퍼":
                return new EsperStrategy(new RandomNumberGenerator());
            default:
                throw new RuntimeException();
        }
    }
}
