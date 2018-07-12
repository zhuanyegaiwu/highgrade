package com.xhs.mvpdemo.login.modle.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 布鲁斯.李 on 2018/7/6.
 * Email:zp18595658325@163.com
 */

public class LoginSuccessEntity implements Parcelable {

    /**
     * success : true
     * code : 0
     * msg : success
     * data : {"uid":"NJ5WxqTo3y7","personName":"袁军强","stationCode":"003","stationName":"二院分站"}
     */

    private boolean success;
    private int code;
    private String msg;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * uid : NJ5WxqTo3y7
         * personName : 袁军强
         * stationCode : 003
         * stationName : 二院分站
         */

        private String uid;
        private String personName;
        private String stationCode;
        private String stationName;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPersonName() {
            return personName;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.uid);
            dest.writeString(this.personName);
            dest.writeString(this.stationCode);
            dest.writeString(this.stationName);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.uid = in.readString();
            this.personName = in.readString();
            this.stationCode = in.readString();
            this.stationName = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.success ? (byte) 1 : (byte) 0);
        dest.writeInt(this.code);
        dest.writeString(this.msg);
        dest.writeParcelable(this.data, flags);
    }

    public LoginSuccessEntity() {
    }

    protected LoginSuccessEntity(Parcel in) {
        this.success = in.readByte() != 0;
        this.code = in.readInt();
        this.msg = in.readString();
        this.data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Creator<LoginSuccessEntity> CREATOR = new Creator<LoginSuccessEntity>() {
        @Override
        public LoginSuccessEntity createFromParcel(Parcel source) {
            return new LoginSuccessEntity(source);
        }

        @Override
        public LoginSuccessEntity[] newArray(int size) {
            return new LoginSuccessEntity[size];
        }
    };
}
