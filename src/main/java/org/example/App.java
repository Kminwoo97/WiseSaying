package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    //Main에서 App.run()을 호출한다.
    public void run() {
        System.out.println("== 명언 앱 ==");

        long lastWiseSayingId = 0L;
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        while(true){
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언: ");
                String content = sc.nextLine().trim();
                System.out.print("작가: ");
                String authorName = sc.nextLine().trim();
                System.out.println(++lastWiseSayingId + "번 명언이 등록되었습니다.");

                wiseSayingList.add(new WiseSaying(lastWiseSayingId, content, authorName));
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("===================");


                for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayingList.get(i);
                    System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthorName() + " / " + wiseSaying.getContent());
                }
            }
        }
    }
}