package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客账表
 * </p>
 *
 * @author saber
 * @since 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelBGuestCheck implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * flat_guest_info表的id
     */
    private Integer guestInfoId;

    /**
     * 应缴费日期
     */
    private LocalDateTime payDate;

    /**
     * 是否已缴费
     */
    private Integer isPayed;

    /**
     * 费用类型(字典表: dict_check_type)
     */
    private Integer checkType;

    /**
     * 缴费日期
     */
    private LocalDateTime payedDate;


}
