package kr.co.ahaproject.apicontroller.kjs.imp;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import kr.co.ahaproject.apicontroller.kjs.UpDownController;
import kr.co.ahaproject.dto.UploadFileDTO;
import kr.co.ahaproject.dto.UploadResultDTO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@RestController
public class UpDownControllerImp implements UpDownController {

    @Value("${kr.co.ahaproject.upload.path}")
    private String uploadPath;

    @Override
    @Operation(summary = "Upload post", description = "파일업로드 하는 메소드")
    @PostMapping(value = "/user/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(UploadFileDTO uploadFileDTO) {

        log.info(String.valueOf(uploadFileDTO));

        if(uploadFileDTO.getFiles() != null){

            final List<UploadResultDTO> list = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {

                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);

                String uuid = UUID.randomUUID().toString();

                Path savePath = Paths.get(uploadPath, uuid + "_" + originalName);

                boolean image = false;

                try {
                    multipartFile.transferTo(savePath);

                    if(Files.probeContentType(savePath).startsWith("image")){

                        image = true;

                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalName);

                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 700, 600);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .img(image).build()
                );

            }); //end each

            return list;
        } // end if
        return null;
    }

    @Override
    @ApiOperation(value = "view 파일", notes = "Get방식으로 첨부파일 조회")
    @GetMapping("/user/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName) {

        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try {
            headers.add("Content-Type", Files.probeContentType( resource.getFile().toPath() ));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @Override
    @ApiOperation(value = "remove 파일", notes = "DELETE 방식으로 파일 삭제")
    @DeleteMapping("/user/remove/{fileName}")
    public Map<String, Boolean> removeFile(@PathVariable String fileName) {

        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();

        Map<String, Boolean> resultMap = new HashMap<>();

        boolean removed = false;

        try {
            String contentType = Files.probeContentType(resource.getFile().toPath());
            removed = resource.getFile().delete();

            if(contentType.startsWith("image")){
                File thumbnailFile = new File (uploadPath + File.separator + "s_" + fileName);

                thumbnailFile.delete();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        resultMap.put("result", removed);

        return resultMap;
    }
}
