package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 租户费用设置表
 * </p>
 *
 * @author saber
 * @since 2023-12-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelBGuestService implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * dict_service表的id
     */
    private Integer serviceId;

    /**
     * 每月期数（执行次数）
     */
    private Integer monthTimes;

    /**
     * 缴费类型 （字典表: dict_service_pay_type）
     */
    private Integer servicePayType;

    /**
     * 缴费方式 （字典表: dict_service_pay_interval_type）
     */
    private Integer servicePayIntervalType;

    /**
     * 缴费日期
     */
    private LocalDateTime servicePayDate;


}
