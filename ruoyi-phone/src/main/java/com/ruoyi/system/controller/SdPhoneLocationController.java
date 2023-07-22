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
import com.ruoyi.system.domain.SdPhoneLocation;
import com.ruoyi.system.service.ISdPhoneLocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机区域对应Controller
 * 
 * @author ruoyi
 * @date 2023-07-22
 */
@RestController
@RequestMapping("/system/location")
public class SdPhoneLocationController extends BaseController
{
    @Autowired
    private ISdPhoneLocationService sdPhoneLocationService;

    /**
     * 查询手机区域对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(SdPhoneLocation sdPhoneLocation)
    {
        startPage();
        List<SdPhoneLocation> list = sdPhoneLocationService.selectSdPhoneLocationList(sdPhoneLocation);
        return getDataTable(list);
    }

    /**
     * 导出手机区域对应列表
     */
    @PreAuthorize("@ss.hasPermi('system:location:export')")
    @Log(title = "手机区域对应", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SdPhoneLocation sdPhoneLocation)
    {
        List<SdPhoneLocation> list = sdPhoneLocationService.selectSdPhoneLocationList(sdPhoneLocation);
        ExcelUtil<SdPhoneLocation> util = new ExcelUtil<SdPhoneLocation>(SdPhoneLocation.class);
        util.exportExcel(response, list, "手机区域对应数据");
    }

    /**
     * 获取手机区域对应详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(sdPhoneLocationService.selectSdPhoneLocationById(id));
    }

    /**
     * 新增手机区域对应
     */
    @PreAuthorize("@ss.hasPermi('system:location:add')")
    @Log(title = "手机区域对应", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SdPhoneLocation sdPhoneLocation)
    {
        return toAjax(sdPhoneLocationService.insertSdPhoneLocation(sdPhoneLocation));
    }

    /**
     * 修改手机区域对应
     */
    @PreAuthorize("@ss.hasPermi('system:location:edit')")
    @Log(title = "手机区域对应", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SdPhoneLocation sdPhoneLocation)
    {
        return toAjax(sdPhoneLocationService.updateSdPhoneLocation(sdPhoneLocation));
    }

    /**
     * 删除手机区域对应
     */
    @PreAuthorize("@ss.hasPermi('system:location:remove')")
    @Log(title = "手机区域对应", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sdPhoneLocationService.deleteSdPhoneLocationByIds(ids));
    }
}
