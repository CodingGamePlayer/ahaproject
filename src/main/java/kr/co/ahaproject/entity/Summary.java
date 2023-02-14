package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Result;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summary {

    String cp_name;
    String cl_code;
    String cst_code;
    Long out_supp_value;
    Long out_collect_value;
    Long  out_collect_remain;
    Long  in_supp_value;
    Long  in_collect_value;
    Long in_collect_remain;
}
