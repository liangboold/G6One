package com.example.g6one.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/*
 * @ClassName TypeBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/8/19 18:56
 * @Version 1.0
 */
public class TypeBean implements Parcelable {

        private int id;
        private String typename;


    protected TypeBean(Parcel in) {
        id = in.readInt();
        typename = in.readString();
    }

    public static final Creator<TypeBean> CREATOR = new Creator<TypeBean>() {
        @Override
        public TypeBean createFromParcel(Parcel in) {
            return new TypeBean(in);
        }

        @Override
        public TypeBean[] newArray(int size) {
            return new TypeBean[size];
        }
    };

    public TypeBean() {
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(typename);
    }
}
