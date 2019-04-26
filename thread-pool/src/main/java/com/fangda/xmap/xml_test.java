package com.fangda.xmap;

import com.thoughtworks.xstream.XStream;

public class xml_test {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(18);
        person.setUsername("张三");
//        person.setPhone("1573592866");
        XStream xStream = new XmlDeclarationXStream();
        xStream.alias("payforreq",Person.class);
        xStream.aliasField("姓名",Person.class,"username");
        String xml = xStream.toXML(person);
        System.err.println( xml);
    }
}
