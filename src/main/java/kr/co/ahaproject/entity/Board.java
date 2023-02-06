package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    int b_id;
    int ct_id;
    int us_id;
    String b_title;
    String b_body;
    String b_etc;
    String b_file;
}
