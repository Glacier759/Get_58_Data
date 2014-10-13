package com.glacier.webmagic;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.File;
import java.util.List;

/**
 * Created by glacier on 14-10-10.
 */
public class FiveEightPageProcessor implements PageProcessor {

    //private Site site = Site.me().setRetryTimes(3).setSleepTime((int)((Math.random() * 10000000) % 3000) + 3000 );
    private Site site = Site.me().setRetryTimes(3).setSleepTime(300);

    @Override
    public void process(Page page) {

        if ( page.toString().contains("验证码") ) {
            site.setHttpProxy(WebMagic.objProxy.getProxy());
            page.addTargetRequest(page.getUrl().toString());
            return;
        }
        List<String> urlist = page.getHtml().$("a.fl").links().all();
        System.out.println("page = " + page.toString().length());
        System.out.println("size = " + urlist.size());
        Spider jobSpider = Spider.create(new JobPageProcessor())
                                    .addPipeline(new FilePipeline("58Data"));
        for ( String line:urlist ) {
            jobSpider.addUrl(line);
        }
        jobSpider.thread(1).run();
    }

    @Override
    public Site getSite() {
        return site;
    }
}
