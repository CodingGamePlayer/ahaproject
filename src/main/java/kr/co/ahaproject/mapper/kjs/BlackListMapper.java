package kr.co.ahaproject.mapper.kjs;

import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.entity.BlackList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlackListMapper {

    List<BlackList> selectAllForPaging(PageRequestDTO pageRequestDTO);

    int update(BlackList blackList);

    int delete(BlackList blackList);

    int insert(BlackList blackList);
}
