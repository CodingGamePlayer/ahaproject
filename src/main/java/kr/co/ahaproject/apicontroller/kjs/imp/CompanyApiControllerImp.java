package kr.co.ahaproject.apicontroller.kjs.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ahaproject.apicontroller.kjs.CompanyApiController;
import kr.co.ahaproject.dto.CompanyDTO;
import kr.co.ahaproject.service.kjs.CompanyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class CompanyApiControllerImp implements CompanyApiController{

	@Autowired
	CompanyService companyService;
	
	@Override
	@PostMapping("/company")
	public ResponseEntity<CompanyDTO> register(@RequestBody CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		if(companyDTO == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		int result = companyService.register(companyDTO);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	@PutMapping("/company")
	public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
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
	@DeleteMapping("/company")
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
