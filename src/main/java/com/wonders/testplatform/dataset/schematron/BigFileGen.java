package com.wonders.testplatform.dataset.schematron;

import java.io.FileWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;

public class BigFileGen {
	private static String filename = "bigfile.xml";
	private String alphabet = "abcdefghijklmopqrstuvwxyz";
	private String alphabetUpper = alphabet.toUpperCase();
	private String egg = "@";

	public void writeFile() {
		long startTime = System.currentTimeMillis();
		try {
			XMLOutputFactory xof = XMLOutputFactory.newInstance();
			XMLStreamWriter2 xtw = null;
			xof.setProperty("javax.xml.stream.isRepairingNamespaces",new Boolean(true));
			xtw = (XMLStreamWriter2) xof.createXMLStreamWriter(new FileWriter(
					filename));
			xtw.setDefaultNamespace("http://purl.oclc.org/dsdl/schematron");
			xtw.setPrefix("iso","http://purl.oclc.org/dsdl/schematron");
			xtw.setPrefix("xi","http://www.w3.org/2003/XInclude");
			xtw.setPrefix("queryBinding","xslt2");
			xtw.writeStartDocument();
			xtw.writeStartElement("schema");


		/*	for (int j = 0; j < 50; j++) {
				xtw.writeStartElement("bigelement");
//				writeLargeBody(xtw, 100000);
				xtw.writeEndElement();
				xtw.writeStartElement("withnested");
				for (int i = 1; i < 500; i++) {
					xtw.writeStartElement("nested" + i);
//					writeLargeBody(xtw, 100);
					xtw.writeEndElement();
				}
				xtw.writeEndElement();
			}*/
			xtw.writeEndDocument();
			xtw.flush();
			xtw.close();
		} catch (Exception ex) {
			System.err.println("Exception occurred while writing");
			ex.printStackTrace();
		}
		System.out.println("Writing completed in "
				+ (System.currentTimeMillis() - startTime) + " ms");
	}


	public static void main(String[] args) throws Exception {
		BigFileGen bfg = new BigFileGen();
		bfg.writeFile();
	}
}