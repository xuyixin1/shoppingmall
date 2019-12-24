-- ----------------------------
-- Table structure for mall_business_account
-- ----------------------------
DROP TABLE IF EXISTS `mall_business_account`;
CREATE TABLE `mall_business_account` (
  `accountId` int(11) NOT NULL AUTO_INCREMENT COMMENT '公众号id',
  `name` varchar(50) DEFAULT NULL COMMENT '公众号名称',
  `token` varchar(100) DEFAULT NULL COMMENT '微信Token',
  `appId` varchar(100) DEFAULT NULL COMMENT '公总号AppId',
  `appSecret` varchar(100) DEFAULT NULL COMMENT '公众号 AppSecret',
  `accessToken` varchar(300) DEFAULT NULL COMMENT 'access_token',
  `accessTokenEndtime` int(11) DEFAULT NULL COMMENT 'access_token到期时间',
  `original` varchar(50) DEFAULT NULL COMMENT '原始帐号',
  `wxQrcodeUrl` varchar(200) DEFAULT NULL COMMENT '微信二维码',
  `createTime` datetime NOT NULL COMMENT '新增时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公众号基本信息表';


-- ----------------------------
-- Table structure for mall_business_template
-- ----------------------------
DROP TABLE IF EXISTS `mall_business_template`;
CREATE TABLE `mall_business_template` (
  `templateId` int(11) NOT NULL AUTO_INCREMENT,
  `informType` int(11) NOT NULL COMMENT '消息类型',
  `informId` varchar(255) NOT NULL COMMENT '微信模板id',
  `sendFlag` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`templateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for mall_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `mall_evaluate`;
CREATE TABLE `mall_evaluate` (
  `evaluateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `customerId` int(11) NOT NULL DEFAULT '0' COMMENT '粉丝ID',
  `minaId` int(11) NOT NULL DEFAULT '0' COMMENT '平台ID',
  `orderId` int(11) NOT NULL DEFAULT '0' COMMENT '订单编号',
  `classifyId` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000' COMMENT '一级分类ID',
  `secondClassifyId` int(11) NOT NULL DEFAULT '0' COMMENT '二级分类ID',
  `goodsId` int(11) NOT NULL DEFAULT '0' COMMENT '商品ID',
  `specId` int(11) NOT NULL DEFAULT '0' COMMENT '规格ID',
  `isAnonymous` int(1) DEFAULT '0' COMMENT '是否匿名（0为不匿名，1为匿名）',
  `evalLevel` int(1) NOT NULL DEFAULT '0' COMMENT '评论星级（1-5,分别为1星-5星: 1星:非常差;2星:差;3星;一般;4星:好;5星:非常好)',
  `evalContent` varchar(5000) DEFAULT NULL COMMENT '评论内容',
  `evalPic` varchar(1000) DEFAULT NULL COMMENT '评论图片',
  `evalTime` datetime NOT NULL COMMENT '评论时间',
  `storeReply` varchar(2000) DEFAULT NULL COMMENT '商家回复',
  `replyTime` datetime DEFAULT NULL COMMENT '商家回复时间',
  `deleteFlag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标识 0 未删除，1客户删除，2商家删除',
  PRIMARY KEY (`evaluateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


-- ----------------------------
-- Table structure for mall_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods`;
CREATE TABLE `mall_goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `minaId` int(11) NOT NULL COMMENT '平台id',
  `classifyId` int(11) NOT NULL COMMENT '一级分类id',
  `secondClassifyId` int(11) NOT NULL COMMENT '二级分类id',
  `goodsName` varchar(255) NOT NULL COMMENT '商品名称',
  `picUrl` varchar(255) NOT NULL COMMENT '图片url',
  `detailPicUrl` varchar(255) DEFAULT NULL COMMENT '产品图片url',
  `sailed` int(11) DEFAULT '0' COMMENT '已售出',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `saleFlag` int(11) NOT NULL DEFAULT '1' COMMENT '是否上架',
  `sort` int(11) NOT NULL COMMENT '排序',
  `description` varchar(4000) DEFAULT NULL COMMENT '产品描述',
  `deleteFlag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志(0:不删除;1:删除）',
  `parameters` text COMMENT '商品参数',
  `showPrice` decimal(10,2) NOT NULL COMMENT '展示价格(商品列表展示的价格）',
  `showFlag` int(4) NOT NULL DEFAULT '0' COMMENT '是否展示首页(0:不展示;1:展示)',
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';



-- ----------------------------
-- Table structure for mall_goods_attribute
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_attribute`;
CREATE TABLE `mall_goods_attribute` (
  `attributeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `minaId` int(11) NOT NULL COMMENT '小程序id',
  `secondClassifyId` int(11) NOT NULL COMMENT '二级分类id',
  `attributeName` varchar(255) NOT NULL DEFAULT '' COMMENT '属性名',
  `attributeValues` text NOT NULL COMMENT '属性值',
  PRIMARY KEY (`attributeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品属性';


-- ----------------------------
-- Table structure for mall_goods_cart
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_cart`;
CREATE TABLE `mall_goods_cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `customerId` int(11) NOT NULL COMMENT '粉丝id',
  `minaId` int(11) NOT NULL COMMENT '小程序id',
  `goodsId` int(11) DEFAULT NULL COMMENT '商品id',
  `goodsName` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `picUrl` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `specId` int(11) DEFAULT NULL COMMENT '规格id',
  `goodsNum` int(11) DEFAULT NULL COMMENT '商品数量',
  `goodsPirce` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `deleteFlag` int(2) DEFAULT NULL COMMENT '删除标识(0:不删除;1:删除)',
  `createDate` datetime DEFAULT NULL COMMENT '加入购物车时间',
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for mall_goods_classify
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_classify`;
CREATE TABLE `mall_goods_classify` (
  `classifyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `minaId` int(11) NOT NULL COMMENT '小程序id',
  `classifyName` varchar(255) NOT NULL COMMENT '分类名称',
  `sort` int(4) NOT NULL COMMENT '分类排序',
  PRIMARY KEY (`classifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品一级分类';


-- ----------------------------
-- Table structure for mall_goods_second_classify
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_second_classify`;
CREATE TABLE `mall_goods_second_classify` (
  `secondClassifyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级分类id',
  `minaId` int(11) NOT NULL COMMENT '小程序id',
  `classifyId` int(11) NOT NULL COMMENT '一级分类id',
  `secondClassifyName` varchar(255) NOT NULL COMMENT '二级分类名称',
  `classifyPictureUrl` varchar(255) DEFAULT NULL COMMENT '二级分类图片',
  `sort` int(11) NOT NULL COMMENT '排序',
  PRIMARY KEY (`secondClassifyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品二级分类';


-- ----------------------------
-- Table structure for mall_notification
-- ----------------------------
DROP TABLE IF EXISTS `mall_notification`;
CREATE TABLE `mall_notification` (
  `notificationId` int(11) NOT NULL AUTO_INCREMENT,
  `minaId` int(11) NOT NULL,
  `openId` varchar(255) NOT NULL COMMENT '微信用户id',
  `sendFlag` tinyint(4) NOT NULL DEFAULT '1' COMMENT '发送标识(0不发送)',
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `minaId` int(11) NOT NULL DEFAULT '0' COMMENT '平台id',
  `customerId` int(11) NOT NULL DEFAULT '0' COMMENT '粉丝id',
  `payType` int(11) NOT NULL DEFAULT '0' COMMENT '支付方式（现阶段只用微信支付）0：微信支付',
  `orderNumber` varchar(50) NOT NULL COMMENT '订单编号',
  `name` varchar(50) DEFAULT NULL COMMENT '联系人（不一定粉丝本人）',
  `phoneNumber` varchar(50) DEFAULT NULL COMMENT '联系方式（不一定粉丝本人）',
  `addressDetails` text COMMENT '收货地址i详情',
  `goodsDetails` text NOT NULL COMMENT '下单商品详情',
  `deliveryMoney` varchar(10) NOT NULL,
  `totalMoney` decimal(10,2) NOT NULL COMMENT '总价',
  `cancelReason` varchar(100) DEFAULT NULL COMMENT '用户取消订单理由',
  `refuseReason` varchar(8000) DEFAULT NULL COMMENT '商家拒绝退款理由',
  `drawbackReason` varchar(100) DEFAULT NULL COMMENT '用户退款理由',
  `orderStatus` int(11) NOT NULL DEFAULT '0' COMMENT '订单状态（0 :待支付、1：已支付、2：已完成、3：已超时、4：已取消、5：退款申请、6：退款成功、7.退款失败，8：拒绝退款，9：退款中，10支付中）',
  `remarks` varchar(300) DEFAULT NULL COMMENT '备注',
  `orderStartTime` datetime NOT NULL COMMENT '下单时间',
  `orderPayTime` datetime DEFAULT NULL COMMENT '支付时间',
  `orderRefundTime` datetime DEFAULT NULL COMMENT '申请退款时间',
  `orderEndTime` datetime DEFAULT NULL COMMENT '订单完成时间',
  `prepayId` varchar(50) DEFAULT NULL COMMENT '支付场景下，为本次支付的 prepay_id',
  `formId` varchar(50) DEFAULT NULL COMMENT '表单提交场景下，为 submit 事件带上的 form_id',
  `isEvaluate` int(4) NOT NULL DEFAULT '0' COMMENT '是否评价（0：未评价；1：已评价）',
  `employeeId` int(11) NOT NULL COMMENT '员工ID',
  `deleteFlag` int(4) NOT NULL DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='订单';


-- ----------------------------
-- Table structure for mall_order_address
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_address`;
CREATE TABLE `mall_order_address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `minaId` int(11) NOT NULL COMMENT '平台id',
  `customerId` int(11) NOT NULL COMMENT '粉丝id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `mobilePhone` varchar(20) DEFAULT NULL COMMENT '手机',
  `isDefault` int(2) DEFAULT NULL COMMENT '是否是默认地址(0:不是;1:是)',
  `provinces` varchar(255) DEFAULT NULL COMMENT '省市区街道',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `deleteFlag` int(2) DEFAULT NULL COMMENT '删除标识(0:不删除;1:删除)',
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for mall_slide
-- ----------------------------
DROP TABLE IF EXISTS `mall_slide`;
CREATE TABLE `mall_slide` (
  `slideId` int(11) NOT NULL AUTO_INCREMENT COMMENT '幻灯片id',
  `minaId` int(11) NOT NULL COMMENT '平台id',
  `slideName` varchar(255) NOT NULL COMMENT '幻灯片名称',
  `picUrl` varchar(255) NOT NULL COMMENT '幻灯片url',
  `useFlag` int(4) NOT NULL DEFAULT '0',
  `classifyId` int(11) DEFAULT NULL,
  `secondClassifyId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`slideId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for mall_specification
-- ----------------------------
DROP TABLE IF EXISTS `mall_specification`;
CREATE TABLE `mall_specification` (
  `specId` int(11) NOT NULL AUTO_INCREMENT COMMENT '规格',
  `minaId` int(11) NOT NULL COMMENT '小程序',
  `goodsId` int(11) NOT NULL COMMENT '商品',
  `attributeId1` int(11) NOT NULL COMMENT '属性1',
  `attributeIdName1` varchar(255) NOT NULL,
  `attributeValueName1` varchar(255) NOT NULL COMMENT '属性值1',
  `attributeId2` int(11) DEFAULT NULL COMMENT '属性2',
  `attributeIdName2` varchar(255) DEFAULT NULL,
  `attributeValueName2` varchar(255) DEFAULT NULL COMMENT '属性值2',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `stock` int(11) NOT NULL COMMENT '库存',
  `deleteFlag` int(2) DEFAULT 0 COMMENT '删除标识(0:不删除;1:删除)',
  PRIMARY KEY (`specId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='规格';




-- ----------------------------
-- Table structure for mall_template
-- ----------------------------
DROP TABLE IF EXISTS `mall_template`;
CREATE TABLE `mall_template` (
  `templateId` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `minaId` int(11) NOT NULL,
  `informType` int(11) NOT NULL COMMENT '消息类型',
  `informId` varchar(255) NOT NULL COMMENT '微信消息id',
  `sendFlag` int(11) DEFAULT '1' COMMENT '发送标志（0 发送 1不发送）',
  PRIMARY KEY (`templateId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='消息模板';



/*mysql 事件*/
CREATE DEFINER=`admin`@`%` EVENT `event_bc_mallOrder` ON SCHEDULE EVERY 1 MINUTE STARTS '2019-08-13 01:00:00' ON COMPLETION NOT PRESERVE ENABLE DO update mall_order set orderStatus = 3 where deleteFlag = 0 and orderStartTime < DATE_ADD(NOW(), INTERVAL -30 MINUTE) and  orderStatus = 0