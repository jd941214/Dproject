package team.Dproject.main.service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.BusResvDTO;
import team.Dproject.main.model.Bus_BusRoadDTO;

@Service
public class BusResvMapper {
	   @Autowired
	   private SqlSession sqlSession;
	   
	   public List<BusResvDTO> listBus_resv(){
		      return sqlSession.selectList("listBus_resv");
	   }
	   public int insertBus_resv(BusResvDTO dto){
		      return sqlSession.insert("insertBus_resv",dto);
	   }
	   public int deletetBus_resv(String no){
		      return sqlSession.insert("deleteBus_resv",no);
	   }
	   public BusResvDTO getBus_resv(String no){
		   return sqlSession.selectOne("getBus_resv",no);
	   }
	   public int updateBus_resv(BusResvDTO dto){
		      return sqlSession.insert("updateBus_resv",dto);
	   }
	   public List<Bus_BusRoadDTO> listdispatch_resv(int arrival,int departure,String grade){
		   java.util.Map<String,Object> map =new java.util.Hashtable<String,Object>();
		   
		  
		   map.put("arrival",arrival);
		   map.put("departure",departure);
		   map.put("grade",grade);
		   
		   return sqlSession.selectList("listDispatch_resv",map);
	   }
	   

	   
	   public List<Bus_BusRoadDTO> listDispatch_resv_reverse(int arrival,int departure,String grade){
		   java.util.Map<String,Object> map =new java.util.Hashtable<String,Object>();
		   
		   map.put("arrival",arrival);
		   map.put("departure",departure);
		   map.put("grade",grade);
		   
		   return sqlSession.selectList("listDispatch_resv_reverse",map);
	   }
	   
	   public List<Bus_BusRoadDTO> listDispatch_resv_all(int arrival,int departure){
		   java.util.Map<String,Object> map =new java.util.Hashtable<String,Object>();
		   
			  
		   map.put("arrival",arrival);
		   map.put("departure",departure);
		  
		   
		   return sqlSession.selectList("listDispatch_resv_all",map);
	   }
	   
	   public List<Bus_BusRoadDTO> listDispatch_resv_all_reverse(int arrival,int departure){
		   java.util.Map<String,Object> map =new java.util.Hashtable<String,Object>();
		   
			  
		   map.put("arrival",arrival);
		   map.put("departure",departure);
		  
		   
		   return sqlSession.selectList("listDispatch_resv_all_reverse",map);
		   
	   }
	   
	   public Bus_BusRoadDTO resv_user_seat_select(int road_no){
		   
	   return sqlSession.selectOne("resv_user_seat_select",road_no);
	   }
	    
}
