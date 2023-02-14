package kr.co.ahaproject.service.kjs;

import java.util.List;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.PageRequestDTO;
import kr.co.ahaproject.dto.PageResponseDTO;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.entity.Misu;

public interface ClientService {

	   int register(ClientDTO clientDTO);

	    List<ClientDTO> selectAll();

	    ClientDTO findById(ClientDTO clientDTO);

	    int update(ClientDTO clientDTO);
	    
	    int delete(ClientDTO clientDTO);
	    
	    int maxNum();

		PageResponseDTO<ClientDTO> selectAllForPaging(PageRequestDTO pageRequestDTO);
	    
}
