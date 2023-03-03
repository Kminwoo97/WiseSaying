package org.example;


import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode; //등록, 수정, 삭제, 목록
    private Map<String, String> params; //id=1&name="asdfasd" 이런 값들

    public Rq(String command){

        //split[0] - 등록 수정 등 | split[1] - id=1&name=2 이린값들
        String[] commandBits = command.split("\\?", 2);
        actionCode = commandBits[0];

        //commandBits.length == 1 보다 위에 선언해야한다.
        params = new HashMap<>();

        //파라미터 값이 없으면 종료한다.
        if(commandBits.length == 1)
            return;

        //id=1&name=kkk 와 같은 것을 HshaMap에 key-Value 형태로 넣는다.
        //이렇게 분리하면 나중에 검색을 받거나 orderBy=desc 이런식으로 받을수있다.
        String[] paramsBits = commandBits[1].split("&");
        for (String param : paramsBits) {
            String[] paramBits = param.split("=", 2);

            //삭제?id= 이런한 입력을 했을때는 copntinue;
            if(paramBits.length == 1)
                continue;

            String key = paramBits[0];
            String value = paramBits[1];

            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }

    //특정 파라미터 값 알아내기
    public String getParams(String name) {
        return params.get(name);
    }

    public long getLongParam(String name, long defaultValue) {
        try{
            return Long.parseLong(getParams("id"));
        }catch (NumberFormatException e){
        }

        return defaultValue;
    }
}
