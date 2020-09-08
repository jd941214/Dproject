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
	   
	   public int insertBus_resv_user(BusResvDTO dto){//bus_Resv 테이블 insert 후 결제하기 위해
		   java.util.Map<String,Object> map = new java.util.Hashtable<String,Object>();
		   map.put("bus_no",dto.getBus_no());
		   map.put("road_no",dto.getRoad_no());
		   map.put("seat",dto.getSeat());
		   map.put("resv_date",dto.getResv_date());
		   map.put("member_no",dto.getMember_no());
		   
		   return sqlSession.insert("insertBus_resv_user",map);
	   }
	   
	   public List<BusResvDTO> list_seat_resv_user(String resv_date,int road_no){//예약좌석 선택 못하게하기
		   java.util.Map<String,Object> map = new java.util.Hashtable<String,Object>();
		   map.put("resv_date",resv_date);
		   map.put("road_no",road_no);
		   return sqlSession.selectList("list_seat_resv_user",map);
	   }
	    
}
