public class Monster {

    private String userName;
    private MoveStrategy moveStrategy;
    private int distance = 0;

    public Monster(String userName, String moveType) {
        this.userName = userName;
        this.moveStrategy = MoveStrategyFactory.of(moveType);
    }

    public Monster(String userName, MoveStrategy moveStrategy) {
        this.userName = userName;
        this.moveStrategy = moveStrategy;
    }

    public String getUserName() {
        return userName;
    }

    public int getDistance() {
        return distance;
    }

    public int move() {
        this.distance = distance + this.moveStrategy.getDistance();
        return distance;
    }

    public String type() {
        return moveStrategy.getType();
    }

    @Override
    public String toString() {
        return "Monster{" +
                "userName='" + userName + '\'' +
                ", moveStrategy=" + moveStrategy +
                ", distance=" + distance +
                '}';
    }
}
