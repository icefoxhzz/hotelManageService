package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客情表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelBGuestInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 户主，多个用逗号隔开
     */
    private String masters;

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

    /**
     * 房型（字典表:  dict_room_type）
     */
    private Integer roomType;

    /**
     * 房间级别 （字典表:  dict_room_level）
     */
    private Integer roomLevel;

    /**
     * 房号
     */
    private String roomNumber;

    /**
     * 起租时间
     */
    private LocalDateTime startTime;

    /**
     * 退租时间
     */
    private LocalDateTime endTime;

    /**
     * 业务员（系统登录用户名）
     */
    private String username;

    /**
     * 收租方式 - 押 （字典表: dict_rent_type_bet）
     */
    private Integer rentTypeBet;

    /**
     * 收租方式 - 付（字典表: dict_rent_type_pay）
     */
    private Integer rentTypePay;

    /**
     * 收租方式 - 收租间隔（字典表: dict_rent_type_interval）
     */
    private Integer rentTypeInterval;

    /**
     * 合约单位
     */
    private String contractEnterprise;

    /**
     * 折扣率百分比
     */
    private Float discountRate;

    /**
     * 执行房价
     */
    private Float roomPrice;

    /**
     * 支付方式（字典表：dict_rent_pay_type）
     */
    private Integer payType;

    /**
     * 支付百分比 - 个人
     */
    private Float payPercentPerson;

    /**
     * 支付百分比 - 单位
     */
    private Float payPercentEnterprise;

    /**
     * 房间租赁总价
     */
    private Float roomPriceTotal;

    /**
     * 附件路径
     */
    private String filePath;


}
