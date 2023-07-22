import request from '@/utils/request'

// 查询手机区域对应列表
export function listLocation(query) {
  return request({
    url: '/system/location/list',
    method: 'get',
    params: query
  })
}

// 查询手机区域对应详细
export function getLocation(id) {
  return request({
    url: '/system/location/' + id,
    method: 'get'
  })
}

// 新增手机区域对应
export function addLocation(data) {
  return request({
    url: '/system/location',
    method: 'post',
    data: data
  })
}

// 修改手机区域对应
export function updateLocation(data) {
  return request({
    url: '/system/location',
    method: 'put',
    data: data
  })
}

// 删除手机区域对应
export function delLocation(id) {
  return request({
    url: '/system/location/' + id,
    method: 'delete'
  })
}
