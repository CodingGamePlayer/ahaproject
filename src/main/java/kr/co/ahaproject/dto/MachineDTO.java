package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineDTO {
    int m_id;
    String m_code;
    String m_name;
    String m_equip_num;
    String m_type;
    Long m_price;
    Long m_tax;
    String m_date;
    String m_file;
    String m_etc1;
    String m_etc2;
    String m_etc3;
}
