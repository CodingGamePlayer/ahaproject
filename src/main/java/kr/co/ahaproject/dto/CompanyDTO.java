package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    int cp_id;
    String cp_name;
    String cp_num;
    String cp_address;
    String cp_tel;
    String cp_type;
    String cp_head_name;
    String cp_head_id;
    String cp_sector;
    String cp_establish;
    String cp_open;
    String cp_eng_name;
    String cp_eng_address;
    String cp_eng_head_name;
    String cp_domain;
    String cp_uuid;
    String cp_filename;
}
