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

    int january;
    int february;
    int march;
    int april;
    int may;
    int june;
    int july;
    int august;
    int september;
    int october;
    int november;
    int december;

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
    }


}
