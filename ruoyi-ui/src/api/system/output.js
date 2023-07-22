import request from '@/utils/request'

// 查询excel结果输出列表
export function listOutput(query) {
  return request({
    url: '/system/output/list',
    method: 'get',
    params: query
  })
}

// 查询excel结果输出详细
export function getOutput(phone) {
  return request({
    url: '/system/output/' + phone,
    method: 'get'
  })
}

// 新增excel结果输出
export function addOutput(data) {
  return request({
    url: '/system/output',
    method: 'post',
    data: data
  })
}

// 修改excel结果输出
export function updateOutput(data) {
  return request({
    url: '/system/output',
    method: 'put',
    data: data
  })
}

// 删除excel结果输出
export function delOutput(phone) {
  return request({
    url: '/system/output/' + phone,
    method: 'delete'
  })
}
