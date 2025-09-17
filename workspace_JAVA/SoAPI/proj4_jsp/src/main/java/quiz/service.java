package quiz;

import java.util.List;


public class service {
	DAO dAO = new DAO();
	
	public List getAllID(){
		List<DTO> list = dAO.selectAllID();
		return list;
	}
	
	public DTO getID(DTO dTO){
		DTO dto = dAO.selectID(dTO);
		return dto;
	}
	
	
}
