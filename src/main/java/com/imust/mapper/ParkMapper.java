package com.imust.mapper;

import com.imust.entity.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ParkMapper {
	

	@Select("select * from Park")
	List<Park> findAllPark();
	
	@Select("select * from Park where  status = #{status}")
	List<Park> findAllParkByKey(@Param("status") int status);
	
	@Select("select * from Park where  name like #{key}")
	List<Park> findParkByKey(@Param("key") String key);
	
	@Select("select * from Park where id=#{id}")
	Park findCarById(@Param("id") int id);
	
	//添加信息
	@Insert("insert into Park(name,price,status, address, addressLat,addressLon) values(#{name},#{price},0,#{address},#{addressLat},#{addressLon})")
    public void insertCar(Park car);
	
	//删除信息
	@Delete("delete from Car where id=#{id}")
	public void deleteCar(int id);
	
	@Update("update Park set status=#{status} where id=#{id}")
	public void updateCarStatus(Park car);
	
	//修改信息
	@Update("update Park set name=#{name},price=#{price} where id=#{id}")
	public void updateCar(Park car);
}
