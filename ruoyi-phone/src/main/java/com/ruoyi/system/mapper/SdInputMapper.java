package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SdInput;

import java.util.List;

/**
 * 导入电话号Mapper接口
 *
 * @author ruoyi
 * @date 2023-07-22
 */
public interface SdInputMapper {
    /**
     * 查询导入电话号
     *
     * @param phone 导入电话号主键
     * @return 导入电话号
     */
    public SdInput selectSdInputByPhone(String phone);

    /**
     * 查询导入电话号列表
     *
     * @param sdInput 导入电话号
     * @return 导入电话号集合
     */
    public List<SdInput> selectSdInputList(SdInput sdInput);

    /**
     * 新增导入电话号
     *
     * @param sdInput 导入电话号
     * @return 结果
     */
    public int insertSdInput(SdInput sdInput);

    /**
     * 修改导入电话号
     *
     * @param sdInput 导入电话号
     * @return 结果
     */
    public int updateSdInput(SdInput sdInput);

    /**
     * 删除导入电话号
     *
     * @param phone 导入电话号主键
     * @return 结果
     */
    public int deleteSdInputByPhone(String phone);

    /**
     * 批量删除导入电话号
     *
     * @param phones 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSdInputByPhones(String[] phones);

    public int truncateTable();
}
