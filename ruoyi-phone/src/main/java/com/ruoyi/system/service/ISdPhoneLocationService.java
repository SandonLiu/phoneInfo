package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SdPhoneLocation;

/**
 * 手机区域对应Service接口
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
public interface ISdPhoneLocationService 
{
    /**
     * 查询手机区域对应
     * 
     * @param id 手机区域对应主键
     * @return 手机区域对应
     */
    public SdPhoneLocation selectSdPhoneLocationById(String id);

    /**
     * 查询手机区域对应列表
     * 
     * @param sdPhoneLocation 手机区域对应
     * @return 手机区域对应集合
     */
    public List<SdPhoneLocation> selectSdPhoneLocationList(SdPhoneLocation sdPhoneLocation);

    /**
     * 新增手机区域对应
     * 
     * @param sdPhoneLocation 手机区域对应
     * @return 结果
     */
    public int insertSdPhoneLocation(SdPhoneLocation sdPhoneLocation);

    /**
     * 修改手机区域对应
     * 
     * @param sdPhoneLocation 手机区域对应
     * @return 结果
     */
    public int updateSdPhoneLocation(SdPhoneLocation sdPhoneLocation);

    /**
     * 批量删除手机区域对应
     * 
     * @param ids 需要删除的手机区域对应主键集合
     * @return 结果
     */
    public int deleteSdPhoneLocationByIds(String[] ids);

    /**
     * 删除手机区域对应信息
     * 
     * @param id 手机区域对应主键
     * @return 结果
     */
    public int deleteSdPhoneLocationById(String id);
}
