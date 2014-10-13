package com.glacier.webmagic;

import org.apache.http.HttpHost;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * Created by glacier on 14-10-10.
 */
public class JobPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(300).setCharset("utf8");

    @Override
    public void process(Page page) {
        if ( page.toString().contains("验证码") ) {
            site.setHttpProxy(WebMagic.objProxy.getProxy());
            page.addTargetRequest(page.getUrl().toString());
            return;
        }
        System.out.println("save page");
        System.out.println(page.getUrl());
        page.putField("page", page.getHtml());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
