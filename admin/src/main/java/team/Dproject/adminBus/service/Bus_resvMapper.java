package team.Dproject.adminBus.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import team.Dproject.adminBus.model.bus_resvDTO;

@Service
public class Bus_resvMapper {
   
   @Autowired
   private SqlSession sqlSession;
   
   public List<bus_resvDTO> listBus_resv(){
	      return sqlSession.selectList("listBus_resv");
   }
   public int insertBus_resv(bus_resvDTO dto){
	      return sqlSession.insert("insertBus_resv",dto);
   }
   public int deletetBus_resv(String no){
	      return sqlSession.insert("deleteBus_resv",no);
   }
   public bus_resvDTO getBus_resv(String no){
	   return sqlSession.selectOne("getBus_resv",no);
   }
   public int updateBus_resv(bus_resvDTO dto){
	      return sqlSession.insert("updateBus_resv",dto);
   }
    

}