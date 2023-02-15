package kr.co.ahaproject.service.jyh.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.ahaproject.dto.CategoryDTO;
import kr.co.ahaproject.mapper.jyh.Categorymapper;
import kr.co.ahaproject.service.jyh.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	Categorymapper categorymapper;
		
	@Override
	public List<CategoryDTO> listAll() {
		// TODO Auto-generated method stub
		return categorymapper.listAll();
	}

	@Override
	public int create(CategoryDTO dto) {
		// TODO Auto-generated method stub
		return categorymapper.Catecreate(dto);
	}

	@Override
	public CategoryDTO SelectOne(int ct_id) {
		// TODO Auto-generated method stub
		return categorymapper.SelectOne(ct_id);
	}

	@Override
	public int update(CategoryDTO dto) {
		// TODO Auto-generated method stub
		return categorymapper.Cateupdate(dto);
	}

	@Override
	public int delete(int ct_id) {
		// TODO Auto-generated method stub
		return categorymapper.Catedelete(ct_id);
	}

}
