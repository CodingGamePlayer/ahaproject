package kr.co.ahaproject.controller.kjs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

public interface EmployeeController {
    //리스트 페이지로 이동
    String listAll(Model model);

    //선택보기 페이지 이동
    String selectOne(Model model);

    //등록하기 페이지 이동
    String goInsert(Model model);

    //등록하기
    String insert();

    //수정하기 페이지 이동
    String goUpdate(Model model);

    //수정하기
    String Insert();

    //삭제하기
    String Delete();
}
