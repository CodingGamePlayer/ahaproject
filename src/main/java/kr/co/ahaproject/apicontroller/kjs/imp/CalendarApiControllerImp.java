package kr.co.ahaproject.apicontroller.kjs.imp;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import kr.co.ahaproject.apicontroller.kjs.CalendarApiController;
import kr.co.ahaproject.dto.CalendarDTO;
import kr.co.ahaproject.service.kjs.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class CalendarApiControllerImp implements CalendarApiController {

    private final CalendarService calendarService;

    @Override
    @ApiOperation(value = "달력정보 GET", notes = "GET 방식으로 달력정보 요청")
    @GetMapping(value = "/calendar",produces = "application/json;charset=utf-8")
    public ResponseEntity<String> list() {

        Gson gson = new Gson();

        List<CalendarDTO> calendarDTOS = calendarService.selectAll();
        String jsonList = gson.toJson(calendarDTOS);

        return ResponseEntity.status(HttpStatus.OK).body(jsonList);
    }
}
