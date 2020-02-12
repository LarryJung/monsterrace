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

    public void move() {
        this.distance = distance + this.moveStrategy.getDistance();
    }

}
