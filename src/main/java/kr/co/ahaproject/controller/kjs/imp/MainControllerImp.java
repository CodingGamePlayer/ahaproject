package kr.co.ahaproject.controller.kjs.imp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.kjs.MainController;


@Controller
public class MainControllerImp implements MainController {

    @Override
    @GetMapping("/")
    public String main() {
        return "user/main";
    }

    

    /*		자재 기초정보 CRUD
            작업자 : 재원 23.02.07       */
    
    // 자재 기초정보 START ======
    
    // 자재 기초정보 전체글보기
	@Override
	@GetMapping("/user/basicinfo/material/list")
	public String list(Model model) {
		
//		model.addAttribute("listData", materialService.listAll());
		return "/user/material/material";
	}
	
	// 자재 기초정보 글생성 이동
	@Override
	@GetMapping("/user/basicinfo/material/register")
	public String register() {
			
		return "/user/material/material-form.html";
	}
	
	// 자재 기초정보 글생성 처리
	@Override
	@PostMapping("/user/basicinfo/material/registerPro")
	public String registerPro(MaterialDTO dto) {
		
//		materialService.create(dto);
		System.out.println("처리완료");
		return "redirect:/user/basicinfo/material/list";
	}

	@Override
	public String detail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String updatePro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}



	





}
