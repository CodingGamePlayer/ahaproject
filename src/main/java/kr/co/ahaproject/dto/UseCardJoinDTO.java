package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UseCardJoinDTO {
	private long uc_id;
	private int card_id;
	private String card_name;
	private String card_class;
	private String card_type;
	private String card_endnum;
	private long uc_money;
	private String uc_where;
	private String uc_date;
	private String uc_etc;


}
