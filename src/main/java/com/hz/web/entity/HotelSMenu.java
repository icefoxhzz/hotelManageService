package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author saber
 * @since 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelSMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;

    private String sysname;

    private String syscode;

    private String title;

    private String type;

    private String menukey;

    /**
     * 1启用 0禁用
     */
    private Integer status;

    private Integer isdefault;

    private Integer sort;

    private String style;

    private String icon;

    private String href;

    private String url;

    private String remark;


}
