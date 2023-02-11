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

    public CalendarDTO(String title, String start, String end, String textColor, boolean allDay) {
    }


    public CalendarDTO convert(MachRentDTO machRentDTO){

        CalendarDTO calendarDTO = new CalendarDTO();

        calendarDTO.setTitle(machRentDTO.getCst_name() + "-" + machRentDTO.getM_name());
        calendarDTO.setStart(machRentDTO.getRent_start());
        calendarDTO.setEnd(machRentDTO.getRent_end());

        return calendarDTO;
    }
}
