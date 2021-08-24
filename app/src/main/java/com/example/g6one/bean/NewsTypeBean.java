package com.example.g6one.bean;

import java.io.Serializable;

/*
 * @ClassName NewsTypeBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/19 18:57
 * @Version 1.0
 */
public class NewsTypeBean implements Serializable {
    private TypeBean.DataBean dataBean;
    private boolean ischecked;

    @Override
    public String toString() {
        return "NewsTypeBean{" +
                "dataBean=" + dataBean +
                ", ischecked=" + ischecked +
                '}';
    }

    public TypeBean.DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(TypeBean.DataBean dataBean) {
        this.dataBean = dataBean;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public NewsTypeBean(TypeBean.DataBean dataBean, boolean ischecked) {
        this.dataBean = dataBean;
        this.ischecked = ischecked;
    }
}
