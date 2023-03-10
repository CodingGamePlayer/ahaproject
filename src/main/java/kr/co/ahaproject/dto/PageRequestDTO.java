package kr.co.ahaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String type;

    private String keyword;

    private String finished;
    
    private int card_id;
    
    private int cst_id;

    // 장비 현황 페이지용
    private String jangbiType;

    private String kind;
    // 아이디 넘버
    private String id;

    private boolean blacklist;

    public int getSkip(){
        return (page -1) * 10;
    }


}
