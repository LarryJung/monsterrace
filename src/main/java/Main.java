import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("<신나는 몬스터 레이스>");
        System.out.println("몇 명의 몬스터가 경주하나요?");
        Scanner sc = new Scanner(System.in);
        int numberOfMonster = Integer.parseInt(sc.nextLine());
        System.out.println("총 " + numberOfMonster + "명");

        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");
        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();
            System.out.println(input);
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int numberOfRound = Integer.parseInt(sc.nextLine());

        System.out.println("횟수: " + numberOfMonster);

        System.out.println("경기 시작");
    }

}