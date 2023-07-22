import request from '@/utils/request'

// 查询导入电话号列表
export function listInput(query) {
  return request({
    url: '/system/input/list',
    method: 'get',
    params: query
  })
}

// 查询导入电话号详细
export function getInput(phone) {
  return request({
    url: '/system/input/' + phone,
    method: 'get'
  })
}

// 新增导入电话号
export function addInput(data) {
  return request({
    url: '/system/input',
    method: 'post',
    data: data
  })
}

// 修改导入电话号
export function updateInput(data) {
  return request({
    url: '/system/input',
    method: 'put',
    data: data
  })
}

// 删除导入电话号
export function delInput(phone) {
  return request({
    url: '/system/input/' + phone,
    method: 'delete'
  })
}

// 下载导入模板
export function importTemplate() {
  return request({
    url: '/system/input/importTemplate',
    method: 'get'
  })
}