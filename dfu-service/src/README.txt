---
swagger: "1.0"
info:
  description: DesireFU后端接口文档。
  version: 1.0.0
  title: DFU-API-DOC
host: gatesma.cn
basePath: /desirefu/v1
tags:
  - name: Account
    description: 账号接口
  - name: User
    description: 用户接口
  - name: Login
    description: 登录接口
  - name: Upload
    description: 文件上传接口
schemes:
  - http
paths:

  /user/bind_login:
    post:
      tags:
        - User
      summary: 用户绑定登录账号
      description: |
        用户绑定登录账号
      operationId: bindLogin
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 用户绑定login信息
          required: true
          schema:
            $ref: '#/definitions/BindUserLoginRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /user/unbind_login:
    post:
      tags:
        - User
      summary: 用户解绑登录账号
      description: |
        用户解绑登录账号
      operationId: unBindLogin
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 用户绑定login信息
          required: true
          schema:
            $ref: '#/definitions/UnBindUserLoginRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /user/get_bind:
    post:
      tags:
        - User
      summary: 查询用户绑定的账号
      description: 查询用户绑定的账号
      operationId: getBindByUser
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 查询绑定信息
          required: true
          schema:
            $ref: '#/definitions/GetUserBindRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/GetBindRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /user/add:
    post:
      tags:
        - User
      summary: 创建用户
      description: |
        创建用户，返回"用户ID"
      operationId: addUser
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 创建用户
          required: true
          schema:
            $ref: '#/definitions/AddUserRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/AddUserRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /user/get:
    post:
      tags:
        - User
      summary: 查询用户
      description: 查询用户
      operationId: getUser
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 查询用户
          required: true
          schema:
            $ref: '#/definitions/GetUserRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/GetUserRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found

  /account/add:
    post:
      tags:
        - Account
      summary: 创建账号
      description: 创建账号
      operationId: addAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 创建账号
          required: true
          schema:
            $ref: '#/definitions/AddAccountRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/AddAccountRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/get:
    post:
      tags:
        - Account
      summary: 查询账号信息(DB)
      description: 查询账号信息(DB)
      operationId: getAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 查询账号
          required: true
          schema:
            $ref: '#/definitions/GetAccountRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/GetAccountRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/update:
    post:
      tags:
        - Account
      summary: 更新账号
      description: |
        注意：
          1. 只有账号状态待审核和审核拒绝时才能对账号进行修改。
          2. 参数中字段为null或字段缺失，不会覆盖当前字段值。
          3. 参数中字段为“”,会覆盖当前字段值。
          4. 修改account_contacts时，会根据contact_id修改、删除（delete_status置为1）对应联系人信息。若未指定contact_id,则新增联系人。参数为[],不会覆盖当前字段。
      operationId: updateAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 更新账号
          required: true
          schema:
            $ref: '#/definitions/UpdateAccountRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/delete:
    post:
      tags:
        - Account
      summary: 删除账号
      description: |
        注意: 同时删除新旧库账号数据，更新删除状态字段为已删除。
      operationId: deleteAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 删除账号
          required: true
          schema:
            $ref: '#/definitions/AccountDeleteRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/bind:
    post:
      tags:
        - Account
      summary: 建立用户账号绑定关系
      description: 建立用户账号绑定关系
      operationId: bindUserAccountRole
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 绑定用户、角色
          required: true
          schema:
            $ref: '#/definitions/BindUserAccountRoleRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/BindRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/get_bind:
    post:
      tags:
        - Account
      summary: 查询用户账号绑定关系
      description: 查询用户账号绑定关系
      operationId: getBindByAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 查询绑定信息
          required: true
          schema:
            $ref: '#/definitions/GetAccountBindRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/GetBindRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /account/unbind:
    post:
      tags:
        - Account
      summary: 解除用户账号绑定关系
      description: 解除用户账号绑定关系
      operationId: unBindAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 解除绑定信息
          required: true
          schema:
            $ref: '#/definitions/UnbindAccountUserRoleRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found

  /account/audit:
    post:
      tags:
        - Account
      summary: 审核账号
      description: 审核账号
      operationId: auditAccount
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          description: 审核账号
          required: true
          schema:
            $ref: '#/definitions/AuditAccountRequest'
      responses:
        200:
          description: OK
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found

  /upload/upload_file:
    post:
      tags:
        - Upload
      description: 文件上传
      operationId: uploadFile
      consumes:
        - multipart/form-data
      produces:
        - application/json
      parameters:
        - name: account_id
          in: formData
          required: true
          type: integer
          format: int64
        - name: account_type
          in: formData
          required: true
          type: integer
          format: int32
        - name: file_name
          in: formData
          required: false
          type: string
        - name: file_type
          in: formData
          required: false
          type: string
          enum:
            - IMG
            - PDF
        - name: file_signature
          in: formData
          required: false
          type: string
        - name: upfile
          in: formData
          required: true
          type: file
      responses:
        200:
          description: Ok
          schema:
            $ref: '#/definitions/UploadFileRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /upload/find_upload_file:
    post:
      tags:
        - Upload
      description: 获取用户上传的文件列表
      operationId: findUploadFile
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: true
          schema:
            $ref: '#/definitions/FindUploadFileModel'
      responses:
        200:
          description: Ok
          schema:
            $ref: '#/definitions/FindUploadFileRet'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found
  /upload/delete_upload_file:
    post:
      tags:
        - Upload
      description: 删除用户上传文件
      operationId: deleteUploadFile
      consumes:
        - application/json
      produces:
        - application/json
      parameters:
        - in: body
          name: body
          required: true
          schema:
            $ref: '#/definitions/DeleteUploadFileModel'
      responses:
        200:
          description: Ok
          schema:
            $ref: '#/definitions/ReturnCode'
        400:
          description: Invalid RequestBody supplied
        404:
          description: RequestBody not found


