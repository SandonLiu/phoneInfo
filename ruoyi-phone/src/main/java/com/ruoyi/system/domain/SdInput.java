package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 导入电话号对象 sd_input
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
public class SdInput extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 导入电话号 */
    @Excel(name = "导入电话号")
    private String phone;

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("phone", getPhone())
            .toString();
    }
}
