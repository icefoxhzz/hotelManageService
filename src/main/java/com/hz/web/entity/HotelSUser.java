package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author saber
 * @since 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelSUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户信息表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    /**
     * 密码，md5
     */
    private String pwd;

    /**
     * 中文名
     */
    private String cname;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 1男0女
     */
    private Integer sex;

    private String email;

    /**
     * 用户图像
     */
    private String avatar;

    /**
     * 1正常，2 注销 3 锁定 4禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 排序
     */
    private Integer sort;

    private Integer isdel;

    private Integer emailHash;


}
