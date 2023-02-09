package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    int mt_id;
    String mt_code;
    String mt_name;
    String mt_standard;
    Long mt_remain;
    String mt_etc1;
    String mt_etc2;
    String mt_etc3;
    String mt_filename; 
    String mt_uuid;
}
