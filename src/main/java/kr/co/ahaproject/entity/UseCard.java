package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UseCard {
    Long uc_id;
    int card_id;
    Long uc_money;
    String uc_where;
    String uc_date;
    String uc_etc;
}
