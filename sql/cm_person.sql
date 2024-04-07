SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cm_person
-- ----------------------------
DROP TABLE IF EXISTS `cm_person`;
CREATE TABLE `cm_person`  (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '人员ID',
  `unit_id` bigint(20) NOT NULL COMMENT '单位id',
  `depart_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `person_group` tinyint(2) NULL DEFAULT NULL COMMENT '组别',
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员编号',
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) NOT NULL COMMENT '性别',
  `birth_date` date NULL DEFAULT NULL COMMENT '出生日期',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `id_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `photo_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片路径',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `nation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `native_place` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `school` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后毕业的学校',
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `qualifications` tinyint(2) NULL DEFAULT NULL COMMENT '1：大专及以下  2：本科  3：硕士 4：博士',
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高学位',
  `political_belief` tinyint(2) NULL DEFAULT NULL COMMENT '政治面貌(\'1：中共党员 2：中共预备党员 3：共青团员  4：民革党员  5：民盟盟员  6：民建会员   7：民进会员  8：农工党党员   9：致公党党员  10：九三学社社员  11：台盟盟员 12：无党派人士  13：群众)',
  `post_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `safe_role` tinyint(255) NOT NULL DEFAULT 0 COMMENT '人员在企业中的安全角色 1：分管领导、3：安全总监、4：安全管理部门负责人、5：车间主任、6：安全管理人员、7：特种作业人员、9. 主要负责人',
  `hiredate` date NULL DEFAULT NULL COMMENT '入职时间',
  `work_experience` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作经历',
  `person_type` tinyint(2) NULL DEFAULT NULL COMMENT '1；外协员工\r\n2：临时人员\r\n3：员工',
  `del_flg` tinyint(2) NOT NULL COMMENT '0：正常 1逻辑删除',
  `create_id` bigint(20) NOT NULL COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_id` bigint(20) NOT NULL COMMENT '更新人id',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `hk_person_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海康平台人员id',
  `hk_person_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海康平台卡号',
  `is_apply` tinyint(1) NULL DEFAULT 0 COMMENT '是否为申请人1：是    0：否',
  `synchronization_status` tinyint(2) NULL DEFAULT NULL COMMENT '同步状态 0：否 1：是',
  `flag` tinyint(1) NULL DEFAULT NULL COMMENT '正常0   无照片1   未开卡2    ',
  `hk_face_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '海康平台人脸ID',
  `hk_handle_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:无人脸数据 1:增加人脸 2：修改人脸',
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5581 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公共-企业人员信息' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
