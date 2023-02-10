package kr.co.ahaproject.controller.cjw.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ahaproject.controller.cjw.UseMaterialController;
import kr.co.ahaproject.dto.UseMaterialDTO;
import kr.co.ahaproject.service.cjw.UseMaterialService;

@Controller
public class UseMaterialControllerImp implements UseMaterialController {

	@Autowired
	UseMaterialService useMaterialService;
	
	//현장 자재 목록 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/list")
	public String list(Model model) {
		model.addAttribute("listData", useMaterialService.listAll());
		return "/user/use-material/use-material";
	}

	//현장 자재 글생성 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/register")
	public String register() {
		return "/user/use-material/use-material-form";
	}

	//현장 자재 상세보기 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/detail")
	public String detail(UseMaterialDTO dto, Model model) {
		return "user/use-material/use-material-edit-form";
	}

}
