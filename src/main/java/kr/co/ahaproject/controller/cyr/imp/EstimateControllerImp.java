package kr.co.ahaproject.controller.cyr.imp;

import kr.co.ahaproject.controller.cyr.EstimateController;
import kr.co.ahaproject.entity.Estimate;
import kr.co.ahaproject.service.cyr.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EstimateControllerImp implements EstimateController {

    @Autowired
    private EstimateService estimateService;

    @GetMapping("user/estimate/esmain")
    public void listAll(Model model){
    System.out.println("견적서 리스트 페이지로 이동합니다.");
    model.addAttribute("list",estimateService.listAll());
    }
    @GetMapping("user/estimate/esform")
    public void create(Model model){
    System.out.println("등록폼 페이지를 새창으로 엽니다.");
    if(estimateService.count() > 0) {
        int id = estimateService.count() + 1;
        String idkey = String.format("%04d",id);
        model.addAttribute("idkey", "ES"+idkey);
    } else {
        String idkey = "0001";
        model.addAttribute("idkey","ES"+idkey);
    }
    }

    @PostMapping("/create")
    public ResponseEntity<Estimate> createdo(@RequestBody Estimate estimate) {
    System.out.println("등록하기");

        int result = estimateService.insert(estimate);
        if (result == 0) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("user/estimate/eseditform")
    public void edit(Model model, Estimate estimate){
        System.out.println("상세/수정폼 페이지를 새창으로 엽니다.");
        int id = estimate.getEs_id().intValue();
        model.addAttribute("eDTO",estimateService.selectOne(id));
        }

    @PutMapping("/update")
    public ResponseEntity editdo(@RequestBody Estimate estimate){
    System.out.println("수정을 합니다");
    int result = estimateService.update(estimate);
    if(result == 1){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/estimate")
    public ResponseEntity deletedo(@RequestBody Estimate estimate){
        System.out.println("삭제합니다.");
        int id = estimate.getEs_id().intValue();
        int result = estimateService.delete(id);
        if(result == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
