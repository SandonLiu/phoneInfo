package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SdInput;
import com.ruoyi.system.mapper.SdInputMapper;
import com.ruoyi.system.service.ISdInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 导入电话号Service业务层处理
 *
 * @author ruoyi
 * @date 2023-07-22
 */
@Service
public class SdInputServiceImpl implements ISdInputService {
    @Autowired
    private SdInputMapper sdInputMapper;

    /**
     * 查询导入电话号
     *
     * @param phone 导入电话号主键
     * @return 导入电话号
     */
    @Override
    public SdInput selectSdInputByPhone(String phone) {
        return sdInputMapper.selectSdInputByPhone(phone);
    }

    /**
     * 查询导入电话号列表
     *
     * @param sdInput 导入电话号
     * @return 导入电话号
     */
    @Override
    public List<SdInput> selectSdInputList(SdInput sdInput) {
        return sdInputMapper.selectSdInputList(sdInput);
    }

    /**
     * 新增导入电话号
     *
     * @param sdInput 导入电话号
     * @return 结果
     */
    @Override
    public int insertSdInput(SdInput sdInput) {
        return sdInputMapper.insertSdInput(sdInput);
    }

    /**
     * 修改导入电话号
     *
     * @param sdInput 导入电话号
     * @return 结果
     */
    @Override
    public int updateSdInput(SdInput sdInput) {
        return sdInputMapper.updateSdInput(sdInput);
    }

    /**
     * 批量删除导入电话号
     *
     * @param phones 需要删除的导入电话号主键
     * @return 结果
     */
    @Override
    public int deleteSdInputByPhones(String[] phones) {
        return sdInputMapper.deleteSdInputByPhones(phones);
    }

    /**
     * 删除导入电话号信息
     *
     * @param phone 导入电话号主键
     * @return 结果
     */
    @Override
    public int deleteSdInputByPhone(String phone) {
        return sdInputMapper.deleteSdInputByPhone(phone);
    }

    /**
     * 清空所有表
     *
     * @return
     */
    @Override
    public int truncateTable() {
        return sdInputMapper.truncateTable();
    }

}
