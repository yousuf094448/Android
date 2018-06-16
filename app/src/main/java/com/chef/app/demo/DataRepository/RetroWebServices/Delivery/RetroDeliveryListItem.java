
package com.chef.app.demo.DataRepository.RetroWebServices.Delivery;

import com.chef.app.demo.Interfaces.Delivery;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroDeliveryListItem implements Delivery{

    @SerializedName("Customer")
    @Expose
    private Customer customer;
    @SerializedName("DeliveryMan")
    @Expose
    private DeliveryMan deliveryMan;
    @SerializedName("DeliveryOrderItem")
    @Expose
    private DeliveryOrderItem deliveryOrderItem;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("DeliveryManId")
    @Expose
    private Integer deliveryManId;
    @SerializedName("DeliveryOrderItemId")
    @Expose
    private Integer deliveryOrderItemId;
    @SerializedName("DeliveryAddress")
    @Expose
    private String deliveryAddress;
    @SerializedName("OrderDate")
    @Expose
    private String orderDate;
    @SerializedName("isDelivered")
    @Expose
    private Boolean isDelivered;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public DeliveryOrderItem getDeliveryOrderItem() {
        return deliveryOrderItem;
    }

    public void setDeliveryOrderItem(DeliveryOrderItem deliveryOrderItem) {
        this.deliveryOrderItem = deliveryOrderItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(Integer deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Integer getDeliveryOrderItemId() {
        return deliveryOrderItemId;
    }

    public void setDeliveryOrderItemId(Integer deliveryOrderItemId) {
        this.deliveryOrderItemId = deliveryOrderItemId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    @Override
    public String getName() {
        return customer.getFullName();
    }

    @Override
    public String getPhoneNumber() {
        return customer.getPhone();
    }

    @Override
    public String getAddress() {
        return deliveryAddress;
    }

    @Override
    public String getDeliverySttus() {
        if(isDelivered){
            return "Complete";
        }
        else return "Pending";
    }

    @Override
    public String getDeliveryCount() {
        return deliveryOrderItemId.toString();
    }
}
