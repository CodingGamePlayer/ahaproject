package kr.co.ahaproject.controller.cjw.imp;

import kr.co.ahaproject.controller.cjw.UseMaterialController;
import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.service.cjw.MaterialService;
import kr.co.ahaproject.service.cjw.UseMaterialService;
import kr.co.ahaproject.service.mskim.ConstructionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UseMaterialControllerImp implements UseMaterialController {

	private final UseMaterialService useMaterialService;
	private final ConstructionService constructionService;
	private final MaterialService materialService;

	//현장 자재 목록 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/list")
	public String list(@Valid PageRequestDTO pageRequestDTO, Model model) {

		PageResponseDTO<UseMaterialDTO> pageResponseDTO = useMaterialService.selectAllForPaging(pageRequestDTO);

		model.addAttribute("listData", pageResponseDTO);
		return "/user/use-material/use-material";
	}

	//현장 자재 글생성 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/register")
	public String register(Model model, UseMaterialDTO useMaterialDTO) {


		List<ConstructionDTO> constructionDTOS = constructionService.selectAll();
		List<MaterialDTO> materialDTOS = materialService.listAll();



		if(useMaterialService.selectCount() > 0) {
		        int id = useMaterialService.selectCount() + 1;
		        String idkey = String.format("%04d",id);
		        model.addAttribute("idkey", "MT"+idkey);
		        model.addAttribute("constructionDTOs", constructionDTOS);
		        model.addAttribute("materialDTOs", materialDTOS);
		    } else {
		        String idkey = "0001";
		        model.addAttribute("idkey","MT"+idkey);
		        model.addAttribute("constructionDTOs", constructionDTOS);
		        model.addAttribute("materialDTOs", materialDTOS);
		    }
			
		
		return "/user/use-material/use-material-form";
	}

	//현장 자재 상세보기 - 이동하기
	@Override
	@GetMapping("/user/worksite/use-material/detail")
	public String detail(UseMaterialDTO dto, Model model) {
		
		model.addAttribute("selectData", useMaterialService.selectOne(dto.getUm_id()));
		return "user/use-material/use-material-edit-form";
	}

}
