package kr.co.ahaproject.apicontroller.kjs;

import kr.co.ahaproject.dto.UploadFileDTO;
import kr.co.ahaproject.dto.UploadResultDTO;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface UpDownController {

    List<UploadResultDTO> upload(UploadFileDTO uploadFileDTO);

    ResponseEntity<Resource> viewFileGET(@PathVariable String fileName);

    Map<String, Boolean> removeFile(String fileName);

    ResponseEntity downloadFile(String fileName, String agent);
}
