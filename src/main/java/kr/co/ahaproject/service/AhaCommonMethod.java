package kr.co.ahaproject.service;

public class AhaCommonMethod {

    public String changeDate(String target){
        String before = target.substring(0,12);

        String result1 = before.replace(" ", "");
        String after = result1.replace(".", "-");

        return after;
    }
}
