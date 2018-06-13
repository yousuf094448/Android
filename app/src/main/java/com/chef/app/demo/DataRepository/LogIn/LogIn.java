
package com.chef.app.demo.DataRepository.LogIn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogIn {

    @SerializedName("Status")
    @Expose
    private Boolean status;
    @SerializedName("Data")
    @Expose
    private DeliveryManInfo profile;
    @SerializedName("Message")
    @Expose
    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DeliveryManInfo getProfile() {
        return profile;
    }

    public void setProfile(DeliveryManInfo profile) {
        this.profile = profile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
