package com.jsp.controller;

import com.jsp.dao.CarDao;
import com.jsp.dto.Car;

public class TestSave {

	public static void main(String[] args) {
		
		Car car=new Car();
		
		car.setId(1);
		car.setBrand("Tata");
		car.setPrice(1150);
		car.setColor("Daytona Grey");
		
		CarDao carDao=new CarDao();
		Car c=carDao.saveCar(car);
		System.out.println("Saved Succesfully");
		
	}

}
