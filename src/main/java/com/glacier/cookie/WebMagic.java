package com.glacier.cookie;

import us.codecraft.webmagic.Spider;

/**
 * Created by glacier on 14-10-11.
 */
public class WebMagic {

    public static void main(String[] args) {

        Spider weiboSpider = new Spider(new CookiePageProcess()).addUrl("http://weibo.com/u/2314283235/home").thread(1);
        weiboSpider.run();
    }
}
