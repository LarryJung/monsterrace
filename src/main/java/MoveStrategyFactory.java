public abstract class MoveStrategyFactory {

    public static MoveStrategy of(String name) {
        switch (name) {
            case "달리기":
                return new RunStrategy(new RandomNumberGenerator(0, 10));
            case "비행":
                return new FlightStrategy(new RandomNumberGenerator(0, 10));
            case "에스퍼":
                return new EsperStrategy(new RandomNumberGenerator(1, 100), new RandomNumberGenerator(0, 10));
            default:
                throw new RuntimeException();
        }
    }
}
