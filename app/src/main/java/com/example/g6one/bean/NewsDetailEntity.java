package com.example.g6one.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsDetailEntity implements Parcelable {

    /**
     * code : 200
     * data : {"id":10255,"title":"白马银枪赵子龙，智勇双全，为何只能给刘备当\u201c保安队长\u201d？","content":"","url":"http://39.98.153.96:8080/info/3c537ebaa44311e98a15fc7774fd634d.html","newscode":"3c537ebaa44311e98a15fc7774fd634d","auth":"虎头山小妖","publishtime":"2019-07-10 13:05:54","isstaticpage":"1"}
     * msg : 操作成功
     */

    private int code;
    private DataBean data;
    private String msg;


    public NewsDetailEntity() {
    }

    protected NewsDetailEntity(Parcel in) {
        code = in.readInt();
        msg = in.readString();
    }

    public static final Creator<NewsDetailEntity> CREATOR = new Creator<NewsDetailEntity>() {
        @Override
        public NewsDetailEntity createFromParcel(Parcel in) {
            return new NewsDetailEntity(in);
        }

        @Override
        public NewsDetailEntity[] newArray(int size) {
            return new NewsDetailEntity[size];
        }
    };

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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(msg);
    }

    public static class DataBean implements Parcelable{
        /**
         * id : 10255
         * title : 白马银枪赵子龙，智勇双全，为何只能给刘备当“保安队长”？
         * content :
         * url : http://39.98.153.96:8080/info/3c537ebaa44311e98a15fc7774fd634d.html
         * newscode : 3c537ebaa44311e98a15fc7774fd634d
         * auth : 虎头山小妖
         * publishtime : 2019-07-10 13:05:54
         * isstaticpage : 1
         */

        private int id;
        private String title;
        private String content;
        private String url;
        private String newscode;
        private String auth;
        private String publishtime;
        private String isstaticpage;

        protected DataBean(Parcel in) {
            id = in.readInt();
            title = in.readString();
            content = in.readString();
            url = in.readString();
            newscode = in.readString();
            auth = in.readString();
            publishtime = in.readString();
            isstaticpage = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(title);
            dest.writeString(content);
            dest.writeString(url);
            dest.writeString(newscode);
            dest.writeString(auth);
            dest.writeString(publishtime);
            dest.writeString(isstaticpage);
        }
    }
}
