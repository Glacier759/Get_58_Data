package com.glacier.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover;

import java.util.List;

/**
 * Created by glacier on 14-10-10.
 */
public class FiveOnePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(500).setCharset("gb2312");
    private Spider pageSpider = Spider.create(new JobPageProcessor())
                                    .addPipeline(new FilePipeline("51Data"))
                                    .setScheduler(new QueueScheduler()
                                    .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)))
                                    .thread(5);

    @Override
    public void process(Page page) {
        List<String> urlist = page.getHtml().$("table.searchPageNav").links().all();
        List<String> pageLink = page.getHtml().$("td.td1").$("a").links().all();
        for ( String line : pageLink ) {
            pageSpider.addUrl(line);
        }
        pageSpider.run();
        page.addTargetRequests(urlist);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
