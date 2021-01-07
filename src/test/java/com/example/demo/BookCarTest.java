package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookCarTest {
    @Autowired
    private BookCarController bookCarController;
    @Test
    public void check_BMW_1(){
        String inputBrand = "BMW";
        Integer inputCount = 1;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("1".equals(CommonResponseBean.getReturnStatus()));
    }
    @Test
    public void check_BMW_2(){
        String inputBrand = "BMW";
        Integer inputCount = 2;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("1".equals(CommonResponseBean.getReturnStatus()));
    }
    @Test
    public void check_BMW_3(){
        String inputBrand = "BMW";
        Integer inputCount = 3;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("0".equals(CommonResponseBean.getReturnStatus()));
    }
    @Test
    public void check_Toyota_1(){
        String inputBrand = "Toyota";
        Integer inputCount = 1;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("1".equals(CommonResponseBean.getReturnStatus()));
    }
    @Test
    public void check_Toyota_2(){
        String inputBrand = "Toyota";
        Integer inputCount = 2;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("1".equals(CommonResponseBean.getReturnStatus()));
    }
    @Test
    public void check_Toyota_3(){
        String inputBrand = "Toyota";
        Integer inputCount = 3;
        CommonResponseBean CommonResponseBean = bookCarController.bookCarAction(inputBrand, inputCount);
        assertTrue("0".equals(CommonResponseBean.getReturnStatus()));
    }
}
