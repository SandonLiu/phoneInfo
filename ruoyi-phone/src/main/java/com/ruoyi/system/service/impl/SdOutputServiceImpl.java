package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SdOutputMapper;
import com.ruoyi.system.domain.SdOutput;
import com.ruoyi.system.service.ISdOutputService;

/**
 * excel结果输出Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
@Service
public class SdOutputServiceImpl implements ISdOutputService 
{
    @Autowired
    private SdOutputMapper sdOutputMapper;

    /**
     * 查询excel结果输出
     * 
     * @param phone excel结果输出主键
     * @return excel结果输出
     */
    @Override
    public SdOutput selectSdOutputByPhone(String phone)
    {
        return sdOutputMapper.selectSdOutputByPhone(phone);
    }

    /**
     * 查询excel结果输出列表
     * 
     * @param sdOutput excel结果输出
     * @return excel结果输出
     */
    @Override
    public List<SdOutput> selectSdOutputList(SdOutput sdOutput)
    {
        return sdOutputMapper.selectSdOutputList(sdOutput);
    }

    /**
     * 新增excel结果输出
     * 
     * @param sdOutput excel结果输出
     * @return 结果
     */
    @Override
    public int insertSdOutput(SdOutput sdOutput)
    {
        return sdOutputMapper.insertSdOutput(sdOutput);
    }

    /**
     * 修改excel结果输出
     * 
     * @param sdOutput excel结果输出
     * @return 结果
     */
    @Override
    public int updateSdOutput(SdOutput sdOutput)
    {
        return sdOutputMapper.updateSdOutput(sdOutput);
    }

    /**
     * 批量删除excel结果输出
     * 
     * @param phones 需要删除的excel结果输出主键
     * @return 结果
     */
    @Override
    public int deleteSdOutputByPhones(String[] phones)
    {
        return sdOutputMapper.deleteSdOutputByPhones(phones);
    }

    /**
     * 删除excel结果输出信息
     * 
     * @param phone excel结果输出主键
     * @return 结果
     */
    @Override
    public int deleteSdOutputByPhone(String phone)
    {
        return sdOutputMapper.deleteSdOutputByPhone(phone);
    }
}
