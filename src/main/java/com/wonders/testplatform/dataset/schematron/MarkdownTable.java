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
			line.setText("| 源文档标识 | 原始表达式 | QIDAM表达式 |");
			Element line1 = new Element("line");
			line1.setText("| ----- | ----- | ------ |");

			root.addContent(line);

			// 引入excel中的数据

			List<Element> elementList = this
					.readTableFromExcel("example.xls");
			for (int i = 1; i < elementList.size(); i++) {
				root.addContent(elementList.get(i));
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(
					"example.md"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
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
			Sheet sheet = w.getSheet(0);
			Element e = null;
			for (int i =1 ; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(0, i);
				String sourceDocumentID = cell.getContents();
				Cell cell2 = sheet.getCell(1, i);
				String sourceExpression = cell2.getContents();

				Cell cell3 = sheet.getCell(2, i);
				String QIDAMExpression = cell3.getContents();

				e = this.writePatternForDataElementRatio(sourceDocumentID,
						sourceExpression, QIDAMExpression);

				elementList.add(e);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return elementList;
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