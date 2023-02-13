package kr.co.ahaproject.apicontroller.mskim.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.mskim.UseCardApiController;
import kr.co.ahaproject.dto.UseCardDTO;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.mskim.UseCardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user/worksite/use-card")
public class UseCardApiControllerImpl implements UseCardApiController {
	
	@Autowired
	private UseCardService ucs;

	@Override
	@ApiOperation(value = "카드사용 POST", notes="fetch를 이용하여 POST방식으로 카드사용정보 등록")
	@PostMapping(value = "/ucinfo", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UseCardDTO> register(@RequestBody UseCardDTO ucDTO) {
		
		String after = new AhaCommonMethod().changeDate(ucDTO.getUc_date());
		ucDTO.setUc_date(after);
		
		if(ucDTO==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		int result = ucs.regist(ucDTO);
		if(!(result>0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity update(UseCardDTO ucDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity delete(UseCardDTO ucDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
