package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //가독성을 위해서 이렇게 만들었다.
        Container.init(); //-> static으로 Scanner자동으로 만들어진다.

        new App().run();

        //Scanner 종료
        Container.getScanner().close();;
    }
}