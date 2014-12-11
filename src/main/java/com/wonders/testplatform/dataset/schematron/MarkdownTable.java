package com.wonders.testplatform.dataset.schematron;

/**
|名称 |订阅地址 | 介绍 |
| ----- | ----- | ------ |

**/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

public class MarkdownTable {

	/**
	 * @param args
	 */
	public void CreateMarkdownTable() {
		try {
			Document doc = new Document(); // 生成Document对象。必须的。
			// ProcessingInstruction pi=new
			// ProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"test.xsl\"");
			// doc.addContent(pi);
			Element root = new Element("table"); // 根元素及其所有子标签都是Element型的对象表示。
			doc.setRootElement(root); // 将根源素加入Document对象
			
			Element line = new Element("line");
						
/*
			line.setText("| 类型 | 目标 | 说明 | 如何使用 | 特性 |");
			Element line1 = new Element("line");
			line1.setText("| ----- | ----- | ----- | ------ | ------ |");*/
			
									
			line.setText("| 工作流 | 阶段 | 任务 | 活动 | 子活动 | 参与角色  | Alerts/Reminders | 	Order sets | 	InfoButtons	 | Data display	 | Documentation templates");
			Element line1 = new Element("line");
			line1.setText(" | ------ | ----- | ----- | ----- | ------ | ------ | ----- | ----- | ----- | ------ | ------ |");

			root.addContent(line);
			root.addContent(line1);

			// 引入excel中的数据

			List<Element> elementList = this
					.readTableFromExcel("Reference-Taxonomy-of-Clinical-Workflows.xls");
			for (int i = 1; i < elementList.size(); i++) {
				root.addContent(elementList.get(i));
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(
					"workflow-patient.md"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Comment addComment(String dataElementID, String dataElementName)
			throws IOException {

		Comment c = new Comment(dataElementID + dataElementName);
		return c;
	}

	private List<Element> readTableFromExcel(String inputFile)
			throws IOException {

		InputStream inputWorkbook = null;
		List<Element> elementList = new ArrayList<Element>();
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

			// Get the first sheet
			Sheet sheet = w.getSheet(4);
			Element e = null;
			for (int i =0 ; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(0, i);
				String workflow = cell.getContents();
				
				Cell cell2 = sheet.getCell(1, i);
				String stage = cell2.getContents();
				stage=stage.replaceAll("[\\t\\n\\r]", "");//将内容区域的回车换行去除 

				Cell cell3 = sheet.getCell(2, i);
				String task = cell3.getContents();
				task=task.replaceAll("[\\t\\n\\r]", "");//将内容区域的回车换行去除 


				Cell cell4 = sheet.getCell(3, i);
				String action = cell4.getContents();

				Cell cell5 = sheet.getCell(4, i);
				String subaction = cell5.getContents();
				subaction=subaction.replaceAll("[\\t\\n\\r]", "");//将内容区域的回车换行去除 
				
				Cell cell6= sheet.getCell(5, i);
				String roles = cell6.getContents();
				
				Cell cell7 = sheet.getCell(6, i);
				String alerts = cell7.getContents();

				Cell cell8 = sheet.getCell(7, i);
				String ordersets = cell8.getContents();
				

				Cell cell9 = sheet.getCell(8, i);
				String infobutton = cell9.getContents();

				Cell cell10 = sheet.getCell(9, i);
				String datadisplay = cell10.getContents();

				Cell cell11 = sheet.getCell(10, i);
				String documentationtemplate = cell11.getContents();
				
//				e = this.writePatternForDataElementRatio(sourceDocumentID,	sourceExpression, QIDAMExpression);
		//		e = this.writePatternForCDSType(type,target, description, how, feature);
				e =  this.writePatternForCDSInworkFLowPatient(workflow, stage, task, action, subaction, roles, alerts, ordersets, infobutton, datadisplay, documentationtemplate);
				elementList.add(e);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return elementList;
	}
	private Element writePatternForCDSInworkFLowPatient(String workflow,	String stage, String task,
			String action,String subaction, String roles,
			String alerts, String ordersets,
			String infobutton,String datadisplay,String documentationtemplate) throws IOException {

		Element line = new Element("line");
		line.setText("| "+workflow+"| "+stage+" | "+task+" | "+action+" |"+subaction+" |"+"| "+roles+"| "+alerts+" | "+ordersets+" | "+infobutton+" |"+datadisplay+" |"+" |"+documentationtemplate+" |");

		return line;

	}
	private Element writePatternForCDSType(String type,
			String target, String description,
			String how,String feature) throws IOException {

		Element line = new Element("line");
		line.setText("| "+type+"| "+target+" | "+description+" | "+description+" |"+feature+" |");

		return line;

	}

	private Element writePatternForDataElementRatio(
			String sourceDocumentID, String sourceExpression,
			String QIDAMExpression) throws IOException {

		Element line = new Element("line");
		line.setText("| "+sourceDocumentID+" | "+sourceExpression+" | "+QIDAMExpression+" |");

		return line;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarkdownTable test = new MarkdownTable();
		test.CreateMarkdownTable();

	}
}