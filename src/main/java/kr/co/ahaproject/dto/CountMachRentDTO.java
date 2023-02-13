package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CountMachRentDTO {

    String type;

    String year;

    int january = 0;
    int february = 0;
    int march = 0;
    int april = 0;
    int may = 0;
    int june = 0;
    int july = 0;
    int august = 0;
    int september = 0;
    int october = 0;
    int november = 0;
    int december = 0;

    int total;

    public CountMachRentDTO(String year) {
        this.year = year;
    }

    public void increaseCount(String month){
        switch (month){
            case "01" :
                january++;
                break;
            case "02" :
                february++;
                break;
            case "03" :
                march++;
                break;
            case "04" :
                april++;
                break;
            case "05" :
                may++;
                break;
            case "06" :
                june++;
                break;
            case "07" :
                july++;
                break;
            case "08" :
                august++;
                break;
            case "09" :
                september++;
                break;
            case "10" :
                october++;
                break;
            case "11" :
                november++;
                break;
            case "12" :
                december++;
                break;

        }
        sumAll();
    }

    void sumAll () {
        this.total = january + february + march +
                    april + may + june + july +
                    august + september + october +
                    november + december;
    }


}
