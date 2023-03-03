package org.example;

import java.util.Scanner;
public class Container {
    //static을 통해서 클래스내의 1개만 존재하게 하여 공유해서 사용하도록 설정한다.
    private static Scanner sc;

    //프로그램이 실행되면 자동으로 실행된다. -> new Container()하지 않아도된다.
//    static {
//        init();
//    }
    public static void init(){
        sc =new Scanner(System.in);
    }

    public static Scanner getScanner(){
        return sc;
    }
}