definitions:
  Object:
    type: object
  ReturnCode:
    type: object
    required:
      - code
      - message
    properties:
      code:
        type: integer
        format: int32
        example: 0
      message:
        type: string
        example: OK
  Page:
    properties:
      page_num:
        type: integer
        format: int32
        description: 页号
        minimum: 1
        default: 1
      page_size:
        type: integer
        format: int32
        description: 每页数据量
        minimum: 1
        default: 10
  PageInfo:
    properties:
      page_num:
        type: integer
        format: int32
        description: 当前页号
      page_size:
        type: integer
        format: int32
        description: 当前页数据量
      total_page:
        type: integer
        format: int32
        description: 总共页数
      total_count:
        type: integer
        format: int32
        description: 总共数据量
  Login:
    required:
      - login_name
      - login_name_type
    properties:
      login_name:
        type: string
        example: "78837721"
        description: 登录账号名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 登录账号类型
      uin:
        type: string
        example: wid_syndekas34mnsj
        description: 微信或QQ对应的openID
    description: 登录信息
  LoginInfo:
    properties:
      login_name:
        type: string
        example: "78837721"
        description: 登录账号名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 登录账号类型
      uin:
        type: string
        example: "wx112341"
        description: loginNameType=12时，此字段为原始wx号
    description: 登录信息
  BindUserLoginRequest:
    required:
      - login_name
      - login_name_type
      - user_id
    properties:
      user_id:
        type: integer
        format: int64
        example: 1899211
        description: userId
      login_name:
        type: string
        example: "78837721"
        description: 登录账号名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 登录账号类型
      operator_user_id:
        type: integer
        format: int64
        example: 23432234
        description: 操作者的userId 非必填
    title: BindUserLoginRequest
  GetUserBindRequest:
    properties:
      user_id:
        type: integer
        format: int64
        example: 17998828
        description: 用户ID
      login_name:
        type: string
        description: 用户登录名称
      login_name_type:
        type: integer
        format: int32
        description: 用户登录类型
      role:
        type: integer
        format: int32
        example: 2
        description: 用户角色
      account_type:
        type: integer
        format: int32
        description: 账号类型
  UnBindUserLoginRequest:
    required:
      - login_name
      - login_name_type
      - user_id
    properties:
      user_id:
        type: integer
        format: int64
        example: 1899211
        description: userId
      login_name:
        type: string
        example: "78837721"
        description: 登录账号名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 登录账号类型（qzap_common.proto中LoginNameType）
      operator_user_id:
        type: integer
        format: int64
        example: 23432234
        description: 操作者的userId 非必填
    title: UnBindUserLoginRequest
  AddUserRequest:
    required:
      - login_name
      - login_name_type
    properties:
      login_name:
        type: string
        description: 登录账号名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 登录账号类型
      user_name:
        type: string
        description: 用户名称
      cellphone:
        type: string
        description: 手机号码
      email:
        type: string
        description: 邮箱
      created_user_id:
        type: integer
        format: int64
        example: 3453454
        description: 创建者userId
    title: AddUserRequest
  GetUserRequest:
    properties:
      user_id:
        type: integer
        format: int64
        example: 17998821
        description: 用户登录信息 (login_name, login_name_type) 和 user_id两个必填一个
      login_name:
        type: string
        example: "78837721"
        description: 用户登录名称
      login_name_type:
        type: integer
        format: int32
        example: 1
        description: 用户登录类型
  User:
    allOf:
      - $ref: '#/definitions/Login'
      - properties:
          user_id:
            type: integer
            format: int64
            example: 17998821
            description: 用户ID
            readOnly: true
          logins:
            type: array
            description: 所有login信息，包括绑定的
            items:
              $ref: '#/definitions/LoginInfo'
          user_name:
            type: string
            description: 用户名称
          cellphone:
            type: string
            description: 手机号码
          email:
            type: string
            description: 邮箱
          delete_status:
            type: integer
            format: int32
            example: 0
            description: 删除状态
            readOnly: true
          created_time:
            type: string
            example: '2018-01-01 12:00:00'
            description: 创建时间，格式：yyyy-MM-dd HH:mm:ss
            readOnly: true
          last_modified_user_id:
            type: integer
            format: int64
            example: 3453334
            description: 最后修改人userId
          last_modified_time:
            type: string
            example: '2018-01-02 13:20:15'
            description: 最后修改时间，格式：yyyy-MM-dd HH:mm:ss
            readOnly: true
    description: 用户
  GetUserRet:
    allOf:
      - $ref: '#/definitions/ReturnCode'
      - properties:
          data:
            $ref: '#/definitions/User'
  GetBindRet:
    allOf:
      - $ref: '#/definitions/ReturnCode'
      - properties:
          data:
            type: array
            items:
              $ref: '#/definitions/BindInfo'
  BindInfo:
    properties:
      account_role_id:
        type: integer
        format: int64
        description: 账号角色id（主键）
      account_id:
        type: integer
        format: int64
        description: 账号id
      account_type:
        type: integer
        format: int32
        description: 账号类型（qzap_common.proto中ServiceAccountType）
      user_id:
        type: integer
        format: int64
        description: 用户id
      login_name:
        type: string
        description: 用户登录名称
      login_name_type:
        type: integer
        format: int32
        description: 用户登录类型（qzap_common.proto中LoginNameType）
      logins:
        type: array
        items:
          $ref: '#/definitions/LoginInfo'
      role:
        type: integer
        format: int32
        description: 角色id（qzap_common.proto中OperatorRole）
      uin:
        type: string
        example: wid_syndekas34mnsj
        description: 当login_name_type=12时，login_name里是微信对应的openID，需要在uin中返回原始微信的ID
  AddAccountRequest:
    required:
      - account_type
    properties:
      account_type:
        type: integer
        format: int32
        example: 1
        description: 创建的账号类型
      root_user_id:
        type: integer
        format: int64
        example: 7
        description: 该账号的Root角色用户ID
      account_nick_name:
        type: string
        example: 腾讯
        description: 账号名称
      memo:
        type: string
        example: 为广告主提供创意模板
        description: 备注
      created_user_id:
        type: integer
        format: int64
        example: 3948855
        description: 创建人userId
