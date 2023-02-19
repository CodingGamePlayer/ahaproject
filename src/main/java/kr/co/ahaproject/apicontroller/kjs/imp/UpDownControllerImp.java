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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

                        File thumbFile = new File(uploadPath, uuid + "_" + originalName);

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

    @Override
    @ApiOperation(value = "download 파일", notes = "GET 방식으로 파일 다운")
    @GetMapping(value = "/user/download/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity downloadFile(@PathVariable String fileName, @RequestHeader("User-Agent") String agent) {
        HttpHeaders headers = new HttpHeaders();

        try {
            String originalFileName = URLDecoder.decode(fileName, "UTF-8");

            Resource file = new FileSystemResource(uploadPath + File.separator + originalFileName);

            if(!file.exists())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            String onlyFileName = originalFileName.substring(originalFileName.lastIndexOf("_") + 1);

            if(agent.contains("Trident"))
                onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8").replaceAll("\\+", " ");

            else if (agent.contains("Edge"))
                onlyFileName = URLEncoder.encode(onlyFileName, "UTF-8");

            else
                onlyFileName = new String(onlyFileName.getBytes("UTF-8"), "ISO-8859-1");

            headers.add("Content-Disposition", "attachment; filename=" + onlyFileName);

            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(file);

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
