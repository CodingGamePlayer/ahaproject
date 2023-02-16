package kr.co.ahaproject.service.jungi.impl;

import kr.co.ahaproject.dto.*;
import kr.co.ahaproject.entity.Billing;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.mapper.jungi.BillingMapper;
import kr.co.ahaproject.service.jungi.BillingService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {


    private BillingMapper billingMapper;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public int register(BillingDTO billingDTO) {
        return billingMapper.register(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public BillingResponseDTO findById(BillingDTO billingDTO) {
        return billingMapper.findById(modelMapper.map(billingDTO, Billing.class));
    }

    @Override
    public int update(BillingDTO billingDTO) {
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
