package kr.co.ahaproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    Long emp_id;
    String cp_name;
    String emp_code;

    String emp_name;
    String emp_joining;
    String emp_regid;
    String emp_tel;
    String emp_email;
    String emp_address;
    String emp_account;
    String emp_file;
    String emp_etc1;
    String emp_etc2;
    String emp_etc3;
}
