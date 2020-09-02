package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.BusRoadDTO;
import team.Dproject.main.model.Bus_BusRoadDTO;

@Service
public class BusRoadMapper {
	@Autowired
	private SqlSession sqlSession;
	
	 public List<BusRoadDTO> listBus_road(){
	      return sqlSession.selectList("listBus_road");
  }
	 public List<Bus_BusRoadDTO> bus_no_list_null(){//사용중인 bus_no값 제외하고 출력
		 return sqlSession.selectList("bus_no_list_null");
	 }
  public int insertBus_road(BusRoadDTO dto){
	  
	  return sqlSession.insert("insertBus_road",dto);
  }
  public int deletetBus_road(int no){
	      return sqlSession.insert("deleteBus_road",no);
  }
  public BusRoadDTO getBus_road(int no){
	   return sqlSession.selectOne("getBus_road",no);
  }
  public BusRoadDTO getBus_road_plus(BusRoadDTO dto){
	  return sqlSession.selectOne("getBus_road_plus",dto);
  }
  public int updateBus_road(BusRoadDTO dto){
	      return sqlSession.insert("updateBus_road",dto);
  }
}
