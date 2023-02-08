package kr.co.ahaproject.service.kjs.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ahaproject.dto.ClientDTO;
import kr.co.ahaproject.dto.MisuDTO;
import kr.co.ahaproject.entity.Client;
import kr.co.ahaproject.entity.Misu;
import kr.co.ahaproject.mapper.kjs.ClientMapper;
import kr.co.ahaproject.service.kjs.ClientService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImp implements ClientService {
	
	@Autowired
	private ClientMapper cm;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public int register(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		 int result = cm.register(modelMapper.map(clientDTO, Client.class));

	        if (!(result > 0)) {
	            return 0;
	        }

	        return 1;
	}

	@Override
	public List<ClientDTO> selectAll() {
		// TODO Auto-generated method stub
		 List<Client> clientList = cm.selectAll();

	        return clientList.stream()
	                .map(client -> modelMapper.map(client, ClientDTO.class))
	                .collect(Collectors.toList());
	}

	@Override
	public ClientDTO findById(ClientDTO clientDTO) {
		// TODO Auto-generated method stub

        Client client = cm.findById(modelMapper.map(clientDTO, Client.class));
        return modelMapper.map(client, ClientDTO.class);
	}



	@Override
	public int update(ClientDTO clientDTO) {
		// TODO Auto-generated method stub
		 Client client = modelMapper.map(clientDTO, Client.class);
	        int update = cm.update(client);

	        if(!(update>0)){
	            return 0;
	        }
	        
        return update;
	}
	
	


}
