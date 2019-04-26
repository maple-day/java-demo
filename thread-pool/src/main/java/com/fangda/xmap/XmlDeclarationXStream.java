package com.fangda.xmap;

import com.thoughtworks.xstream.XStream;

import java.io.OutputStream;
import java.io.Writer;

public class XmlDeclarationXStream extends XStream {
	private String version;
 
	private String ecoding;
 
	public XmlDeclarationXStream() {
		this("1.0", "utf-8");
	}
 
	public XmlDeclarationXStream(String version, String ecoding) {
		this.version = version;
		this.ecoding = ecoding;
	}
 
	public String getDeclaration() {
		return "<?xml version=\"" + this.version + "\" encoding=\"" + this.ecoding + "\" standalone=\"yes\"?>";
	}
 
	@Override
	public void toXML(Object obj, OutputStream output) {
		try {
			String dec = this.getDeclaration();
			byte[] bytesOfDec = dec.getBytes(this.ecoding);
			output.write(bytesOfDec);
		} catch (Exception e) {
			throw new RuntimeException("error happens", e);
		}
		super.toXML(obj, output);
	}
 
	@Override
	public void toXML(Object obj, Writer writer) {
		try {
			writer.write(getDeclaration()); 
		} catch (Exception e) {
			throw new RuntimeException("error happens", e);
		}
		super.toXML(obj, writer);
	}
}
