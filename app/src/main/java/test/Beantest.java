package test;

import java.util.List;

public class Beantest {


    /**
     * error : false
     * results : [{"_id":"5bc49bb99d2122791c972ca9","createdAt":"2018-10-15T13:52:57.103Z","desc":"新版youtube视频效果","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8dcpt0g308w0fse83","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8gpdc4g308w0fsnpg"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/moyokoo/YoutubeVideoSample","used":true,"who":"miaoyj"},{"_id":"5bd013769d21220315c66403","createdAt":"2018-10-24T06:38:46.734Z","desc":"Kotlin实现的圆角ImageView，支持填充color资源和Glide的GifDrawable","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8icvxjg309a0giwgi"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/howshea/RoundCornerImageView","used":true,"who":"howshea"},{"_id":"5bd3eb7e9d2122031e666793","createdAt":"2018-10-27T04:37:18.843Z","desc":"A highlight & guide library for android Edit","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8jtmkej307i0dcmxj","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8k1541g307i0dc414","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8kuzk5g307i0dc7wh"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/samlss/Lighter","used":true,"who":"samlss"},{"_id":"5bdbaa529d21223d7a1b0aa9","createdAt":"2018-11-02T01:37:22.247Z","desc":"一个用于快速开发底部导航的库，支持红点提醒，支持分割线自定义。","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8l7k2fj30910fzq37"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/wintonBy/BottomNavigationView","used":true,"who":"Winton"},{"_id":"5bdd6ebe9d21223ddba8c9ec","createdAt":"2018-11-03T09:47:42.594Z","desc":"兼容微信 v6.7.3 的多图分享库。","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8ld5ctj30kp083wfe"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/shichaohui/WXShareMultiImage","used":true,"who":"石朝辉"},{"_id":"5bdf1a5b9d21223ddba8c9ef","createdAt":"2018-11-06T08:18:17.802Z","desc":" 一个Android文字轮播控件，实现了可垂直跑、可水平跑的跑马灯。","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8ly98mg30990gj4qp"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/ChessLuo/TextBannerView","used":true,"who":"ChessLuo"},{"_id":"5bdfcb489d21223dd88989cb","createdAt":"2018-11-05T04:47:04.719Z","desc":"用 kotlin 编写的带进度条的自定义 View ，适用于提交或上传图片。","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8mghkhg30mi05kk9f","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8mty6og30mi05kdsm","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8ngtcdg30mi05ktow"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/foreveronly/SubmitButton","used":true,"who":"foreveronly"},{"_id":"5be145d79d21223dd50660f1","createdAt":"2018-11-06T07:42:15.458Z","desc":"Android弹窗式菜单，支持多行可滚动的子菜单","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf93vukwg307i0dcb29","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf953noeg307i0dc1d2","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf95qikvg307i0dcqi6"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"Android","url":"https://github.com/samlss/TimoMenu","used":true,"who":"samlss"},{"_id":"5be14b7e9d21223dd50660f2","createdAt":"2018-11-06T08:06:22.851Z","desc":"弹性视图是一种常规的CardView，可以从用户触摸中进行弯曲。","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf977r0tg30860eju0y","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf994xfug30860ej1ky"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/armcha/ElasticView","used":true,"who":"lijinshanmx"},{"_id":"5be14be29d21223dd50660f3","createdAt":"2018-11-06T08:08:02.150Z","desc":"Android native BottomSheet on steroids.","images":["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf99mhzzg308w0ft11t","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf99rx73j30dr0ls3yj"],"publishedAt":"2018-11-06T00:00:00.0Z","source":"chrome","type":"Android","url":"https://github.com/andrefrsousa/SuperBottomSheet","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5bc49bb99d2122791c972ca9
         * createdAt : 2018-10-15T13:52:57.103Z
         * desc : 新版youtube视频效果
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8dcpt0g308w0fse83","https://ww1.sinaimg.cn/large/0073sXn7gy1fwyf8gpdc4g308w0fsnpg"]
         * publishedAt : 2018-11-06T00:00:00.0Z
         * source : web
         * type : Android
         * url : https://github.com/moyokoo/YoutubeVideoSample
         * used : true
         * who : miaoyj
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
