import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculationOfDeposit();
    }

    double calculateComplexPercent(double a, int day) {

        double pay = a * Math.pow((1 + 0.06 / 12), 12 * day);
        return reward(pay);
    }

    double calculateSimplePercent(double amount, int depositPeriod) {
        return reward(amount + amount * 0.06 * depositPeriod);
    }

    double reward(double value) {
        double scaLe = Math.pow(10, 2);
        return Math.round(value * scaLe) / scaLe;
    }

    void calculationOfDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double typeOfDeposit = 0;
        if (action == 1) {
            typeOfDeposit = calculateSimplePercent(amount, period);
        } else if (action == 2) {
            typeOfDeposit = calculateComplexPercent(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + typeOfDeposit);
    }

}
