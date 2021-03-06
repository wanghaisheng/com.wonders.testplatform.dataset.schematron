package com.wonders.testplatform.dataset.schematron;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlFormat {

	public static String format(String str) throws Exception {
		SAXReader reader = new SAXReader();
		// System.out.println(reader);
		// 注释：创建一个串的字符输入流
		StringReader in = new StringReader(str);
		Document doc = reader.read(in);
		// System.out.println(doc.getRootElement());
		// 注释：创建输出格式
		OutputFormat formater = OutputFormat.createPrettyPrint();
		// formater=OutputFormat.createCompactFormat();
		// 注释：设置xml的输出编码
		formater.setEncoding("utf-8");
		// 注释：创建输出(目标)
		StringWriter out = new StringWriter();
		// 注释：创建输出流
		XMLWriter writer = new XMLWriter(out, formater);
		// 注释：输出格式化的串到目标中，执行后。格式化后的串保存在out中。
		writer.write(doc);

		writer.close();
		System.out.println(out.toString());
		// 注释：返回我们格式化后的结果
		return out.toString();
	}

	public static void main(String[] args) throws Exception {
		String head = "<?xml version=\"1.0\" encoding=\"GBK\"?>";

		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream("总体数据元数据元目录new.xml")));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		String str = buffer.toString().trim();
		format(str);
	}

}