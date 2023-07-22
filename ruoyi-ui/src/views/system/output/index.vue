<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="100px">
      <el-form-item label="输入手机号" prop="phone">
        <el-input v-model="queryParams.phone" placeholder="请输入输入手机号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="手机号前三位" prop="phone3">
        <el-input v-model="queryParams.phone3" placeholder="请输入手机号前三位" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="手机号前七位" prop="phone7">
        <el-input v-model="queryParams.phone7" placeholder="请输入手机号前七位" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="省份" prop="province">
        <el-input v-model="queryParams.province" placeholder="请输入省份" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="城市" prop="city">
        <el-input v-model="queryParams.city" placeholder="请输入城市" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="运营商" prop="isp">
        <el-input v-model="queryParams.isp" placeholder="请输入运营商" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="身份证前缀" prop="postCode">
        <el-input v-model="queryParams.postCode" placeholder="请输入身份证前缀" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="区号" prop="cityCode">
        <el-input v-model="queryParams.cityCode" placeholder="请输入区号" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="区域代码" prop="areaCode">
        <el-input v-model="queryParams.areaCode" placeholder="请输入区域代码" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['system:output:export']">导出Excel结果</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="outputList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="输入手机号" align="center" prop="phone" />
      <el-table-column label="手机号前三位" align="center" prop="phone3" />
      <el-table-column label="手机号前七位" align="center" prop="phone7" />
      <el-table-column label="省份" align="center" prop="province" />
      <el-table-column label="城市" align="center" prop="city" />
      <el-table-column label="运营商" align="center" prop="isp" />
      <el-table-column label="身份证前缀" align="center" prop="postCode" />
      <el-table-column label="区号" align="center" prop="cityCode" />
      <el-table-column label="区域代码" align="center" prop="areaCode" />      
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />
   
  </div>
</template>

<script>
import { listOutput, getOutput, delOutput, addOutput, updateOutput } from "@/api/system/output";

export default {
  name: "Output",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // excel结果输出表格数据
      outputList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        phone: null,
        phone3: null,
        phone7: null,
        province: null,
        city: null,
        isp: null,
        postCode: null,
        cityCode: null,
        areaCode: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询excel结果输出列表 */
    getList() {
      this.loading = true;
      listOutput(this.queryParams).then(response => {
        this.outputList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 表单重置
    reset() {
      this.form = {
        phone: null,
        phone3: null,
        phone7: null,
        province: null,
        city: null,
        isp: null,
        postCode: null,
        cityCode: null,
        areaCode: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.phone)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },  
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/output/export', {
        ...this.queryParams
      }, `output_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
