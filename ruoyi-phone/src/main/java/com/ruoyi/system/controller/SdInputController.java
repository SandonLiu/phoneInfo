package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SdInput;
import com.ruoyi.system.service.ISdInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 导入电话号Controller
 *
 * @author ruoyi
 * @date 2023-07-22
 */
@RestController
@RequestMapping("/system/input")
public class SdInputController extends BaseController {
    @Autowired
    private ISdInputService sdInputService;

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<SdInput> util = new ExcelUtil<SdInput>(SdInput.class);
        List<SdInput> sdInputList = util.importExcel(file.getInputStream());
        if (sdInputList.size() > 0) {
            sdInputService.truncateTable();
        }
        for (SdInput sdInput : sdInputList) {
            sdInputService.insertSdInput(sdInput);
        }
        return AjaxResult.success(sdInputList.size());
    }

    /**
     * 模板下载
     *
     * @return
     */
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<SdInput> util = new ExcelUtil<SdInput>(SdInput.class);
        return util.importTemplateExcel("空白模板页");
    }

    /**
     * 清空数据
     *
     * @return
     */
    @GetMapping("/truncate")
    public AjaxResult truncateTable() {
        return AjaxResult.success(sdInputService.truncateTable());
    }


    /**
     * 查询导入电话号列表
     */
    @PreAuthorize("@ss.hasPermi('system:input:list')")
    @GetMapping("/list")
    public TableDataInfo list(SdInput sdInput) {
        startPage();
        List<SdInput> list = sdInputService.selectSdInputList(sdInput);
        return getDataTable(list);
    }

    /**
     * 导出导入电话号列表
     */
    @PreAuthorize("@ss.hasPermi('system:input:export')")
    @Log(title = "导入电话号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SdInput sdInput) {
        List<SdInput> list = sdInputService.selectSdInputList(sdInput);
        ExcelUtil<SdInput> util = new ExcelUtil<SdInput>(SdInput.class);
        util.exportExcel(response, list, "导入电话号数据");
    }

    /**
     * 获取导入电话号详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:input:query')")
    @GetMapping(value = "/{phone}")
    public AjaxResult getInfo(@PathVariable("phone") String phone) {
        return success(sdInputService.selectSdInputByPhone(phone));
    }

    /**
     * 新增导入电话号
     */
    @PreAuthorize("@ss.hasPermi('system:input:add')")
    @Log(title = "导入电话号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SdInput sdInput) {
        return toAjax(sdInputService.insertSdInput(sdInput));
    }

    /**
     * 修改导入电话号
     */
    @PreAuthorize("@ss.hasPermi('system:input:edit')")
    @Log(title = "导入电话号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SdInput sdInput) {
        return toAjax(sdInputService.updateSdInput(sdInput));
    }

    /**
     * 删除导入电话号
     */
    @PreAuthorize("@ss.hasPermi('system:input:remove')")
    @Log(title = "导入电话号", businessType = BusinessType.DELETE)
    @DeleteMapping("/{phones}")
    public AjaxResult remove(@PathVariable String[] phones) {
        return toAjax(sdInputService.deleteSdInputByPhones(phones));
    }

}
