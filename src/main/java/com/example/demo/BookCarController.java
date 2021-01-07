package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class BookCarController {

    private static Car[] cars = new Car[4];
    static{
        cars[0] = new Car("BMW","01","0");
        cars[1] = new Car("BMW","02","0");
        cars[2] = new Car("Toyota","01","0");
        cars[3] = new Car("Toyota","02","0");
    }

    @GetMapping("/cars")
    public  CommonResponseBean bookCarAction(@PathVariable(value="inputBrand",required=false) String inputBrand, @PathVariable(value="inputCount",required=false) Integer inputCount){
        CommonResponseBean commonResponseBean = new CommonResponseBean();
        System.out.println("欢迎来到XXX租赁公司");
        Boolean bookResult = checkBookResult(inputBrand,inputCount);
        if(bookResult){
            commonResponseBean.setReturnStr("预约成功");
            commonResponseBean.setReturnStatus("1");
        }else{
            commonResponseBean.setReturnStr("预约失败");
            commonResponseBean.setReturnStatus("0");
        }
        return commonResponseBean;
    }


    private Boolean checkBookResult(String brand, Integer count){
        Boolean bookResult = true;
        Map<String, List<Car>> carMap = getCarMap(cars);
        List<Car> BMWList = carMap.get("BMWList");
        List<Car> ToyotaList = carMap.get("ToyotaList");

        if(brand.equals("BMW")){
            if(BMWList.size() >0 && count <= BMWList.size()){
                bookResult = true;
            }else{
                bookResult = false;
            }
        }else if(brand.equals("Toyota")){
            if(ToyotaList.size() >0 && count <= ToyotaList.size()){
                bookResult = true;
            }else{
                bookResult = false;
            }
        }else{
            bookResult = false;
        }
            return bookResult;
    }
    private Map<String, List<Car>> getCarMap(Car[] cars){
        List<Car> carList = Arrays.asList(cars);
        List<Car> BMWList = new ArrayList<Car>();
        List<Car> ToyotaList = new ArrayList<Car>();
        Map<String, List<Car>> carMap = new HashMap<String, List<Car>>();
        for(Car car : carList){
            String bookState= car.getBookState();
            if(bookState.equals("1")){
                carList.remove(car);
            }
        }
        for(Car car : carList){
            String carBrand = car.getBrand();
            if(carBrand != null && carBrand.equals("BMW")){
                BMWList.add(car);
            }
            if(carBrand != null && carBrand.equals("Toyota")){
                ToyotaList.add(car);
            }
        }
        carMap.put("BMWList", BMWList);
        carMap.put("ToyotaList", ToyotaList);
        return carMap;
    }

}
