package kr.co.ahaproject.controller.kjh;

import org.springframework.ui.Model;

public interface IncomeController {

    public String selectAll(Model model);
    public String selectOne(int id, Model model);
    public String registerForm();
    public String editForm(int id, Model model);
//gkgkkgk 이런 오류는 어떻게 만드는건지 강의좀 일단 저게 걸린듯한데 지금 데이터 합쳐도 되는건지? ㅇㅇ 여기꺼 ㅃ백업 이름 바꾸면 되는거 같은데
//    일단 로컬이니 한번 커밋해보겠음 아 이런건 처음보는데
}
