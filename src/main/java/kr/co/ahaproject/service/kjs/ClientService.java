package kr.co.ahaproject.service.kjs;

import java.util.List;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.entity.Client;

public interface ClientService {

	   int register(ClientDTO clientDTO);

	    List<ClientDTO> selectAll();

	    ClientDTO findById(ClientDTO clientDTO);

	    int update(ClientDTO clientDTO);
}
