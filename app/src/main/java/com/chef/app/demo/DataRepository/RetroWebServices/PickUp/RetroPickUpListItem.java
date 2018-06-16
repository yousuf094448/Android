
package com.chef.app.demo.DataRepository.RetroWebServices.PickUp;

import com.chef.app.demo.Interfaces.PickUp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetroPickUpListItem implements PickUp{

    @SerializedName("Chef")
    @Expose
    private Chef chef;
    @SerializedName("DeliveryMan")
    @Expose
    private DeliveryMan deliveryMan;
    @SerializedName("PickOrderItem")
    @Expose
    private PickOrderItem pickOrderItem;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("ChefId")
    @Expose
    private Integer chefId;
    @SerializedName("DeliveryManId")
    @Expose
    private Integer deliveryManId;
    @SerializedName("PickOrderItemId")
    @Expose
    private Integer pickOrderItemId;
    @SerializedName("PickAddress")
    @Expose
    private String pickAddress;
    @SerializedName("OrderDate")
    @Expose
    private String orderDate;
    @SerializedName("isPickuped")
    @Expose
    private Boolean isPickuped;

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public PickOrderItem getPickOrderItem() {
        return pickOrderItem;
    }

    public void setPickOrderItem(PickOrderItem pickOrderItem) {
        this.pickOrderItem = pickOrderItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }

    public Integer getDeliveryManId() {
        return deliveryManId;
    }

    public void setDeliveryManId(Integer deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    public Integer getPickOrderItemId() {
        return pickOrderItemId;
    }

    public void setPickOrderItemId(Integer pickOrderItemId) {
        this.pickOrderItemId = pickOrderItemId;
    }

    public String getPickAddress() {
        return pickAddress;
    }

    public void setPickAddress(String pickAddress) {
        this.pickAddress = pickAddress;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getIsPickuped() {
        return isPickuped;
    }

    public void setIsPickuped(Boolean isPickuped) {
        this.isPickuped = isPickuped;
    }

    @Override
    public String getName() {
        return getChef().getFullName();
    }

    @Override
    public String getPhoneNumber() {
        return getChef().getPhone();
    }

    @Override
    public String getAddress() {
        return getPickAddress();
    }

    @Override
    public String getPickUpStatus() {
        if(getIsPickuped()){
            return "Complete";
        }else
            return "Pending";
    }

    @Override
    public String getNumberOfPackets() {
        return getPickOrderItem().getQuantity().toString();
    }
}
