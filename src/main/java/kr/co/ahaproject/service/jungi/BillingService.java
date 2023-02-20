package kr.co.ahaproject.service.jungi;

import kr.co.ahaproject.dto.*;

import java.util.List;

public interface BillingService {

    int register(BillingDTO billingDTO);

    BillingResponseDTO findById(BillingDTO billingDTO);

    int update(BillingDTO billingDTO);

    int delete(BillingDTO billingDTO);

    PageResponseDTO<BillingResponseDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
}
