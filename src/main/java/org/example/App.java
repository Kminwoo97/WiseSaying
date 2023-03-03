package org.example;

import org.example.system.controller.SystemController;
import org.example.wisesaying.controller.WiseSayingController;
import org.example.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public App() {
    }

    //Main에서 App.run()을 호출한다.
    public void run() {
        System.out.println("== 명언 앱 ==");

        WiseSayingController wiseSayingController = new WiseSayingController();
        SystemController systemController = new SystemController();

        while(true){
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(command);

            if (rq.getActionCode().equals("종료")) {
                SystemController.exit();
                break;
            } else if (rq.getActionCode().equals("등록")) {
                wiseSayingController.write();
            } else if (rq.getActionCode().equals("목록")) {
                wiseSayingController.list();
            } else if (rq.getActionCode().equals("삭제")) {
                wiseSayingController.remove(rq);
            } else if (rq.getActionCode().equals("수정")) {
                wiseSayingController.modify(rq);
            }
        }
    }
}