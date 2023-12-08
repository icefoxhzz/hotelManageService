package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客请随同人员表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelBGuestFollower implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * hotel_guest_info表的id
     */
    private Integer infoId;

    /**
     * 名字
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 证件类型（字典表:  dict_certificate_type）
     */
    private Integer certificateType;

    /**
     * 证件号码
     */
    private String certificateCode;


}
