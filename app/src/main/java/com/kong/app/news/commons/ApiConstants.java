package com.kong.app.news.commons;

/**
 * Created by whiskeyfei on 16-1-27.
 */
public class ApiConstants {

    //羽毛球
    public static final String BADMINTON_URL = "http://aiyuke.zhangwei.li/players?per_page=30&page=";
    // 图片
    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";
    public static final String BLOGS_URL = "http://doraemonyu.me/feed0.json";

    public static final int MAX_PAGE = 10;

    //微信精选
    public static final String HOST_WEIXIN = "http://api.huceo.com/wxnew/other/?key=650c60bee449d7d0acd166963939faf1&num=20";

    //科技新闻数据
    public static final String HOST_KEJI = "http://api.huceo.com/keji/other/?key=650c60bee449d7d0acd166963939faf1&num=20";

    //娱乐花边数据
    public static final String HOST_YULE = "http://api.huceo.com/huabian/other/?key=650c60bee449d7d0acd166963939faf1&num=20";

    //健康资讯数据
    public static final String HOST_JIANKANG = "http://api.huceo.com/health/other/?key=650c60bee449d7d0acd166963939faf1&num=20";
}
