package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {

    String title;
    String start;
    String end;
    final String textColor = "black";
    final boolean allDay = true;



    public CalendarDTO convert(MachRentListDTO machRentListDTO){

        CalendarDTO calendarDTO = new CalendarDTO();

        calendarDTO.setTitle(machRentListDTO.getCst_name() + "-" + machRentListDTO.getM_name() + "(" + machRentListDTO.getM_kind() + ")");
        calendarDTO.setStart(machRentListDTO.getRent_start());
        calendarDTO.setEnd(machRentListDTO.getRent_end());

        return calendarDTO;
    }

}
