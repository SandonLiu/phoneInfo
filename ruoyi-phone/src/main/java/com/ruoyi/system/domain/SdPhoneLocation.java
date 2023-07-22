package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 手机区域对应对象 sd_phone_location
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
public class SdPhoneLocation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 手机号前三位 */
    @Excel(name = "手机号前三位")
    private String pref;

    /** 手机号前七位 */
    @Excel(name = "手机号前七位")
    private String phone;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 运营商 */
    @Excel(name = "运营商")
    private String isp;

    /** 身份证前缀 */
    @Excel(name = "身份证前缀")
    private String postCode;

    /** 区号 */
    @Excel(name = "区号")
    private String cityCode;

    /** 区域代码 */
    @Excel(name = "区域代码")
    private String areaCode;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPref(String pref) 
    {
        this.pref = pref;
    }

    public String getPref() 
    {
        return pref;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setIsp(String isp) 
    {
        this.isp = isp;
    }

    public String getIsp() 
    {
        return isp;
    }
    public void setPostCode(String postCode) 
    {
        this.postCode = postCode;
    }

    public String getPostCode() 
    {
        return postCode;
    }
    public void setCityCode(String cityCode) 
    {
        this.cityCode = cityCode;
    }

    public String getCityCode() 
    {
        return cityCode;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("pref", getPref())
            .append("phone", getPhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("isp", getIsp())
            .append("postCode", getPostCode())
            .append("cityCode", getCityCode())
            .append("areaCode", getAreaCode())
            .toString();
    }
}
