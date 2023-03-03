package org.example;

import org.example.system.controller.SystemController;
import org.example.wisesaying.controller.WiseSayingController;
import org.example.wisesaying.entity.WiseSaying;

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

        WiseSayingController wiseSayingController = new WiseSayingController(sc);
        SystemController systemController = new SystemController();


        while(true){
            System.out.print("명령) ");
            String command = sc.nextLine().trim();
            if (command.equals("종료")) {
                SystemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            }
        }
    }
}