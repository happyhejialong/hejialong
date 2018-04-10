package com.ycxy.wdgj.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/***
 * 生成电子面单时需要的信息
 * 
 * @author TF
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestData {
    // 订单编号
    private String OrderCode;
    // 物流编码SF
    private String ShipperCode;
    // 邮费支付方式:1-现付，2-到付，3-月结，4-第三方支付
    private Byte PayType;
    // 快递类型：1-标准快件
    private Byte ExpType = 1;
    // 寄件费（运费）
    private Double Cost;
    // 其他费用
    private Double OtherCost;
    // 寄件方信息
    private Sender sender = new Sender();

    class Sender {
        private String Company;
        private String Name;
        private String Mobile;
        private String ProvinceName;
        private String CityName;
        private String ExpAreaName;
        private String Address;

        public String getCompany() {
            return Company;
        }

        public void setCompany(String company) {
            Company = company;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String mobile) {
            Mobile = mobile;
        }

        public String getProvinceName() {
            return ProvinceName;
        }

        public void setProvinceName(String provinceName) {
            ProvinceName = provinceName;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String cityName) {
            CityName = cityName;
        }

        public String getExpAreaName() {
            return ExpAreaName;
        }

        public void setExpAreaName(String expAreaName) {
            ExpAreaName = expAreaName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

    }

    private Receiver Receiver = new Receiver();

    class Receiver {
        // 收件人公司
        private String Company;
        // 收件人
        private String Name;
        // 手机
        private String Mobile;
        // 收件省
        private String ProvinceName;
        // 收件市
        private String CityName;
        // 收件区
        private String ExpAreaName;
        // 收件人详细地址
        private String Address;

        public String getCompany() {
            return Company;
        }

        public void setCompany(String company) {
            Company = company;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getMobile() {
            return Mobile;
        }

        public void setMobile(String mobile) {
            Mobile = mobile;
        }

        public String getProvinceName() {
            return ProvinceName;
        }

        public void setProvinceName(String provinceName) {
            ProvinceName = provinceName;
        }

        public String getCityName() {
            return CityName;
        }

        public void setCityName(String cityName) {
            CityName = cityName;
        }

        public String getExpAreaName() {
            return ExpAreaName;
        }

        public void setExpAreaName(String expAreaName) {
            ExpAreaName = expAreaName;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

    }

    private Commodity[] Commodity;

    // 物品总重量kg
    private Double Weight;
    // 件数/包裹数
    private Integer Quantity;
    // 物品总体积m3
    private Double Volume;
    // 备注
    private String Remark;
    // 返回电子面单模板：0-不需要；1-需要
    private Byte IsReturnPrintTemplate;

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public Byte getPayType() {
        return PayType;
    }

    public void setPayType(Byte payType) {
        PayType = payType;
    }

    public Byte getExpType() {
        return ExpType;
    }

    public void setExpType(Byte expType) {
        ExpType = expType;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    public Double getOtherCost() {
        return OtherCost;
    }

    public void setOtherCost(Double otherCost) {
        OtherCost = otherCost;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return Receiver;
    }

    public void setReceiver(Receiver receiver) {
        Receiver = receiver;
    }

    public Commodity[] getCommodity() {
        return Commodity;
    }

    public void setCommodity(Commodity[] commodity) {
        Commodity = commodity;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public Byte getIsReturnPrintTemplate() {
        return IsReturnPrintTemplate;
    }

    public void setIsReturnPrintTemplate(Byte isReturnPrintTemplate) {
        IsReturnPrintTemplate = isReturnPrintTemplate;
    }

}
