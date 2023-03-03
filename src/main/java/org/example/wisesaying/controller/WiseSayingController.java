package org.example.wisesaying.controller;

import org.example.Container;
import org.example.Rq;
import org.example.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    long lastWiseSayingId;
    private final List<WiseSaying> wiseSayingList;

    public WiseSayingController() {
        lastWiseSayingId = 0L;
        wiseSayingList = new ArrayList<>();
    }

    public void write() {
        System.out.print("명언: ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가: ");
        String authorName = Container.getScanner().nextLine().trim();
        System.out.println(++lastWiseSayingId + "번 명언이 등록되었습니다.");
        wiseSayingList.add(new WiseSaying(lastWiseSayingId, content, authorName));
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("===================");
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthorName() + " / " + wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        long id = rq.getLongParam("id", -1);
        if (id == -1L) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        //id와 일치하는 명언객체 찾기
        WiseSaying wiseSaying = findById(id);
        if (wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다");
            return;
        }
        wiseSayingList.remove(wiseSaying);
        System.out.println(id+"번 명언이 삭제되었습니다.");
    }

    public WiseSaying findById(Long id){
        for (WiseSaying wiseSaying : wiseSayingList) {
            if(wiseSaying.getId() == id)
                return wiseSaying;
        }
        return null;
    }
}
