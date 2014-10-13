package com.glacier.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by glacier on 14-10-10.
 */
public class DoubanHomPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(300);

    @Override
    public void process(Page page) {
        List<String> urlist = page.getHtml().links().all();
        for ( String line:urlist ) {
            if ( line.length() == 0 )
                urlist.remove(line);
        }
        for ( String line:urlist ) {
            System.out.println(line);
        }
        System.out.println(urlist.size());
    }

    @Override
    public Site getSite() {
        return site;
    }
}
