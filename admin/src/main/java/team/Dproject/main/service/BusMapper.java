package team.Dproject.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.Dproject.main.model.busDTO;

@Service
public class BusMapper {
   
   @Autowired
   private SqlSession sqlSession;
   
   public List<busDTO> listBus(){
	      return sqlSession.selectList("listBus");
   }
   public int insertBus(busDTO dto){
	      return sqlSession.insert("insertBus",dto);
   }
   public int deletetBus(String no){
	      return sqlSession.delete("deleteBus",no);
   }
   public busDTO getBus(String no){
	   return sqlSession.selectOne("getBus",no);
   }
   public int updateBus(busDTO dto){
	      return sqlSession.update("updateBus",dto);
   }
   

}