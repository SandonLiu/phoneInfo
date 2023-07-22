package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SdPhoneLocation;
import com.ruoyi.system.mapper.SdPhoneLocationMapper;
import com.ruoyi.system.service.ISdPhoneLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 手机区域对应Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-22
 */
@Service
public class SdPhoneLocationServiceImpl implements ISdPhoneLocationService {
    @Autowired
    private SdPhoneLocationMapper sdPhoneLocationMapper;

    /**
     * 查询手机区域对应
     *
     * @param id 手机区域对应主键
     * @return 手机区域对应
     */
    @Override
    public SdPhoneLocation selectSdPhoneLocationById(String id) {
        return sdPhoneLocationMapper.selectSdPhoneLocationById(id);
    }

    /**
     * 查询手机区域对应列表
     *
     * @param sdPhoneLocation 手机区域对应
     * @return 手机区域对应
     */
    @Override
    public List<SdPhoneLocation> selectSdPhoneLocationList(SdPhoneLocation sdPhoneLocation) {
        // 只截取前七位
        if (StringUtils.isNotEmpty(sdPhoneLocation.getPhone())) {
            String phone = sdPhoneLocation.getPhone().substring(0, 7);
            sdPhoneLocation.setPhone(phone);
        }
        return sdPhoneLocationMapper.selectSdPhoneLocationList(sdPhoneLocation);
    }

    /**
     * 新增手机区域对应
     *
     * @param sdPhoneLocation 手机区域对应
     * @return 结果
     */
    @Override
    public int insertSdPhoneLocation(SdPhoneLocation sdPhoneLocation) {
        return sdPhoneLocationMapper.insertSdPhoneLocation(sdPhoneLocation);
    }

    /**
     * 修改手机区域对应
     *
     * @param sdPhoneLocation 手机区域对应
     * @return 结果
     */
    @Override
    public int updateSdPhoneLocation(SdPhoneLocation sdPhoneLocation) {
        return sdPhoneLocationMapper.updateSdPhoneLocation(sdPhoneLocation);
    }

    /**
     * 批量删除手机区域对应
     *
     * @param ids 需要删除的手机区域对应主键
     * @return 结果
     */
    @Override
    public int deleteSdPhoneLocationByIds(String[] ids) {
        return sdPhoneLocationMapper.deleteSdPhoneLocationByIds(ids);
    }

    /**
     * 删除手机区域对应信息
     *
     * @param id 手机区域对应主键
     * @return 结果
     */
    @Override
    public int deleteSdPhoneLocationById(String id) {
        return sdPhoneLocationMapper.deleteSdPhoneLocationById(id);
    }
}
