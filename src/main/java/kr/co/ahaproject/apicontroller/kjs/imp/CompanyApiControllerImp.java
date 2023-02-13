package kr.co.ahaproject.apicontroller.kjs.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.ahaproject.apicontroller.kjs.CompanyApiController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class CompanyApiControllerImp implements CompanyApiController{

	@Autowired
	CompanyService companyService;
	
	
//	회사 정보 등록
	@Override
	@Operation(summary = "register of company,post", description = "회사정보 등록")
	@PostMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> register(@RequestBody CompanyDTO companyDTO) {
		// TODO Auto-generated method stub

//		날짜변경 메소드
		String after = new AhaCommonMethod().changeDate(companyDTO.getCp_establish());
		companyDTO.setCp_establish(after);
		
		String after1 = new AhaCommonMethod().changeDate(companyDTO.getCp_open());
		companyDTO.setCp_establish(after1);
		
		if(companyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = companyService.register(companyDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
//	회사정보 수정
	@Override
	@Operation(summary = "update for company,put", description = "회사정보 수정")
	@PutMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO) {
		// TODO Auto-generated method stub

//		날짜변경 메소드
		String after = new AhaCommonMethod().changeDate(companyDTO.getCp_establish());
		companyDTO.setCp_establish(after);
		
		String after1 = new AhaCommonMethod().changeDate(companyDTO.getCp_open());
		companyDTO.setCp_establish(after1);

		if(companyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = companyService.update(companyDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@Override
	@Operation(summary = "delete for company,delete", description = "회사정보 삭제")
	@DeleteMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> delete(@RequestBody CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		if(companyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = companyService.delete(companyDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();

	}
}
