package com.tneciv.blueprint.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tneciv
 * on 2016-09-17 19:03 .
 */

public class LoginEntity implements Parcelable {

    /**
     * access_token : 29ed478ab86c07f1c069b1af76088f7431396b7c4a2523d06911345da82224a0
     * token_type : bearer
     * scope : public write
     */

    private String access_token;
    private String token_type;
    private String scope;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.access_token);
        dest.writeString(this.token_type);
        dest.writeString(this.scope);
    }

    public LoginEntity() {
    }

    protected LoginEntity(Parcel in) {
        this.access_token = in.readString();
        this.token_type = in.readString();
        this.scope = in.readString();
    }

    public static final Parcelable.Creator<LoginEntity> CREATOR = new Parcelable.Creator<LoginEntity>() {
        @Override
        public LoginEntity createFromParcel(Parcel source) {
            return new LoginEntity(source);
        }

        @Override
        public LoginEntity[] newArray(int size) {
            return new LoginEntity[size];
        }
    };
}
