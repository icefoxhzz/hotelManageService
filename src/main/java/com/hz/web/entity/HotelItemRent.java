package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 租户物品租赁表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelItemRent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * flat_guest_info表的id
     */
    private Integer guestInfoId;

    /**
     * 物品名称
     */
    private String itemName;

    /**
     * 物品价格
     */
    private Float itemPrice;

    /**
     * 租赁日期
     */
    private LocalDateTime rentDate;

    /**
     * 租赁天数
     */
    private Integer rentDays;

    /**
     * 归还日期
     */
    private LocalDateTime giveBackDate;

    /**
     * 是否归还
     */
    private Integer isGaveBack;


}
