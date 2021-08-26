package com.example.g6one.bean;

public class NewsDetailEntity {


    /**
     * code : 200
     * data : {"id":584,"title":"任何没有休斯顿火箭参与的交易都是耍流氓","content":"","url":"http://39.98.153.96:8080/info/29613a0aa17a11e99121fc7774fd634d.html","newscode":"29613a0aa17a11e99121fc7774fd634d","auth":"情有独钟721","publishtime":"2019-07-07 21:49:22","isstaticpage":"1"}
     * msg : 操作成功
     */

    private int code;
    /**
     * id : 584.0
     * title : 任何没有休斯顿火箭参与的交易都是耍流氓
     * content :
     * url : http://39.98.153.96:8080/info/29613a0aa17a11e99121fc7774fd634d.html
     * newscode : 29613a0aa17a11e99121fc7774fd634d
     * auth : 情有独钟721
     * publishtime : 2019-07-07 21:49:22
     * isstaticpage : 1
     */

    private DataBean data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "NewsDetailEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static class DataBean {
        private double id;
        private String title;
        private String content;
        private String url;
        private String newscode;
        private String auth;
        private String publishtime;
        private String isstaticpage;

        public double getId() {
            return id;
        }

        public void setId(double id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNewscode() {
            return newscode;
        }

        public void setNewscode(String newscode) {
            this.newscode = newscode;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getIsstaticpage() {
            return isstaticpage;
        }

        public void setIsstaticpage(String isstaticpage) {
            this.isstaticpage = isstaticpage;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", url='" + url + '\'' +
                    ", newscode='" + newscode + '\'' +
                    ", auth='" + auth + '\'' +
                    ", publishtime='" + publishtime + '\'' +
                    ", isstaticpage='" + isstaticpage + '\'' +
                    '}';
        }
    }
}
