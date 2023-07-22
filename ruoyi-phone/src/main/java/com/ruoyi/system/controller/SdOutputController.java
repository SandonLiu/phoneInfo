package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SdOutput;
import com.ruoyi.system.service.ISdOutputService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * excel结果输出Controller
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
@RestController
@RequestMapping("/system/output")
public class SdOutputController extends BaseController
{
    @Autowired
    private ISdOutputService sdOutputService;

    /**
     * 查询excel结果输出列表
     */
    @PreAuthorize("@ss.hasPermi('system:output:list')")
    @GetMapping("/list")
    public TableDataInfo list(SdOutput sdOutput)
    {
        startPage();
        List<SdOutput> list = sdOutputService.selectSdOutputList(sdOutput);
        return getDataTable(list);
    }

    /**
     * 导出excel结果输出列表
     */
    @PreAuthorize("@ss.hasPermi('system:output:export')")
    @Log(title = "excel结果输出", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SdOutput sdOutput)
    {
        List<SdOutput> list = sdOutputService.selectSdOutputList(sdOutput);
        ExcelUtil<SdOutput> util = new ExcelUtil<SdOutput>(SdOutput.class);
        util.exportExcel(response, list, "excel结果输出数据");
    }

    /**
     * 获取excel结果输出详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:output:query')")
    @GetMapping(value = "/{phone}")
    public AjaxResult getInfo(@PathVariable("phone") String phone)
    {
        return success(sdOutputService.selectSdOutputByPhone(phone));
    }

    /**
     * 新增excel结果输出
     */
    @PreAuthorize("@ss.hasPermi('system:output:add')")
    @Log(title = "excel结果输出", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SdOutput sdOutput)
    {
        return toAjax(sdOutputService.insertSdOutput(sdOutput));
    }

    /**
     * 修改excel结果输出
     */
    @PreAuthorize("@ss.hasPermi('system:output:edit')")
    @Log(title = "excel结果输出", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SdOutput sdOutput)
    {
        return toAjax(sdOutputService.updateSdOutput(sdOutput));
    }

    /**
     * 删除excel结果输出
     */
    @PreAuthorize("@ss.hasPermi('system:output:remove')")
    @Log(title = "excel结果输出", businessType = BusinessType.DELETE)
	@DeleteMapping("/{phones}")
    public AjaxResult remove(@PathVariable String[] phones)
    {
        return toAjax(sdOutputService.deleteSdOutputByPhones(phones));
    }
}
