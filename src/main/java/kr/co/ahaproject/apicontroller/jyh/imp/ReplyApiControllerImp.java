package kr.co.ahaproject.apicontroller.jyh.imp;


import kr.co.ahaproject.apicontroller.jyh.ReplyApiController;
import kr.co.ahaproject.dto.ReplyDTO;
import kr.co.ahaproject.service.jyh.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class ReplyApiControllerImp implements ReplyApiController {

    private final ReplyService replyService;


    @Override
    @PostMapping("/board/reply")
    public ResponseEntity insert(@RequestBody ReplyDTO replyDTO) {

        int result = replyService.create(replyDTO);

        if(!(result > 0)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping("/board/reply")
    public ResponseEntity delete(@RequestBody ReplyDTO replyDTO) {

        int result = replyService.delete(replyDTO.getRp_id());

        if(!(result > 0)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
