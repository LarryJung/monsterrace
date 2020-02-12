public class Monster {

    private String userName;
    private String moveType;
    private int distance = 0;

    public Monster(String userName, String moveType) {
        this.userName = userName;
        this.moveType = moveType;
    }

    public String getUserName() {
        return userName;
    }

    public String getMoveType() {
        return moveType;
    }

    public int getDistance() {
        return distance;
    }

    public void move(NumberGenerator numberGenerator) {
        switch (moveType) {
            case "달리기":
                distance++;
                return;
            case "비행":
                distance = distance + 3;
                return;
            case "에스퍼":
                distance = distance + numberGenerator.getInt();
        }
    }

}
