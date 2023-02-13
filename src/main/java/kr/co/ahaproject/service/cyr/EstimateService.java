package kr.co.ahaproject.service.cyr;


import kr.co.ahaproject.entity.Estimate;

import java.util.List;

public interface EstimateService {

    List<Estimate> listAll();
    Estimate selectOne(int es_id);
    int selectid();
    int insert(Estimate estimate);
    int update(Estimate estimate);
    int delete(int es_id);
    int count();

}
