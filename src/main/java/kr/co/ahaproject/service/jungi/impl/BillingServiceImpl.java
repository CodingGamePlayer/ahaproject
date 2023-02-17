package kr.co.ahaproject.service.jungi.impl;

import kr.co.ahaproject.dto.BillingDTO;
import kr.co.ahaproject.dto.BillingResponseDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Billing;
import kr.co.ahaproject.mapper.jungi.BillingMapper;
import kr.co.ahaproject.service.AhaCommonMethod;
import kr.co.ahaproject.service.jungi.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {


    private BillingMapper billingMapper;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public int register(BillingDTO billingDTO) {

        String bl_collect_date = new AhaCommonMethod().changeDate(billingDTO.getBl_collect_date());
        String bl_work_date = new AhaCommonMethod().changeDate(billingDTO.getBl_work_date());
        String bl_pub_date = new AhaCommonMethod().changeDate(billingDTO.getBl_pub_date());
        billingDTO.setBl_collect_date(bl_collect_date);
        billingDTO.setBl_work_date(bl_work_date);
        billingDTO.setBl_pub_date(bl_pub_date);

        return billingMapper.register(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public BillingResponseDTO findById(BillingDTO billingDTO) {
        return billingMapper.findById(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public int update(BillingDTO billingDTO) {

        String bl_collect_date = new AhaCommonMethod().changeDate(billingDTO.getBl_collect_date());
        String bl_work_date = new AhaCommonMethod().changeDate(billingDTO.getBl_work_date());
        String bl_pub_date = new AhaCommonMethod().changeDate(billingDTO.getBl_pub_date());
        billingDTO.setBl_collect_date(bl_collect_date);
        billingDTO.setBl_work_date(bl_work_date);
        billingDTO.setBl_pub_date(bl_pub_date);


        return billingMapper.update(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public int delete(BillingDTO billingDTO) {
        return billingMapper.delete(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public PageResponseDTO<BillingResponseDTO> selectAllForPaging(PageRequestDTO pageRequestDTO) {
        List<BillingResponseDTO> billingResponseDTOs = billingMapper.selectAllForPaging(pageRequestDTO);

        int count = billingMapper.getCount(pageRequestDTO);

        PageResponseDTO<BillingResponseDTO> pageResponseDTO = PageResponseDTO.<BillingResponseDTO>withAll()
                .total(count)
                .dtoList(billingResponseDTOs)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Autowired
    public BillingServiceImpl(BillingMapper billingMapper) {
        this.billingMapper = billingMapper;
    }
}
