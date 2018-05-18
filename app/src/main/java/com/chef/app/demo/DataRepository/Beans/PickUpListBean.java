package com.chef.app.demo.DataRepository.Beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PickUpListBean {
    @SerializedName("employee")
    @Expose
    private List<PickUpBean> employee = null;

    public List<PickUpBean> getEmployee() {
        return employee;
    }

    public void setEmployee(List<PickUpBean> employee) {
        this.employee = employee;
    }
}
