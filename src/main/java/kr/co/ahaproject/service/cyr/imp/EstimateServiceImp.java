package kr.co.ahaproject.service.cyr.imp;

import kr.co.ahaproject.entity.Estimate;
import kr.co.ahaproject.mapper.cyr.EstimateMapper;
import kr.co.ahaproject.service.cyr.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstimateServiceImp implements EstimateService {

    @Autowired
    private EstimateMapper estimateMapper;

    @Override
    public List<Estimate> listAll() {
        return estimateMapper.listAll();
    }

    @Override
    public Estimate selectOne(int es_id) {
        return estimateMapper.selectOne(es_id);
    }

    @Override
    public int selectid() {
        return estimateMapper.selectid();
    }

    @Override
    public int insert(Estimate estimate) {
        return estimateMapper.insert(estimate);
    }

    @Override
    public int update(Estimate estimate) {
        return estimateMapper.update(estimate);
    }

    @Override
    public int delete(int es_id) {
        return estimateMapper.delete(es_id);
    }

    @Override
    public int count() {
        return estimateMapper.count();
    }
}
