package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SdOutput;

/**
 * excel结果输出Service接口
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
public interface ISdOutputService 
{
    /**
     * 查询excel结果输出
     * 
     * @param phone excel结果输出主键
     * @return excel结果输出
     */
    public SdOutput selectSdOutputByPhone(String phone);

    /**
     * 查询excel结果输出列表
     * 
     * @param sdOutput excel结果输出
     * @return excel结果输出集合
     */
    public List<SdOutput> selectSdOutputList(SdOutput sdOutput);

    /**
     * 新增excel结果输出
     * 
     * @param sdOutput excel结果输出
     * @return 结果
     */
    public int insertSdOutput(SdOutput sdOutput);

    /**
     * 修改excel结果输出
     * 
     * @param sdOutput excel结果输出
     * @return 结果
     */
    public int updateSdOutput(SdOutput sdOutput);

    /**
     * 批量删除excel结果输出
     * 
     * @param phones 需要删除的excel结果输出主键集合
     * @return 结果
     */
    public int deleteSdOutputByPhones(String[] phones);

    /**
     * 删除excel结果输出信息
     * 
     * @param phone excel结果输出主键
     * @return 结果
     */
    public int deleteSdOutputByPhone(String phone);
}
