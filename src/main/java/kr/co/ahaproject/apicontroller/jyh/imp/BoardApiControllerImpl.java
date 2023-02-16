package kr.co.ahaproject.apicontroller.jyh.imp;

import kr.co.ahaproject.apicontroller.jyh.BoardApiController;
import kr.co.ahaproject.dto.BoardDTO;
import kr.co.ahaproject.entity.Account;
import kr.co.ahaproject.service.jyh.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class BoardApiControllerImpl implements BoardApiController {

    private final BoardService boardService;



    @Override
    @PostMapping("/board")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO dto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated()){
            Account account = (Account) authentication.getPrincipal();
            log.info(account.toString());
            dto.setAc_id(account.getAc_id());
        }

        int result = boardService.create(dto);


        if (result == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/board")
    public ResponseEntity<BoardDTO> update(@RequestBody BoardDTO dto) {
        System.out.println(dto.getB_id());
        int result = boardService.update(dto);
        System.out.println(String.valueOf(result));
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping("/board")
    public ResponseEntity<BoardDTO> delete(@RequestBody BoardDTO dto) {
        int b_id = dto.getB_id();
        int result = boardService.delete(b_id);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
