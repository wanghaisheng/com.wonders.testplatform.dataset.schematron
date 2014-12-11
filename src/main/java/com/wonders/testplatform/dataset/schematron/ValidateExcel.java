package com.wonders.testplatform.dataset.schematron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class ValidateExcel {
	/**
	 * 利用汉王ocr将pdf转换成word 将word转换成excel 将excel和之前的excel进行逐项比对 记录出错的地方
	 * **/
	private void  readDataSetFromExcel(String inputFile)
			throws IOException {

		InputStream inputWorkbook = null;
		try {
			inputWorkbook = new FileInputStream(inputFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Workbook w;
		try {
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);
			settings.setArrayGrowSize(10000);
			w = Workbook.getWorkbook(inputWorkbook, settings);
//遍历excel中的所有sheet
			
			for(int j=0;j< w.getNumberOfSheets();j++){
				Sheet sheet = w.getSheet(j);
				List<Element> elementList = new ArrayList<Element>();
				String datasetName = sheet.getName();
				Element e = null;
				for (int i = 0; i < sheet.getRows(); i++) {
					System.out.println(datasetName+"第"+i+"行");
					Cell cell = sheet.getCell(1, i);
					String dataElementInternalID = cell.getContents().trim();
					Cell cell2 = sheet.getCell(2, i);
					String dataElementID = cell2.getContents().trim();

					Cell cell3 = sheet.getCell(3, i);
					String dataElementName = cell3.getContents().trim();

					Cell cell4 = sheet.getCell(4, i);
					String dataElementDefinition = cell4.getContents().trim();

					Cell cell5 = sheet.getCell(5, i);
					String dataElementDatatype = cell5.getContents().trim();

					Cell cell6 = sheet.getCell(6, i);
					String dataElementFormat = cell6.getContents().trim();

					Cell cell7 = sheet.getCell(7, i);
					String dataElementAllowableValue = cell7.getContents().trim();
					
					String src = "WS369-375卫生信息基本数据集";


					if(dataElementInternalID ==null  || dataElementInternalID.length() <= 0){
						dataElementInternalID = "empty";
					}
					if(dataElementID ==null   || dataElementID.length() <= 0){
						dataElementID = "empty";
					}
					if(dataElementName ==null  || dataElementName.length() <= 0){
						dataElementName = "empty";
					}
					if(dataElementDefinition ==null  || dataElementDefinition.length() <= 0){
						dataElementDefinition = "empty";
					}
					if(dataElementDatatype ==null  || dataElementDatatype.length() <= 0){
						dataElementDatatype = "empty";
					}
					if(dataElementFormat ==null  || dataElementFormat.length() <= 0){
						dataElementFormat = "empty";
					}
					if(dataElementAllowableValue ==null  || dataElementAllowableValue.length() <= 0){
						dataElementAllowableValue = "empty";
					}
					System.out.println(dataElementInternalID);

					Element dataElement = new Element(dataElementInternalID);

					dataElement.setAttribute("内部标识符", dataElementInternalID);
					dataElement.setAttribute("数据元标识符", dataElementID);
					dataElement.setAttribute("数据元名称", dataElementName);
					dataElement.setAttribute("数据元定义", dataElementDefinition);
					dataElement.setAttribute("数据类型", dataElementDatatype);
					dataElement.setAttribute("表示格式", dataElementFormat);
					dataElement.setAttribute("允许值", dataElementAllowableValue);
					dataElement.setAttribute("来源", src);

					elementList.add(dataElement);
				}
				this.CreateXMLDataSet(datasetName, elementList);
				
			}
			// Get the first sheet
		
			
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}
	private void  readDataSetFromExcelIntoOne(String inputFile)
			throws IOException {

		InputStream inputWorkbook = null;
		try {
			inputWorkbook = new FileInputStream(inputFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Workbook w;
		try {
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);
			settings.setArrayGrowSize(10000);
			w = Workbook.getWorkbook(inputWorkbook, settings);
//遍历excel中的所有sheet
			List<Element> elementList = new ArrayList<Element>();

			for(int j=0;j< w.getNumberOfSheets();j++){
				Sheet sheet = w.getSheet(j);
				String datasetName = sheet.getName();
				Element e = null;
				for (int i = 0; i < sheet.getRows(); i++) {
					System.out.println(datasetName+"第"+i+"行");
					Cell cell = sheet.getCell(1, i);
					String dataElementInternalID = cell.getContents().trim();
					Cell cell2 = sheet.getCell(2, i);
					String dataElementID = cell2.getContents().trim();

					Cell cell3 = sheet.getCell(3, i);
					String dataElementName = cell3.getContents().trim();

					Cell cell4 = sheet.getCell(4, i);
					String dataElementDefinition = cell4.getContents().trim();

					Cell cell5 = sheet.getCell(5, i);
					String dataElementDatatype = cell5.getContents().trim();

					Cell cell6 = sheet.getCell(6, i);
					String dataElementFormat = cell6.getContents().trim();

					Cell cell7 = sheet.getCell(7, i);
					String dataElementAllowableValue = cell7.getContents().trim();
					
					String src = "WS365城乡居民健康档案基本数据集";


					if(dataElementInternalID ==null  || dataElementInternalID.length() <= 0){
						dataElementInternalID = "empty";
					}
					if(dataElementID ==null   || dataElementID.length() <= 0){
						dataElementID = "empty";
					}
					if(dataElementName ==null  || dataElementName.length() <= 0){
						dataElementName = "empty";
					}
					if(dataElementDefinition ==null  || dataElementDefinition.length() <= 0){
						dataElementDefinition = "empty";
					}
					if(dataElementDatatype ==null  || dataElementDatatype.length() <= 0){
						dataElementDatatype = "empty";
					}
					if(dataElementFormat ==null  || dataElementFormat.length() <= 0){
						dataElementFormat = "empty";
					}
					if(dataElementAllowableValue ==null  || dataElementAllowableValue.length() <= 0){
						dataElementAllowableValue = "empty";
					}
					System.out.println(dataElementInternalID);

					Element dataElement = new Element(dataElementInternalID);

					dataElement.setAttribute("内部标识符", dataElementInternalID);
					dataElement.setAttribute("数据元标识符", dataElementID);
					dataElement.setAttribute("数据元名称", dataElementName);
					dataElement.setAttribute("数据元定义", dataElementDefinition);
					dataElement.setAttribute("数据类型", dataElementDatatype);
					dataElement.setAttribute("表示格式", dataElementFormat);
					dataElement.setAttribute("允许值", dataElementAllowableValue);
					dataElement.setAttribute("来源", src);

					elementList.add(dataElement);
				}
				
			}
			this.CreateXMLDataSet("总体数据集", elementList);
		
			
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}
	private void CreateXMLDataSet(String datasetName,List<Element> elementList) {
		try {
			Document doc = new Document(); // 生成Document对象。必须的。
			// ProcessingInstruction pi=new
			// ProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"test.xsl\"");
			// doc.addContent(pi);

			Namespace ns1 = Namespace.getNamespace("xsi",
					"http://www.w3.org/2001/XMLSchema-instance");

			Element root = new Element("datasetName"); // 根元素及其所有子标签都是Element型的对象表示。
			root.addNamespaceDeclaration(ns1); // 给根元素添加命名空间

			doc.setRootElement(root); // 将根源素加入Document对象

			// 引入excel中的数据
			for (int i = 1; i < elementList.size(); i++) {

				root.addContent(elementList.get(i));

			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(datasetName+"数据集"+".xml"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void  readDataElementCatalogFromExcel(String inputFile)
			throws IOException {

		InputStream inputWorkbook = null;
		try {
			inputWorkbook = new FileInputStream(inputFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Workbook w;
		try {
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);
			settings.setArrayGrowSize(10000);
			w = Workbook.getWorkbook(inputWorkbook, settings);
//遍历excel中的所有sheet
			
			for(int j=0;j< w.getNumberOfSheets();j++){
				Sheet sheet = w.getSheet(j);
				List<Element> elementList = new ArrayList<Element>();
				String dataElementCatalogName = sheet.getName();
				Element e = null;
				for (int i = 0; i < sheet.getRows(); i++) {
					System.out.println(dataElementCatalogName+"第"+i+"行");
					Cell cell2 = sheet.getCell(0, i);
					String dataElementID = cell2.getContents().trim();

					Cell cell3 = sheet.getCell(1, i);
					String dataElementName = cell3.getContents().trim();

					Cell cell4 = sheet.getCell(2, i);
					String dataElementDefinition = cell4.getContents().trim();

					Cell cell5 = sheet.getCell(3, i);
					String dataElementDatatype = cell5.getContents().trim();

					Cell cell6 = sheet.getCell(4, i);
					String dataElementFormat = cell6.getContents().trim();

					Cell cell7 = sheet.getCell(5, i);
					String dataElementAllowableValue = cell7.getContents().trim();


					if(dataElementID ==null   || dataElementID.length() <= 0){
						dataElementID = "empty";
					}
					if(dataElementName ==null  || dataElementName.length() <= 0){
						dataElementName = "empty";
					}
					if(dataElementDefinition ==null  || dataElementDefinition.length() <= 0){
						dataElementDefinition = "empty";
					}
					if(dataElementDatatype ==null  || dataElementDatatype.length() <= 0){
						dataElementDatatype = "empty";
					}
					if(dataElementFormat ==null  || dataElementFormat.length() <= 0){
						dataElementFormat = "empty";
					}
					if(dataElementAllowableValue ==null  || dataElementAllowableValue.length() <= 0){
						dataElementAllowableValue = "empty";
					}
					System.out.println(dataElementID);

					Element dataElement = new Element(dataElementID);

					dataElement.setAttribute("数据元标识符", dataElementID);
					dataElement.setAttribute("数据元名称", dataElementName);
					dataElement.setAttribute("数据元定义", dataElementDefinition);
					dataElement.setAttribute("数据类型", dataElementDatatype);
					dataElement.setAttribute("表示格式", dataElementFormat);
					dataElement.setAttribute("允许值", dataElementAllowableValue);

					elementList.add(dataElement);
				}
				this.CreateXMLDataElementCatalog(dataElementCatalogName, elementList);
				
			}
			// Get the first sheet
		
			
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}
	private void  readDataElementCatalogIntoSingleFileFromExcel(String inputFile)
			throws IOException {

		InputStream inputWorkbook = null;
		try {
			inputWorkbook = new FileInputStream(inputFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Workbook w;
		try {
			WorkbookSettings settings = new WorkbookSettings();
			settings.setWriteAccess(null);
			settings.setArrayGrowSize(10000);
			w = Workbook.getWorkbook(inputWorkbook, settings);
//遍历excel中的所有sheet
			List<Element> elementListAll = new ArrayList<Element>();

			for(int j=0;j< w.getNumberOfSheets();j++){
				Sheet sheet = w.getSheet(j);
				List<Element> elementList = new ArrayList<Element>();
				String dataElementCatalogName = sheet.getName();
				Element e = null;
				for (int i = 0; i < sheet.getRows(); i++) {
					System.out.println(dataElementCatalogName+"第"+i+"行");
					Cell cell2 = sheet.getCell(0, i);
					String dataElementID = cell2.getContents().trim();

					Cell cell3 = sheet.getCell(1, i);
					String dataElementName = cell3.getContents().trim();

					Cell cell4 = sheet.getCell(2, i);
					String dataElementDefinition = cell4.getContents().trim();

					Cell cell5 = sheet.getCell(3, i);
					String dataElementDatatype = cell5.getContents().trim();

					Cell cell6 = sheet.getCell(4, i);
					String dataElementFormat = cell6.getContents().trim();

					Cell cell7 = sheet.getCell(5, i);
					String dataElementAllowableValue = cell7.getContents().trim();
					
					Cell cell8 = sheet.getCell(6, i);
					String dataElementsrc = cell8.getContents().trim();

					if(dataElementID ==null   || dataElementID.length() <= 0){
						dataElementID = "empty";
					}
					if(dataElementName ==null  || dataElementName.length() <= 0){
						dataElementName = "empty";
					}
					if(dataElementDefinition ==null  || dataElementDefinition.length() <= 0){
						dataElementDefinition = "empty";
					}
					if(dataElementDatatype ==null  || dataElementDatatype.length() <= 0){
						dataElementDatatype = "empty";
					}
					if(dataElementFormat ==null  || dataElementFormat.length() <= 0){
						dataElementFormat = "empty";
					}
					if(dataElementAllowableValue ==null  || dataElementAllowableValue.length() <= 0){
						dataElementAllowableValue = "empty";
					}
					System.out.println(dataElementID);


//					elementList.add(dataElement);
					if(dataElementsrc.contains("卫生信息数据元")){


					}else{
						dataElementID = "empty";
						dataElementName = "empty";
						dataElementDefinition = "empty";
						dataElementDatatype = "empty";
						dataElementFormat = "empty";
						dataElementAllowableValue = "empty";
					}

					Element dataElement = new Element(dataElementID);

					dataElement.setAttribute("数据元标识符", dataElementID);
					dataElement.setAttribute("数据元名称", dataElementName);
					dataElement.setAttribute("数据元定义", dataElementDefinition);
					dataElement.setAttribute("数据类型", dataElementDatatype);
					dataElement.setAttribute("表示格式", dataElementFormat);
					dataElement.setAttribute("允许值", dataElementAllowableValue);
					elementListAll.add(dataElement);

				}
//				this.CreateXMLDataElementCatalog(dataElementCatalogName, elementList);
				
			}
			// Get the first sheet
			this.CreateXMLDataElementCatalog("总体数据元", elementListAll);
	
			
		} catch (BiffException e) {
			e.printStackTrace();
		}

	}	
	private void CreateXMLDataElementCatalog(String dataElementCatalogName,List<Element> elementList) {
		try {
			Document doc = new Document(); // 生成Document对象。必须的。
			// ProcessingInstruction pi=new
			// ProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"test.xsl\"");
			// doc.addContent(pi);

			Namespace ns1 = Namespace.getNamespace("xsi",
					"http://www.w3.org/2001/XMLSchema-instance");

			Element root = new Element("dataElementCatalog"); // 根元素及其所有子标签都是Element型的对象表示。
			root.addNamespaceDeclaration(ns1); // 给根元素添加命名空间

			doc.setRootElement(root); // 将根源素加入Document对象

			// 引入excel中的数据
			for (int i = 1; i < elementList.size(); i++) {
				if(elementList.get(i).getName()=="empty"){
					
				}else{
					root.addContent(elementList.get(i));

				}


			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(dataElementCatalogName+"数据元目录new"+".xml"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		ValidateExcel t = new ValidateExcel();
		try {
//			t.readDataSetFromExcel("WS369-375卫生信息基本数据集.xls");
//			t.readDataSetFromExcelIntoOne("WS365城乡居民健康档案基本数据集.xls");
			t.readDataElementCatalogFromExcel("卫生信息数据元目录.xls");
//			t.readDataElementCatalogIntoSingleFileFromExcel("new.xls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
