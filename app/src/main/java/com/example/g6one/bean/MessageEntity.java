package com.example.g6one.bean;

/*
 * @ClassName MessageEntity
 * @Description TODO
 * @Author 海
 * @Date 2021/8/28 10:26
 * @Version 1.0
 */
public class MessageEntity {

    private int id;
    private String content;
    private String newscode;
    private String commenttime;
    private int parentid;
    private int userid;

    public MessageEntity() {
    }

    public MessageEntity(int id, String content, String newscode, String commenttime, int parentid, int userid) {
        this.id = id;
        this.content = content;
        this.newscode = newscode;
        this.commenttime = commenttime;
        this.parentid = parentid;
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewscode() {
        return newscode;
    }

    public void setNewscode(String newscode) {
        this.newscode = newscode;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", newscode='" + newscode + '\'' +
                ", commenttime='" + commenttime + '\'' +
                ", parentid=" + parentid +
                ", userid=" + userid +
                '}';
    }
}