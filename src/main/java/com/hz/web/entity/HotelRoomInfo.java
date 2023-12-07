package com.hz.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 房间信息表
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelRoomInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房间类型（字典表: dict_room_type）
     */
    private Integer roomType;

    /**
     * 楼层
     */
    private String floor;

    /**
     * 房号
     */
    private String room;

    /**
     * 朝向 (字典表:  dict_direction)
     */
    private Integer direction;

    /**
     * 租金RMB
     */
    private Float rent;

    /**
     * 物品清单
     */
    private String items;


}
