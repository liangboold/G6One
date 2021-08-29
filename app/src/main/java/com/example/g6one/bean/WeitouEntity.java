package com.example.g6one.bean;

/**
 * @ClassName WeitouEntity
 * @Description TODO
 * @Author 梁波
 * @Date 2021/8/28 11:17
 * @Version 1.0
 */
public class WeitouEntity {

    /**
     * id : 155
     * newscode : 6113cb311ecd4f609d1dc0abd04bda1d
     * userid : 774
     * content : 你好
     * imgs : https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3182678716,265847244&fm=26&gp=0.jpg|http://vfx.mtime.cn/Video/2019/03/18/mp4/190318214226685784.mp4
     * ctime : 2020/11/27 18:46:36
     */

    private int id;
    private String newscode;
    private int userid;
    private String content;
    private String imgs;
    private String ctime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewscode() {
        return newscode;
    }

    public void setNewscode(String newscode) {
        this.newscode = newscode;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
