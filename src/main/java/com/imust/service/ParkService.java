package com.imust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imust.entity.Park;
import com.imust.mapper.ParkMapper;

@Service
public class ParkService {
	
	@Autowired
	private ParkMapper parkMapper;
	
	//获取全部
	public List<Park> getAll() {
		// TODO Auto-generated method stub
		return parkMapper.findAllPark();
	}
	
	public List<Park> getAllByKey(int status) {
		// TODO Auto-generated method stub
		return parkMapper.findAllParkByKey(status);
	}
	
	public List<Park> getByKey(String key) {
		// TODO Auto-generated method stub
		return parkMapper.findParkByKey("%"+key+"%");
	}
	//查询
	public Park getById(int id) {
		return parkMapper.findCarById(id);
	}
	//通过id修改
	public boolean updateCar(Park car) {
		try {
			parkMapper.updateCar(car);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean updateCarStatus(Park car) {
		try {
			parkMapper.updateCarStatus(car);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	//删除
	public boolean delCar(int id) {
		try {
			parkMapper.deleteCar(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	//添加
	public boolean addCar(Park car) {
		try {
			parkMapper.insertCar(car);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
