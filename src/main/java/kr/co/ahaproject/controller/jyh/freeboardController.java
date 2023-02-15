package kr.co.ahaproject.controller.jyh;

import org.springframework.ui.Model;

import kr.co.ahaproject.dto.BoardDTO;

public interface freeboardController {


    //자유게시판

    //전체조회
    //String list(Model model);
    String listAll(Model model);
    //작성

    String createForm();

    //상세조회
    String detail(int b_id, Model model);

    //수정
    String update(Model model, BoardDTO dto);



}
