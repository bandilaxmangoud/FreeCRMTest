package com.crm.qa.testdata;

public class ReadExcelDataUsingUtilClass {

	public static void main(String[] args) throws Exception {
		ExcelApiTest eat = new ExcelApiTest("D:\\WORK\\PageObjectModel-master\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");        
        System.out.println(eat.getCellData("Credentials","UserName",2));
        System.out.println(eat.getCellData("Credentials","PassWord",2));
        System.out.println(eat.getCellData("Credentials","DateCreated",2));
        System.out.println(eat.getCellData("Credentials","NoOfAttempts",2));
	}

}
