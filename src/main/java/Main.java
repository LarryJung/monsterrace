import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        int numberOfMonster;
        List<Monster> monsters = new ArrayList<>();
        int numberOfRound;
        Scanner sc = new Scanner(System.in);

        System.out.println("<신나는 몬스터 레이스>");
        System.out.println("몇 명의 몬스터가 경주하나요?");

        numberOfMonster = Integer.parseInt(sc.nextLine());

        System.out.println("총 " + numberOfMonster + "명");
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");

        for (int i = 0; i < 3; i++) {
            String[] inputs = sc.nextLine().split(",");
            monsters.add(new Monster(inputs[0].trim(), inputs[1].trim()));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        numberOfRound = Integer.parseInt(sc.nextLine());
        System.out.println("횟수: " + numberOfRound);

        sc.close();

        System.out.println("경기 시작");
        for (int i = 0; i < 10; i++) {
            monsters.forEach(Monster::move);
        }
        // print result
        monsters.forEach(monster -> System.out.println(monster.getUserName() + " [" + monster.type() + "] : " + IntStream.range(0, monster.getDistance()).mapToObj(ii -> "-").collect(Collectors.joining())));

        List<Monster> winners = calcWinners(monsters);

        System.out.println("축하합니다! " + winners.stream().map(Monster::getUserName).collect(Collectors.joining(",")) + " 가 몬스터 레이스에서 우승했습니다.");
    }

    private static List<Monster> calcWinners(List<Monster> monsters) {
        int max = 0;
        List<Monster> winners = new ArrayList<>();
        for (Monster m : monsters) {
            max = Math.max(max, m.getDistance());
        }
        for (Monster m : monsters) {
            if (m.getDistance() == max) {
                winners.add(m);
            }
        }
        return winners;
    }
}