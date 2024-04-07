package cn.allbs.phototool.entity.cm;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * (cm_person)表实体类
 *
 * @author chenqi
 * @since 2024-04-07 10:33:38
 */
@Data
@TableName("cm_person")
public class CmPersonEntity {

    @TableId(value = "person_id", type = IdType.AUTO)
    private Long personId;

    private Long unitId;

    private Long departId;

    private String name;

    private Integer personGroup;

    private String code;

    private String tel;

    private String mobile;

    private Integer sex;

    private LocalDate birthDate;

    private String address;

    private String idCard;

    private String photoUrl;

    private String remark;

    private String nation;

    private String nativePlace;

    private String school;

    private String major;

    private Integer qualifications;

    private String degree;

    private Integer politicalBelief;

    private String postId;

    private Integer safeRole;

    private LocalDate hiredate;

    private String workExperience;

    private Integer personType;

    private Integer delFlg;

    private Long createId;

    private LocalDateTime createTime;

    private Long updateId;

    private LocalDateTime updateTime;

    private String hkPersonId;

    private String hkPersonCode;

    private Integer isApply;

    private Integer synchronizationStatus;

    private Integer flag;

    private String hkFaceId;

    private String hkHandleStatus;
}
