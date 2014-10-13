package com.glacier.webmagic;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.scheduler.component.BloomFilterDuplicateRemover;

import javax.management.JMException;

/**
 * Created by glacier on 14-10-9.
 */
public class WebMagic {
    public static GetProxy objProxy = new GetProxy();
    public static void main(String[] args) throws JMException {
        String seedURL = "http://xa.58.com/qztech/pn";
        Spider jobSpider = Spider.create(new FiveEightPageProcessor());

        for ( int i = 1; i <= 100; i ++ ) {
            String url = seedURL + i + "/";
            jobSpider.addUrl(url);
        }
        jobSpider.thread(1);
        jobSpider.run();
        /*Spider doubanSpider = Spider.create(new FiveEightPageProcessor()).addUrl("http://xa.58.com/tech/")
                                                   .thread(1);
        doubanSpider.run();*/

        /*Spider jobSpider = Spider.create(new FiveOnePageProcessor())
                                .addUrl("http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=000000%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=%E8%AE%A1%E7%AE%97%E6%9C%BA&keywordtype=2&curr_page=1&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=01&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14")
                                .thread(1);
        jobSpider.setScheduler(new QueueScheduler()
                        .setDuplicateRemover(new BloomFilterDuplicateRemover(10000000)));
        jobSpider.run();*/
    }
}
