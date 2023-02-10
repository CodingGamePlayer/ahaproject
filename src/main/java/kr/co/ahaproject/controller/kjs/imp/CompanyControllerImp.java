package kr.co.ahaproject.controller.kjs.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ahaproject.controller.kjs.CompanyController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.kjs.imp.CompanyServiceImp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/company")
public class CompanyControllerImp implements CompanyController {
	
	@Autowired
	private CompanyServiceImp companyService;
	
//	리스트페이지이동
	@Override
	@GetMapping("/list")
	public String company(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("companys",  companyService.selectAll());
		return "user/company/company-list";
	}

//	작성페이지이동
	@Override
	@GetMapping("/form")
	public String companyForm(Model model, CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		
		return "user/company/company-form";
	}

//	수정페이지이동
	@Override
	@GetMapping("/edit")
	public String compnayEditForm(Model model, CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		CompanyDTO rs = companyService.findById(companyDTO);
		model.addAttribute("company", rs);
		return "user/company/company-edit";
	}

//	페이징 추가한 게시물 목록
	@GetMapping("/pList")
	public String getListPage(Model model, @RequestParam("num") int num) {

//		게시물 총 갯수
		int count = companyService.count();
		
//		한페이지에 출력할 게시물 갯수
		int postNum = 10;
		
//		하단 페이징 번호 [ 게시물 총 갯수 / 한페이지 출력할 갯수] 올림
		int pageNum = (int)Math.ceil((double)(count/postNum));
		
//		출력할 게시물
		int displayPost = (num -1) * postNum;
		
//		한번에 표시할 페이징 번호 갯수
		int pageNum_cnt =10;
		
//		표시되는 페이지 번호 줄 마지막 번호
		int endPageNum = (int)(Math.ceil((double)num/ (double)pageNum_cnt)*pageNum_cnt);
		
//		표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		
		// 마지막 번호 재계산
		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		 
		if(endPageNum > endPageNum_tmp) {
		 endPageNum = endPageNum_tmp;
		}
		
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		
		List<CompanyDTO> list = companyService.pageList(displayPost, postNum);
		model.addAttribute("companys", list);
		model.addAttribute("pageNum", pageNum);
		
		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		// 이전 및 다음 
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		return "user/company/company-pList";
	
	}

	
	

}
