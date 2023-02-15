package kr.co.ahaproject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChartDTOTest {

    String type;

    String year;
    public ChartDTOTest (String type, String year)
    { this.type = type; this.year = year;}
    long january = 0;
    long february = 0;
    long march = 0;
    long april = 0;
    long may = 0;
    long june = 0;
    long july = 0;
    long august = 0;
    long september = 0;
    long october = 0;
    long november = 0;
    long december = 0;

    long total;

    public void chart (String month, Long value){
        switch (month) {
            case "01" : january += value; break;
            case "02" : february += value;break;
            case "03" : march += value; break;
            case "04" : april += value; break;
            case "05" : may += value; break;
            case "06" : june += value; break;
            case "07" : july += value; break;
            case "08" : august += value; break;
            case "09" : september += value; break;
            case "10" : october += value; break;
            case "11" : november += value; break;
            case "12" : december += value; break;

        }
    }
}
