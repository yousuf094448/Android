
package com.chef.app.demo.DataRepository.RetroWebServices.Delivery;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryMan {

    @SerializedName("BusinessZones")
    @Expose
    private Object businessZones;
    @SerializedName("Coupons")
    @Expose
    private Object coupons;
    @SerializedName("HomeAddress")
    @Expose
    private Object homeAddress;
    @SerializedName("OfficeAddress")
    @Expose
    private Object officeAddress;
    @SerializedName("OtherAddress")
    @Expose
    private Object otherAddress;
    @SerializedName("SecurityRoles")
    @Expose
    private Object securityRoles;
    @SerializedName("SecurityUsers")
    @Expose
    private Object securityUsers;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("RoleId")
    @Expose
    private Integer roleId;
    @SerializedName("CouponId")
    @Expose
    private Object couponId;
    @SerializedName("DeliveryBoyId")
    @Expose
    private Object deliveryBoyId;
    @SerializedName("BusinessZoneId")
    @Expose
    private Integer businessZoneId;
    @SerializedName("OfficeAddressId")
    @Expose
    private Object officeAddressId;
    @SerializedName("HomeAddressId")
    @Expose
    private Object homeAddressId;
    @SerializedName("OtherAddressId")
    @Expose
    private Object otherAddressId;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("DeviceType")
    @Expose
    private Object deviceType;
    @SerializedName("DeviceToken")
    @Expose
    private Object deviceToken;
    @SerializedName("VerificationCode")
    @Expose
    private Object verificationCode;
    @SerializedName("RootUrl")
    @Expose
    private Object rootUrl;
    @SerializedName("FileName")
    @Expose
    private Object fileName;
    @SerializedName("FileExtention")
    @Expose
    private Object fileExtention;
    @SerializedName("IsAuthorize")
    @Expose
    private Boolean isAuthorize;
    @SerializedName("IsExternalUser")
    @Expose
    private Boolean isExternalUser;
    @SerializedName("CreateDate")
    @Expose
    private String createDate;
    @SerializedName("CreditBalance")
    @Expose
    private Double creditBalance;
    @SerializedName("DebitBalance")
    @Expose
    private Double debitBalance;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("Specialized")
    @Expose
    private Object specialized;
    @SerializedName("Access_Token")
    @Expose
    private Object accessToken;
    @SerializedName("Token_Type")
    @Expose
    private String tokenType;
    @SerializedName("ExpiresYears")
    @Expose
    private Integer expiresYears;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    public Object getBusinessZones() {
        return businessZones;
    }

    public void setBusinessZones(Object businessZones) {
        this.businessZones = businessZones;
    }

    public Object getCoupons() {
        return coupons;
    }

    public void setCoupons(Object coupons) {
        this.coupons = coupons;
    }

    public Object getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Object homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Object getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Object officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Object getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(Object otherAddress) {
        this.otherAddress = otherAddress;
    }

    public Object getSecurityRoles() {
        return securityRoles;
    }

    public void setSecurityRoles(Object securityRoles) {
        this.securityRoles = securityRoles;
    }

    public Object getSecurityUsers() {
        return securityUsers;
    }

    public void setSecurityUsers(Object securityUsers) {
        this.securityUsers = securityUsers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Object getCouponId() {
        return couponId;
    }

    public void setCouponId(Object couponId) {
        this.couponId = couponId;
    }

    public Object getDeliveryBoyId() {
        return deliveryBoyId;
    }

    public void setDeliveryBoyId(Object deliveryBoyId) {
        this.deliveryBoyId = deliveryBoyId;
    }

    public Integer getBusinessZoneId() {
        return businessZoneId;
    }

    public void setBusinessZoneId(Integer businessZoneId) {
        this.businessZoneId = businessZoneId;
    }

    public Object getOfficeAddressId() {
        return officeAddressId;
    }

    public void setOfficeAddressId(Object officeAddressId) {
        this.officeAddressId = officeAddressId;
    }

    public Object getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(Object homeAddressId) {
        this.homeAddressId = homeAddressId;
    }

    public Object getOtherAddressId() {
        return otherAddressId;
    }

    public void setOtherAddressId(Object otherAddressId) {
        this.otherAddressId = otherAddressId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Object deviceType) {
        this.deviceType = deviceType;
    }

    public Object getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(Object deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Object getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(Object verificationCode) {
        this.verificationCode = verificationCode;
    }

    public Object getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(Object rootUrl) {
        this.rootUrl = rootUrl;
    }

    public Object getFileName() {
        return fileName;
    }

    public void setFileName(Object fileName) {
        this.fileName = fileName;
    }

    public Object getFileExtention() {
        return fileExtention;
    }

    public void setFileExtention(Object fileExtention) {
        this.fileExtention = fileExtention;
    }

    public Boolean getIsAuthorize() {
        return isAuthorize;
    }

    public void setIsAuthorize(Boolean isAuthorize) {
        this.isAuthorize = isAuthorize;
    }

    public Boolean getIsExternalUser() {
        return isExternalUser;
    }

    public void setIsExternalUser(Boolean isExternalUser) {
        this.isExternalUser = isExternalUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public Double getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(Double debitBalance) {
        this.debitBalance = debitBalance;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Object specialized) {
        this.specialized = specialized;
    }

    public Object getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Object accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiresYears() {
        return expiresYears;
    }

    public void setExpiresYears(Integer expiresYears) {
        this.expiresYears = expiresYears;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
