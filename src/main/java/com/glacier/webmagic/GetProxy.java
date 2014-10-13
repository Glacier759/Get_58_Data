package com.glacier.webmagic;


import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by glacier on 14-10-13.
 */
public class GetProxy {
    private static LinkedHashMap<String,String> proxyMap = new LinkedHashMap<String, String>();
    {
        try {
            SAXReader saxReader = new SAXReader();
            Document xmlDoc = saxReader.read(new File("proxy.conf"));
            Element proxyRoot = xmlDoc.getRootElement();
            List<?> proxyList = proxyRoot.elements("proxy");
            for (Iterator<?> itor = proxyList.iterator(); itor.hasNext(); ) {
                Element proxy = (Element)itor.next();
                String proxyIP = proxy.element("proxyIP").getText();
                String proxyPort = proxy.elementText("proxyPort");
                proxyMap.put(proxyIP, proxyPort);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public HttpHost getProxy() {
        HttpHost httpHost = null;
        try {
            String removeIP = proxyMap.keySet().iterator().next();
            String removePort = proxyMap.remove(removeIP);
            proxyMap.put(removeIP, removePort);
            System.out.println("get proxy = " + removeIP + ":" + removePort);
            httpHost = new HttpHost(removeIP, new Integer(removePort));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return httpHost;
    }
}