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
    public NewsTypeBean(TypeBean dataBean, boolean ischecked) {
        this.dataBean = dataBean;
        this.ischecked = ischecked;
    }

    public TypeBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(TypeBean dataBean) {
        this.dataBean = dataBean;
    }

    public boolean isIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    private TypeBean dataBean;
    private boolean ischecked;

    @Override
    public String toString() {
        return "NewsTypeBean{" +
                "dataBean=" + dataBean +
                ", ischecked=" + ischecked +
                '}';
    }


}
