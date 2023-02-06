package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estimate {

    Long es_id;
    String es_title;
    String es_body;
    String es_file;
    String es_date;
    int us_id;
}
