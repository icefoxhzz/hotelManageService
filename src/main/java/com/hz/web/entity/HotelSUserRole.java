package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelSUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * hotel_s_user表的id
     */
    private Integer userId;

    /**
     * hotel_s_role表的id
     */
    private Integer roleId;


}
