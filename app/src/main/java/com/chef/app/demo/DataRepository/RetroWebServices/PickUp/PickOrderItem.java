
package com.chef.app.demo.DataRepository.RetroWebServices.PickUp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PickOrderItem {

    @SerializedName("MenuItems")
    @Expose
    private Object menuItems;
    @SerializedName("Orders")
    @Expose
    private Object orders;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("OrderId")
    @Expose
    private Integer orderId;
    @SerializedName("MenuItemId")
    @Expose
    private Integer menuItemId;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("OrderDate")
    @Expose
    private String orderDate;
    @SerializedName("StartTime")
    @Expose
    private String startTime;
    @SerializedName("EndTime")
    @Expose
    private String endTime;
    @SerializedName("IsRating")
    @Expose
    private Boolean isRating;
    @SerializedName("IsComplained")
    @Expose
    private Boolean isComplained;

    public Object getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Object menuItems) {
        this.menuItems = menuItems;
    }

    public Object getOrders() {
        return orders;
    }

    public void setOrders(Object orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsRating() {
        return isRating;
    }

    public void setIsRating(Boolean isRating) {
        this.isRating = isRating;
    }

    public Boolean getIsComplained() {
        return isComplained;
    }

    public void setIsComplained(Boolean isComplained) {
        this.isComplained = isComplained;
    }

}
