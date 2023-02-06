package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    int card_id;
    String cl_code;
    String card_name;
    String card_class;
    String card_type;
    String card_company;
    String card_num;
    String card_endnum;
    String card_exp_date;

}
