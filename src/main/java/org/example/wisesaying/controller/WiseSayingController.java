package org.example.wisesaying.controller;

import org.example.wisesaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    long lastWiseSayingId;
    private final List<WiseSaying> wiseSayingList;
    private final Scanner sc;

    public WiseSayingController(Scanner sc) {
        lastWiseSayingId = 0L;
        wiseSayingList = new ArrayList<>();
        this.sc = sc;
    }

    public void write() {
        System.out.print("명언: ");
        String content = sc.nextLine().trim();
        System.out.print("작가: ");
        String authorName = sc.nextLine().trim();
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
}
