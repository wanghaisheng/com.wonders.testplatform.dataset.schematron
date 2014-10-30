package com.wonders.testplatform.dataset.schematron;

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

public class TestJdom {

	/**
	 * @param args
	 */
	public void CreateRatioSch() {
		try {
			Document doc = new Document(); // 生成Document对象。必须的。
			// ProcessingInstruction pi=new
			// ProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"test.xsl\"");
			// doc.addContent(pi);
			Namespace ns = Namespace
					.getNamespace("http://purl.oclc.org/dsdl/schematron");
			Namespace ns4 = Namespace.getNamespace("iso",
					"http://purl.oclc.org/dsdl/schematron");
			Namespace ns5 = Namespace.getNamespace("xi",
					"http://www.w3.org/2003/XInclude");
			Namespace ns6 = Namespace.getNamespace("queryBinding", "xslt2");
			Element root = new Element("schema"); // 根元素及其所有子标签都是Element型的对象表示。
			root.addNamespaceDeclaration(ns4); // 给根元素添加命名空间
			root.addNamespaceDeclaration(ns5); // 给根元素添加命名空间
			root.addNamespaceDeclaration(ns6); // 给根元素添加命名空间
			doc.setRootElement(root); // 将根源素加入Document对象

			Element ns1 = new Element("ns");
			ns1.setAttribute("prefix", "urn:hl7-org:v3"); // 设置元素属性
			Element ns2 = new Element("ns");

			ns2.setAttribute("prefix",
					"http://www.w3.org/2001/XMLSchema-instance"); // 设置元素属性
			Comment c = new Comment("$dataelementid 数据集内数据元标识符");

			Element pattern = new Element("pattern");
			pattern.setAttribute("abstract", "true");
			pattern.setAttribute("id", "check-dataelement-existed");
			Element rule = new Element("rule");

			rule.setAttribute("context", "$context");
			Element assert1 = new Element("assert");
			assert1.setAttribute("test", "count($path) &gt;= 1");
			assert1.setAttribute("role", "$dataelementid");

			Text text1 = new Text(
					"错误:&lt;value-of select=\"\'$dataelementid\'\"/&gt;  &lt;value-of select=\"\'$dataelementname\'\"/&gt;  数据元不存在  ");
			assert1.addContent(text1);
			Element report = new Element("assert");
			report.setAttribute("test", "count($path) &gt;= 1");
			report.setAttribute("role", "$dataelementid");

			Text text2 = new Text(
					"正确:&lt;value-of select=\"\'$dataelementid\'\"/&gt;  &lt;value-of select=\"\'$dataelementname\'\"/&gt;  数据元已存在  ");
			report.addContent(text2);

			rule.addContent(assert1);
			rule.addContent(report);
			pattern.addContent(rule);

			root.addContent(ns1);
			root.addContent(ns2);
			root.addContent(c);
			root.addContent(pattern);

			// 引入excel中的数据

			List<Element> elementList = this
					.readRatioFromExcel("城乡居民健康档案基本数据集.xls");
			for (int i = 1; i < elementList.size(); i++) {
				root.addContent(elementList.get(i));
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(
					"EHR-SD-T-16001-v0.1-datasetRatio.sch"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private Comment addComment(String dataElementID, String dataElementName)
			throws IOException {

		Comment c = new Comment(dataElementID + dataElementName);
		return c;
	}

	private List<Element> readRatioFromExcel(String inputFile)
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
			for (int i = 1; i < sheet.getRows(); i++) {
				Cell cell = sheet.getCell(1, i);
				String dataElementInternalID = cell.getContents();
				Cell cell2 = sheet.getCell(2, i);
				String dataElementID = cell2.getContents();

				Cell cell3 = sheet.getCell(3, i);
				String dataElementName = cell3.getContents();

				e = this.writePatternForDataElementRatio(dataElementInternalID,
						dataElementID, dataElementName, "");

				elementList.add(e);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return elementList;
	}

	private Element writePatternForDataElementRatio(
			String dataElementInternalID, String dataElementID,
			String dataElementName, String xpath) throws IOException {

		Element pattern = new Element("pattern");
		pattern.setAttribute("is-a", "check-dataelement-existed");
		pattern.setAttribute("id", dataElementInternalID);
		Element param1 = new Element("param");
		param1.setAttribute("name", "context");

		param1.setAttribute("value", "/");
		Element param2 = new Element("param");
		// xpath需要手动填充
		param2.setAttribute("name", "xpath");
		param2.setAttribute("value", "/");

		Element param3 = new Element("param");
		param3.setAttribute("name", "dataelementid");

		param3.setAttribute("value", dataElementID);

		Element param4 = new Element("param");
		param4.setAttribute("name", "dataelementname");
		param4.setAttribute("value", dataElementName);

		pattern.addContent(param1);
		pattern.addContent(param2);
		pattern.addContent(param3);
		pattern.addContent(param4);
		return pattern;

	}

	private List<Element> readDataElementAccuracyFromExcel(String inputFile)
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
			for (int i = 2; i < sheet.getRows(); i++) {

				Cell cell_dataElementInternalID = sheet.getCell(1, i);
				String dataElementInternalID = cell_dataElementInternalID
						.getContents();

				Cell cell_dataElementID = sheet.getCell(2, i);
				String dataElementID = cell_dataElementID.getContents();

				Cell cell_dataElementName = sheet.getCell(3, i);
				String dataElementName = cell_dataElementName.getContents();

				Cell cell_datatype = sheet.getCell(5, i);
				String datatype = cell_datatype.getContents();

				Cell cell_format = sheet.getCell(6, i);
				String format = cell_format.getContents();

				String xpath = getXpath(dataElementID);

				String regex = getRegex(datatype, format);
				System.out.println("读取excel第行"+i);
				System.out.println("格式"+format);
				format = format.replace("/", "");
				e = this.writePatternForDataElementAccuracy(
						dataElementInternalID, dataElementID, dataElementName,
						datatype, format, "/", regex);

				elementList.add(e);

			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return elementList;
	}

	private String getRegex(String datatype, String format) {
		String regex = null;
		HashMap<String, String> regex_expressions = new HashMap<String, String>();
		regex_expressions.put("N", "[0-9]");
		regex_expressions.put("A", "[0-9]");
		regex_expressions.put("AN", "[0-9]");
		regex_expressions.put("D8", "[0-9]");
		regex_expressions.put("DT15", "[0-9]");
		regex_expressions.put("T/F", "[0-9]");
		// N..7 N1..7 N7
		if (format.contains("..")) {
			// A AN N
			regex = getWithmaohaoregex(format);
		} else {
			// 所有
			regex = getWithoutmaohaoregex(format);
		}

		return regex;
	}

	private String getWithoutmaohaoregex(String format) {
		String regex = null;

		if (format.contains("A") && !format.contains("N")) {

			regex = "(^\\p{L}{" + Integer.parseInt(format.replace("A", "")) / 2
					+ "}$)|(^[\\p{Ll}-\\p{Lu}]{"
					+ Integer.parseInt(format.replace("A", "")) + "}$)";

		} else if (format.contains("A") && format.contains("N")) {
			regex = "(^\\p{L}{" + Integer.parseInt(format.replace("AN", "")) / 2
					+ "}$)|(^[\\p{Ll}-\\p{Lu}]{"
					+ Integer.parseInt(format.replace("AN", "")) + "}$)";
			regex = regex + "|([0-9]{"
					+ Integer.parseInt(format.replace("AN", "")) + "})";

		} else if (format.contains("N") && !format.contains("A")) {
			regex = "([0-9]{" + Integer.parseInt(format.replace("N", ""))
					+ "})";

		} else if (format.contains("D") && format.contains("T")) {
			regex = "((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))T((([1-9])|([0-1][0-9])|([1-2][0-3]))(([0-5][0-9]))(([0-5][0-9])))";

		} else if (format.contains("D") && !format.contains("T")) {
			regex = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)";

		} else if (format.contains("T") && !format.contains("D") && !format.contains("F")) {
			regex = "";


		} else if (format.contains("T") && format.contains("F")&& !format.contains("D")) {
			
			regex = "(0|1|T|F|False|True)";
			System.out.println("布尔型");
		}

		return regex;
	}

	private String getWithmaohaoregex(String format) {
		String regex = null;

		if (format.contains("A") && !format.contains("N")) {
			System.out.println("数据表示格式为 A");
			format = format.replace("A", "");
			String[] str = this.stringAnalytical(format, "..");
			if (str.length > 1) {
				regex = "(^\\p{L}{" + Integer.parseInt(str[0]) + ","
						+ Integer.parseInt(str[1]) / 2
						+ "}$)|(^[\\p{Ll}-\\p{Lu}]{" + Integer.parseInt(str[0])
						+ "," + Integer.parseInt(str[1]) + "}$)";

			} else {
				regex = "(^\\p{L}{" + 0 + "," + Integer.parseInt(str[0]) / 2
						+ "}$)|(^[\\p{Ll}-\\p{Lu}]{" + 0 + ","
						+ Integer.parseInt(str[0]) + "}$)";
			}
		} else if (format.contains("A") && format.contains("N")) {
			System.out.println("数据表示格式为 AN");

			format = format.replace("AN", "");
			String[] str = this.stringAnalytical(format, "..");
			if (str.length > 1) {
				regex = "(^\\p{L}{" + Integer.parseInt(str[0]) + ","
						+ Integer.parseInt(str[1]) / 2
						+ "}$)|(^[\\p{Ll}-\\p{Lu}]{" + Integer.parseInt(str[0])
						+ "," + Integer.parseInt(str[1]) + "}$)";

				regex = regex + "|([0-9]{" + Integer.parseInt(str[0]) + ","
						+ Integer.parseInt(str[1]) + "})";
			} else {
				regex = "(^\\p{L}{0," + Integer.parseInt(str[0]) / 2
						+ "}$)|(^[\\p{Ll}-\\p{Lu}]{0,"
						+ Integer.parseInt(str[0]) + "}$)";
				regex = regex + "|([0-9]{0," + Integer.parseInt(str[0]) + "})";
			}

		} else if (format.contains("N") && !format.contains("A")) {
			System.out.println("数据表示格式为 N");

			format = format.replace("N", "");
			String[] str = this.stringAnalytical(format, "..");
			if (str.length > 1) {
				regex = "([0-9]{" + Integer.parseInt(str[0]) + ","
						+ Integer.parseInt(str[1]) + "})";
				System.out.println("here1");
			} else {

				regex = "|([0-9]{0," + Integer.parseInt(str[0]) + "})";
			}
		}
		return regex;
	}

	private String getXpath(String dataElementID) {
		// TODO Auto-generated method stub
		return null;
	}

	private Element writePatternForDataElementAccuracy(
			String dataElementInternalID, String dataElementID,
			String dataElementName, String datatype, String format,
			String xpath, String regex) throws IOException {
		System.out.println("查询得到的正则表达式为："+regex);
		Element pattern = new Element("pattern");
		pattern.setAttribute("is-a", "check-value-match");
		pattern.setAttribute("id", dataElementInternalID);

		Element param1 = new Element("param");
		param1.setAttribute("name", "dataelementid");
		param1.setAttribute("value", dataElementID);

		Element param2 = new Element("param");
		param2.setAttribute("name", "dataelementname");
		param2.setAttribute("value", dataElementName);

		Element param3 = new Element("param");
		param3.setAttribute("name", "datatype");
		param3.setAttribute("value", datatype);

		Element param4 = new Element("param");
		param4.setAttribute("name", "format");
		param4.setAttribute("value", format);

		Element param5 = new Element("param");
		param5.setAttribute("name", "xpath");
		param5.setAttribute("value", xpath);

		Element param6 = new Element("param");
		param6.setAttribute("name", "regex");
		param6.setAttribute("value", regex);

		pattern.addContent(param1);
		pattern.addContent(param2);
		pattern.addContent(param3);
		pattern.addContent(param4);
		pattern.addContent(param5);
		pattern.addContent(param6);

		return pattern;

	}

	private void CreateAccuracySch() {
		try {
			Document doc = new Document(); // 生成Document对象。必须的。
			// ProcessingInstruction pi=new
			// ProcessingInstruction("xml-stylesheet","type=\"text/xsl\" href=\"test.xsl\"");
			// doc.addContent(pi);
			Namespace ns = Namespace
					.getNamespace("http://purl.oclc.org/dsdl/schematron");
			Namespace ns4 = Namespace.getNamespace("iso",
					"http://purl.oclc.org/dsdl/schematron");
			Namespace ns5 = Namespace.getNamespace("xi",
					"http://www.w3.org/2003/XInclude");
			Namespace ns6 = Namespace.getNamespace("queryBinding", "xslt2");
			Element root = new Element("schema"); // 根元素及其所有子标签都是Element型的对象表示。
			root.addNamespaceDeclaration(ns4); // 给根元素添加命名空间
			root.addNamespaceDeclaration(ns5); // 给根元素添加命名空间
			root.addNamespaceDeclaration(ns6); // 给根元素添加命名空间
			doc.setRootElement(root); // 将根源素加入Document对象

			Element ns1 = new Element("ns");
			ns1.setAttribute("prefix", "urn:hl7-org:v3"); // 设置元素属性
			Element ns2 = new Element("ns");

			ns2.setAttribute("prefix",
					"http://www.w3.org/2001/XMLSchema-instance"); // 设置元素属性
			Comment c = new Comment("$dataelementid 数据集内数据元标识符");

			Element pattern = new Element("pattern");
			pattern.setAttribute("abstract", "true");
			pattern.setAttribute("id", "check-dataelement-existed");
			Element rule = new Element("rule");

			rule.setAttribute("context", "$context");
			Element assert1 = new Element("assert");
			assert1.setAttribute("test", "count($path) &gt;= 1");
			assert1.setAttribute("role", "$dataelementid");

			Text text1 = new Text(
					"错误:&lt;value-of select=\"\'$dataelementid\'\"/&gt;  &lt;value-of select=\"\'$dataelementname\'\"/&gt;  数据元不存在  ");
			assert1.addContent(text1);
			Element report = new Element("assert");
			report.setAttribute("test", "count($path) &gt;= 1");
			report.setAttribute("role", "$dataelementid");

			Text text2 = new Text(
					"正确:&lt;value-of select=\"\'$dataelementid\'\"/&gt;  &lt;value-of select=\"\'$dataelementname\'\"/&gt;  数据元已存在  ");
			report.addContent(text2);

			rule.addContent(assert1);
			rule.addContent(report);
			pattern.addContent(rule);

			root.addContent(ns1);
			root.addContent(ns2);
			root.addContent(c);
			root.addContent(pattern);

			// 引入excel中的数据

			List<Element> elementList = this
					.readDataElementAccuracyFromExcel("城乡居民健康档案基本数据集.xls");
			for (int i = 1; i < elementList.size(); i++) {
				root.addContent(elementList.get(i));
			}

			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()); // 使XML文件分段
			outputter.output(doc, new FileWriter(new File(
					"EHR-SD-T-16001-v0.1-datasetaccuracy.sch"))); // 将doc对象写入test.xml。当然，也可以将doc写入其他类型的输出流。
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String[] stringAnalytical(String string, String divisionChar) {
		int i = 0;
		StringTokenizer tokenizer = new StringTokenizer(string, divisionChar);

		String[] str = new String[tokenizer.countTokens()];

		while (tokenizer.hasMoreTokens()) {
			str[i] = new String();
			str[i] = tokenizer.nextToken();
			i++;
		}

		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestJdom test = new TestJdom();
//		 test.CreateRatioSch();
		System.out.println(test.getRegex("S1", "N17"));
		System.out.println(test.getRegex("D", "D8"));
		System.out.println(test.getRegex("D", "DT15"));
		System.out.println(test.getRegex("L", "T/F"));

		 test.CreateAccuracySch();

	}

}