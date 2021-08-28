package com.example.g6one.bean;

public class NewsDetailEntity {
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
