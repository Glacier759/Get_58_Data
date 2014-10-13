package com.glacier.cookie;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * Created by glacier on 14-10-11.
 */
public class CookiePageProcess implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(300)
                                .addCookie("JSESSIONID", "abcN2nfiGqlYJ45rAU8Ju")
                                .addCookie("_de", "7FE503E36B4868D4247380B22A94C474696BF75400CE19CC")
                                .addCookie("_r01_", "1")
                                .addCookie("anonymid", "i149cfyq-hp0za8")
                                .addCookie("depovince", "BJ")
                                .addCookie("feedType", "479239535_hot")
                                .addCookie("first_login_flag", "")
                                .addCookie("id", "479239535")
                                .addCookie("jebe_key", "c6d568f6-70ea-4e29-b038-ee8f1a3c429f%7Cd4eaeaf2ae365591d1ca5114cb197841%7C1412989308776%7C1%7C1412989352180")
                                .addCookie("","");

    /*{
        site.addCookie("weibo.com", "Apache", "722732136491.6862.1412989073376")
            .addCookie("weibo.com", "SINAGLOBAL", "3644559616222.9775.1412395941775")
            .addCookie("weibo.com", "ULV", "1412989073403:9:9:6:722732136491.6862.1412989073376:1412933059084")
            .addCookie("weibo.com", "UOR", "jackyear.is-programmer.com,widget.weibo.com,login.sina.com.cn")
            .addCookie("weibo.com", "YF-Page-G0", "091b90e49b7b3ab2860004fba404a078")
            .addCookie("weibo.com", "YF-Ugrow-G0", "9b1c05a2e1e1e84dd3e500248ab16d62")
            .addCookie("weibo.com", "YF-V5-G0", "d8480b079e226c170ff763917f70c4e7")
            .addCookie("weibo.com", "_s_tentry", "login.sina.com.cn")
            .addCookie("weibo.com", "un", "l_ee_hom@msn.cn")
            .addCookie("weibo.com", "wvr", "5");
        site.addCookie("login.sina.com.cn", "ALF", "1444525022")
            .addCookie("login.sina.com.cn", "SUB", "_2AkMjZA9pa8NlrAFSmfwXxGjgb4hH-jyQssWfAn7tJhIyGxgf7lcFqSVhXUCoyISv9kH0lbAmUbWjGFRHcQ..")
            .addCookie("login.sina.com.cn", "SUBP", "0033WrSXqPxfM725Ws9jqgMF55529P9D9W57qPSuDzF70FBjJ.ahov0Q")
            .addCookie("login.sina.com.cn", "SUE", "es%3Df74147e0c69e6a46499baa5d8a3ea1b1%26ev%3Dv1%26es2%3Dc72141e4cc26bb012b5597bc2519b29b%26rs0%3Dmrxv8E2qxPyfanYyLFpIkhz3Q6bZyz%252BEgsP2om6B6dp2L8Fs0Zab%252BGQ0ufoE2Oi6rJNtWtR8kSDXnys9E8a8DwkOgXLUiWqWnWvC9KJl0dPypP61BwkuB1i21rhfu6mAIulV%252B55NmQpaCz0bjpfCZ58E9eW%252FS4qDZIN2q1a2yL4%253D%26rv%3D0")
            .addCookie("login.sina.com.cn", "SUP", "cv%3D1%26bt%3D1412989022%26et%3D1413075422%26d%3D40c3%26i%3Df844%26us%3D1%26vf%3D0%26vt%3D0%26ac%3D2%26st%3D0%26lt%3D7%26uid%3D2314283235%26user%3Dl_ee_hom%2540msn.cn%26ag%3D4%26name%3Dl_ee_hom%2540msn.cn%26nick%3DAs_time_goes_by%26sex%3D%26ps%3D0%26email%3D%26dob%3D%26ln%3D%26os%3D%26fmp%3D%26lcp%3D2014-08-10%252021%253A10%253A05")
            .addCookie("login.sina.com.cn", "SUS", "SID-2314283235-1412989022-GZ-vuz9f-c37ea43506974e1830e12d0b0e13f844")
            .addCookie("login.sina.com.cn", "U_TRS2", "0000004b.b5242522.5438805e.f3853a3d");
    }*/

    @Override
    public void process(Page page) {
        System.out.println(page);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
