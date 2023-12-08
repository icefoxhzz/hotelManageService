package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色菜单权限表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelSRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * hotel_s_menu表的id
     */
    private Integer menuId;


}
