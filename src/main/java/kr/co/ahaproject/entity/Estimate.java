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
    String es_code;
    String es_title;
    String es_body;
    String es_uuid;
    String es_filename;
    String es_date;
    String us_id;
    String es_etc1;
    String es_etc2;

}
