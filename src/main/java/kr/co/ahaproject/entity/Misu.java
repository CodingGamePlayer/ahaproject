package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Misu {

    int misu_id;
    String misu_div;
    String cp_name;
    String cst_code;
    String misu_manager;
    Long misu_value;
    String misu_name;
    Long misu_total_value;
    String misu_collect_date;
    Long misu_collect_value;
    Boolean misu_finished;
    String misu_uuid;
    String misu_filename;
    String misu_etc;
    boolean misu_black;

}
