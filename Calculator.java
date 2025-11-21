package Quest.calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> history = new ArrayList<>();

        while (true) {

            System.out.println(); // 계산기 재실행 시 한 줄 띄우기
            System.out.print("=== 계산기 메뉴 ===\n1. 계산하기\n2. 계산 이력 보기\n3. 이력 지우기\n0. 종료\n선택: ");
            int menu = scanner.nextInt();

            switch (menu) {

                case 1: // 계산기 계산하기
                    while (true) { // 계산기 반복을 위한 while문

                        System.out.println(); // 계산기 재실행 시 한 줄 띄우기

                        try {
                            System.out.println("=== Java 계산기 ===");
                            System.out.print("첫 번째 숫자를 입력하세요: ");
                            double num1 = scanner.nextDouble();

                            System.out.print("연산자를 입력하세요(+, -, *, /, %, ^, r): ");
                            String op = scanner.next();

                            System.out.print("두 번째 숫자를 입력하세요: ");
                            double num2 = scanner.nextDouble();

                            double result = 0;

                            switch (op) {
                                case ("+"):
                                    result = num1 + num2;
                                    break;

                                case ("-"):
                                    result = num1 - num2;
                                    break;

                                case ("*"):
                                    result = num1 * num2;
                                    break;

                                case ("/"):
                                    // 0으로 나눌수 없도록
                                    if (num2 == 0) {
                                        System.out.println("0으로 나눌 수 없습니다.");
                                        continue; // 0으로 나누는 잘못된 계산을 실행해도 다시 계산기 실행하도록 continue문
                                    } else {
                                        result = num1 / num2;
                                        break;
                                    }
                                case ("%"):
                                    result = num1 / num2;
                                    break;

                                case ("^"):
                                    result = Math.pow(num1, num2);
                                    break;

                                case ("r"):
                                    if (num1 < 0) {
                                        System.out.println("음수의 제곱근은 계산할 수 없습니다.");
                                        continue;
                                    }
                                    result = Math.sqrt(num1);

                                    System.out.println("결과: √" + num1 + " = " + result);
                                    history.add("√" + num1 + " = " + result);
                                    break;

                                default:
                                    System.out.println("지원하지 않는 연산자입니다.");
                                    continue; // 연산자 잘못 입력시에도 다시 계산기 실행하도록 continue문
                            }

                            System.out.println("결과: " + num1 + " " + op + " " + num2 + " = " + result);
                            System.out.println();

                            history.add(num1 + " " + op + " " + num2 + " = " + result);

                            String answer;

                            while (true) {
                                // y,n 이외의 문자 입력시 반복
                                System.out.print("계속 계산하시겠습니까? (y/n): ");
                                answer = scanner.next();

                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                                    break;
                                }
                                System.out.println("y 또는 n만 입력 가능합니다.");
                            }

                            // n 입력시 종료
                            if (answer.equalsIgnoreCase("n")) {
                                System.out.println("계산하기를 종료합니다.");
                                break;
                            }


                        } catch (InputMismatchException e) {
                            System.out.println("숫자를 입력해주세요.");
                            scanner.nextLine(); // 잘못된 입력 제거
                            continue;
                        }
                    }
                case 2: // 연산 기록 확인하기
                    System.out.println("=== 연산 기록 ===");
                    if (history.isEmpty()) {
                        System.out.println("아직 기록이 없습니다.");
                    } else {
                        for (String h : history) {
                            System.out.println(h);
                        }
                    }
                    System.out.println();
                    break;


                case 3: // 연산 기록 삭제하기
                    history.clear();
                    System.out.println("연산 기록을 삭제했습니다.\n");
                    break;


                case 0: // 계산기 종료
                    System.out.println("계산기를 종료합니다.");
                    return;

                default:
                    System.out.println("알맞은 숫자를 입력하세요.");
                    continue;

            }
        }


    }
}
