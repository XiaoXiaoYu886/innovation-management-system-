-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: springbootav3nz20q
-- ------------------------------------------------------
-- Server version	5.7.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `springbootav3nz20q`
--

/*!40000 DROP DATABASE IF EXISTS `springbootav3nz20q`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `springbootav3nz20q` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springbootav3nz20q`;

--
-- Table structure for table `chatmessage`
--

DROP TABLE IF EXISTS `chatmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmessage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `content` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `format` int(11) DEFAULT NULL COMMENT '格式(1:文字，2:图片)',
  `isread` int(11) DEFAULT '0' COMMENT '消息已读(0:未读，1:已读)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='消息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmessage`
--

LOCK TABLES `chatmessage` WRITE;
/*!40000 ALTER TABLE `chatmessage` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chengguoleixing`
--

DROP TABLE IF EXISTS `chengguoleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chengguoleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `chengguoleixing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '成果类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='成果类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chengguoleixing`
--

LOCK TABLES `chengguoleixing` WRITE;
/*!40000 ALTER TABLE `chengguoleixing` DISABLE KEYS */;
INSERT INTO `chengguoleixing` VALUES (1,'2026-03-06 15:33:22','成果转化'),(2,'2026-03-06 15:33:22','成果转化'),(3,'2026-03-06 15:33:22','学术论文'),(4,'2026-03-06 15:33:22','专著/教材'),(5,'2026-03-06 15:33:22','专利'),(6,'2026-03-06 15:33:22','专利'),(7,'2026-03-06 15:33:22','科研项目'),(8,'2026-03-06 15:33:22','科研项目');
/*!40000 ALTER TABLE `chengguoleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuangyexiangmu`
--

DROP TABLE IF EXISTS `chuangyexiangmu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuangyexiangmu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `yanjiumubiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '研究目标',
  `hexinyaosu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核心要素',
  `xiangmufengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目封面',
  `xiangmufujian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目附件',
  `xiangmuxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目详情',
  `zhaomuyaoqiu` longtext COLLATE utf8mb4_unicode_ci COMMENT '招募要求',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `xuehao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `zhiwei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='创业项目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuangyexiangmu`
--

LOCK TABLES `chuangyexiangmu` WRITE;
/*!40000 ALTER TABLE `chuangyexiangmu` DISABLE KEYS */;
INSERT INTO `chuangyexiangmu` VALUES (1,'2026-03-06 15:33:22','乡村直播','数字乡村','主播培训-供应链整合-直播运营','短视频算法','upload/chuangyexiangmu_乡村直播1.jpg,upload/chuangyexiangmu_乡村直播2.jpg,upload/chuangyexiangmu_乡村直播3.jpg','','培训农民通过直播电商销售特色农产品','招募要求1','2026-03-06','2023002','赵阳','负责人','是','',1,1),(2,'2026-03-06 15:33:22','数字文旅','旅游服务','AR内容制作-导览系统开发-景区合作','AR识别技术','upload/chuangyexiangmu_数字文旅1.jpg,upload/chuangyexiangmu_数字文旅2.jpg,upload/chuangyexiangmu_数字文旅3.jpg','','AR眼镜提供景区历史文化实时增强现实导览','招募要求2','2026-03-06','2023011','林书豪','负责人','是','',2,2),(3,'2026-03-06 15:33:22','合成生物','生物医药','基因编辑-蛋白表达-酶活测定','CRISPR技术','upload/chuangyexiangmu_合成生物1.jpg,upload/chuangyexiangmu_合成生物2.jpg,upload/chuangyexiangmu_合成生物3.jpg','','研发用于洗涤剂工业的基因工程酶制剂','招募要求3','2026-03-06','2023006','李思远','负责人','是','',3,3),(4,'2026-03-06 15:33:22','宠物智能','消费电子','产品设计-传感器集成-APP开发','低功耗蓝牙','upload/chuangyexiangmu_宠物智能1.jpg,upload/chuangyexiangmu_宠物智能2.jpg,upload/chuangyexiangmu_宠物智能3.jpg','','宠物穿戴设备监测活动量睡眠质量等健康数据','招募要求4','2026-03-06','2023008','周雪','负责人','是','',4,4),(5,'2026-03-06 15:33:22','教育VR','在线教育','课程开发-VR内容制作-平台上线','VR建模技术','upload/chuangyexiangmu_教育VR1.jpg,upload/chuangyexiangmu_教育VR2.jpg,upload/chuangyexiangmu_教育VR3.jpg','','通过VR技术构建沉浸式学科教学场景','招募要求5','2026-03-06','2023004','胡宇','负责人','是','',5,5),(6,'2026-03-06 15:33:22','清洁技术','新能源','技术研发-设备制造-工程安装','催化分解技术','upload/chuangyexiangmu_清洁技术1.jpg,upload/chuangyexiangmu_清洁技术2.jpg,upload/chuangyexiangmu_清洁技术3.jpg','','研发工业有机废气催化燃烧处理设备','招募要求6','2026-03-06','2023009','徐天宇','负责人','是','',6,6),(7,'2026-03-06 15:33:22','健康餐配','餐饮服务','用户调研-菜单开发-冷链配送','营养数据库','upload/chuangyexiangmu_健康餐配1.jpg,upload/chuangyexiangmu_健康餐配2.jpg,upload/chuangyexiangmu_健康餐配3.jpg','','根据用户健康数据定制每日营养套餐','招募要求7','2026-03-06','2023012','王若曦','负责人','是','',7,7),(8,'2026-03-06 15:33:22','智慧养老','养老服务','设备安装-数据监控-应急响应','多模态传感器','upload/chuangyexiangmu_智慧养老1.jpg,upload/chuangyexiangmu_智慧养老2.jpg,upload/chuangyexiangmu_智慧养老3.jpg','','通过智能设备实时监测老年人健康数据','招募要求8','2026-03-06','2023014','刘芳','负责人','是','',8,8);
/*!40000 ALTER TABLE `chuangyexiangmu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chuangyeziyuan`
--

DROP TABLE IF EXISTS `chuangyeziyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuangyeziyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ziyuanmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源名称',
  `ziyuanleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类型',
  `ziyuanfengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '资源封面',
  `tigongdanwei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '提供单位',
  `suoshuxingye` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业',
  `ziyuanmiaoshu` longtext COLLATE utf8mb4_unicode_ci COMMENT '资源描述',
  `shenqingliucheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '申请流程',
  `shenqingtiaojian` longtext COLLATE utf8mb4_unicode_ci COMMENT '申请条件',
  `gengxinshijian` date DEFAULT NULL COMMENT '更新时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `clicktime` datetime DEFAULT NULL COMMENT '最近点击时间',
  `clicknum` int(11) DEFAULT '0' COMMENT '点击次数',
  `discussnum` int(11) DEFAULT '0' COMMENT '评论数',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='创业资源';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuangyeziyuan`
--

LOCK TABLES `chuangyeziyuan` WRITE;
/*!40000 ALTER TABLE `chuangyeziyuan` DISABLE KEYS */;
INSERT INTO `chuangyeziyuan` VALUES (1,'2026-03-06 15:33:22','工业设计共享平台','技术资源','upload/chuangyeziyuan_工业设计共享平台1.jpg,upload/chuangyeziyuan_工业设计共享平台2.jpg,upload/chuangyeziyuan_工业设计共享平台3.jpg','创意设计产业联盟','工业设计','提供产品外观设计结构优化人机交互设计等定制服务','需求提交→方案沟通→设计初稿→修改完善→成果交付','明确产品定位及设计需求','2026-03-06','文化传媒公司','2026-03-06 23:33:22',1,0,1),(2,'2026-03-06 15:33:22','新能源汽车充电桩创业扶持','政策资源','upload/chuangyeziyuan_新能源汽车充电桩创业扶持1.jpg,upload/chuangyeziyuan_新能源汽车充电桩创业扶持2.jpg,upload/chuangyeziyuan_新能源汽车充电桩创业扶持3.jpg','发改委能源局','新能源汽车','提供设备补贴场地协调电网接入审批绿色通道','项目备案→场地确认→设备采购→审批安装','具备场地资源及运营资质','2026-03-06','科技公司','2026-03-06 23:33:22',2,0,2),(3,'2026-03-06 15:33:22','数字文创版权服务平台','服务资源','upload/chuangyeziyuan_数字文创版权服务平台1.jpg,upload/chuangyeziyuan_数字文创版权服务平台2.jpg,upload/chuangyeziyuan_数字文创版权服务平台3.jpg','文化创意产业协会','文化创意','提供版权登记保护侵权监测IP商业化对接服务','需求提交→材料审核→版权登记→服务对接','拥有原创文创作品或IP','2026-03-06','运营管理公司','2026-03-06 23:33:22',3,0,3),(4,'2026-03-06 15:33:22','AI算法开源社区','技术资源','upload/chuangyeziyuan_AI算法开源社区1.jpg,upload/chuangyeziyuan_AI算法开源社区2.jpg,upload/chuangyeziyuan_AI算法开源社区3.jpg','人工智能产业研究院','人工智能','开放机器学习框架计算机视觉算法自然语言处理工具包','注册认证→需求提交→技术对接→合作落地','具备基础算法研发能力','2026-03-06','互联网公司','2026-03-06 23:33:22',4,0,4),(5,'2026-03-06 15:33:22','绿色能源创业基金','投资资源','upload/chuangyeziyuan_绿色能源创业基金1.jpg,upload/chuangyeziyuan_绿色能源创业基金2.jpg,upload/chuangyeziyuan_绿色能源创业基金3.jpg','碳中和投资集团','新能源','提供500万-2亿元股权融资及产业链资源对接','商业计划书投递→初步筛选→路演答辩→尽职调查→投资签约','拥有成熟技术方案及商业模式','2026-03-06','销售公司','2026-03-06 23:33:22',5,0,5),(6,'2026-03-06 15:33:22','乡村振兴创业扶持计划','政策资源','upload/chuangyeziyuan_乡村振兴创业扶持计划1.jpg,upload/chuangyeziyuan_乡村振兴创业扶持计划2.jpg,upload/chuangyeziyuan_乡村振兴创业扶持计划3.jpg','农业农村发展局','现代农业','提供场地补贴技术指导农产品产销对接资金扶持','项目申报→材料审核→实地核查→立项公示','聚焦农产品种植加工或乡村旅游','2026-03-06','科技有限公司','2026-03-06 23:33:22',6,0,6),(7,'2026-03-06 15:33:22','区块链技术应用平台','技术资源','upload/chuangyeziyuan_区块链技术应用平台1.jpg,upload/chuangyeziyuan_区块链技术应用平台2.jpg,upload/chuangyeziyuan_区块链技术应用平台3.jpg','区块链产业研究院','区块链','提供联盟链搭建智能合约开发数据存证等技术服务','需求沟通→方案设计→技术开发→上线运维','具备明确应用场景及业务需求','2026-03-06','数据分析公司','2026-03-06 23:33:22',7,0,7),(8,'2026-03-06 15:33:22','中小企业数字化转型补贴','政策资源','upload/chuangyeziyuan_中小企业数字化转型补贴1.jpg,upload/chuangyeziyuan_中小企业数字化转型补贴2.jpg,upload/chuangyeziyuan_中小企业数字化转型补贴3.jpg','中小企业服务局','全行业','提供数字化改造资金补贴软件采购折扣技术培训','项目申报→需求审核→方案评估→补贴发放','具备数字化转型需求及基础运营条件','2026-03-06','物流公司','2026-03-06 23:33:22',8,0,8);
/*!40000 ALTER TABLE `chuangyeziyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '配置参数名称',
  `value` varchar(200) DEFAULT NULL COMMENT '配置参数值',
  `url` varchar(500) DEFAULT NULL COMMENT 'url',
  `type` int(11) DEFAULT NULL COMMENT '参数类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='配置文件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'picture1','upload/picture1.jpg',NULL,1),(2,'picture2','upload/picture2.jpg',NULL,1),(3,'picture3','upload/picture3.jpg',NULL,1),(11,'baidu','{\"appId\":\"49214550\",\"apiKey\":\"7Otjpv2kn0ljQk45qXOXh5MO\",\"secretKey\":\"BMfbXRbTIVaB4C3SbRTtGqDv1wHDvyXS\"}',NULL,2),(21,'bLoginBackgroundImg','',NULL,3),(22,'bRegisterBackgroundImg','',NULL,3),(23,'bIndexBackgroundImg','',NULL,3),(24,'bTopLogo','',NULL,3),(25,'bHomeLogo','',NULL,3),(26,'fLoginBackgroundImg','',NULL,3),(27,'fRegisterBackgroudImg','',NULL,3),(28,'fTopLogo','',NULL,3);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discusschuangyeziyuan`
--

DROP TABLE IF EXISTS `discusschuangyeziyuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discusschuangyeziyuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `refid` bigint(20) NOT NULL COMMENT '关联表id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `avatarurl` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `nickname` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `thumbsupnum` int(11) DEFAULT '0' COMMENT '赞',
  `crazilynum` int(11) DEFAULT '0' COMMENT '踩',
  `istop` int(11) DEFAULT '0' COMMENT '置顶(1:置顶,0:非置顶)',
  `tuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '赞用户ids',
  `cuserids` longtext COLLATE utf8mb4_unicode_ci COMMENT '踩用户ids',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='创业资源评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discusschuangyeziyuan`
--

LOCK TABLES `discusschuangyeziyuan` WRITE;
/*!40000 ALTER TABLE `discusschuangyeziyuan` DISABLE KEYS */;
/*!40000 ALTER TABLE `discusschuangyeziyuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `friend`
--

DROP TABLE IF EXISTS `friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `uid` bigint(20) NOT NULL COMMENT '用户ID',
  `fid` bigint(20) NOT NULL COMMENT '好友用户ID',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `alias` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '别名',
  `type` int(11) DEFAULT '0' COMMENT '类型(0:好友申请，1:好友，2:消息)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='好友表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friend`
--

LOCK TABLES `friend` WRITE;
/*!40000 ALTER TABLE `friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoleixing`
--

DROP TABLE IF EXISTS `gonggaoleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gonggaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公告类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoleixing`
--

LOCK TABLES `gonggaoleixing` WRITE;
/*!40000 ALTER TABLE `gonggaoleixing` DISABLE KEYS */;
INSERT INTO `gonggaoleixing` VALUES (1,'2026-03-06 15:33:21','会议管理'),(2,'2026-03-06 15:33:21','科研经费报销初审'),(3,'2026-03-06 15:33:21','会议管理'),(4,'2026-03-06 15:33:21','会议管理'),(5,'2026-03-06 15:33:21','科研经费报销初审'),(6,'2026-03-06 15:33:21','科研经费报销初审'),(7,'2026-03-06 15:33:21','科研通知发布'),(8,'2026-03-06 15:33:21','公文流转');
/*!40000 ALTER TABLE `gonggaoleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonggaoxinxi`
--

DROP TABLE IF EXISTS `gonggaoxinxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gonggaoxinxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `gonggaoleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公告类型',
  `jianjie` longtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `fengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `neirong` longtext COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `fabushijian` datetime DEFAULT NULL COMMENT '发布时间',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公告信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonggaoxinxi`
--

LOCK TABLES `gonggaoxinxi` WRITE;
/*!40000 ALTER TABLE `gonggaoxinxi` DISABLE KEYS */;
INSERT INTO `gonggaoxinxi` VALUES (1,'2026-03-06 15:33:21','2024高校科创合作交流研讨会筹备会议','会议管理','筹备高校科创合作交流研讨会，明确会议时间、参会人员、议程安排及各部门分工','upload/gonggaoxinxi_fengmian1.jpg,upload/gonggaoxinxi_fengmian2.jpg,upload/gonggaoxinxi_fengmian3.jpg','会议定于2024年11月25日9:00-16:00在学校国际会议中心召开，参会人员为校领导、各院系科研负责人、校外合作企业代表；会议议程含科创成果展示、校企合作洽谈、专家讲座等；科研处负责整体统筹，校办负责会务接待，宣传部负责宣传报道，各院系需于11月10日前上报参会人员及成果展示材料','2026-03-06 23:33:21',1),(2,'2026-03-06 15:33:21','2024年11月科研经费报销初审补充通知','科研经费报销初审','发布11月科研经费报销初审补充通知，新增特殊经费支出初审要求及绿色通道申请规则','upload/gonggaoxinxi_fengmian2.jpg,upload/gonggaoxinxi_fengmian3.jpg,upload/gonggaoxinxi_fengmian4.jpg','针对设备采购、外委测试等特殊经费支出，需额外提交采购合同、测试协议等佐证材料；为保障重大科研项目进度，开设经费报销绿色通道，符合条件的项目需提交绿色通道申请表，经院系及科研处审批后可优先初审；本次初审受理时间为11月20-28日，材料提交要求不变，逾期不再受理本年度补充报销','2026-03-06 23:33:21',2),(3,'2026-03-06 15:33:21','科研处部门周工作例会','会议管理','召开科研处周工作例会，总结上周工作完成情况，部署本周重点工作任务','upload/gonggaoxinxi_fengmian3.jpg,upload/gonggaoxinxi_fengmian4.jpg,upload/gonggaoxinxi_fengmian5.jpg','会议于2024年10月21日上午8:30在科研处会议室召开，参会人员为科研处全体工作人员；总结上周校级项目材料接收、经费初审、公文流转等工作完成情况，梳理未办结事项；本周重点工作为推进结题验收材料初审、组织国家级项目预申报指导、筹备科创研讨会、完成9-10月经费报销初审汇总','2026-03-06 23:33:21',3),(4,'2026-03-06 15:33:21','校企合作科研项目推进会','会议管理','召开校企合作科研项目推进会，协调解决项目推进中的问题，明确后续工作节点','upload/gonggaoxinxi_fengmian4.jpg,upload/gonggaoxinxi_fengmian5.jpg,upload/gonggaoxinxi_fengmian6.jpg','会议于2024年10月28日下午14:00召开，参会人员为科研处、相关院系负责人及校企合作项目负责人；各项目负责人汇报项目进度、经费使用、成果产出及当前存在的问题；针对设备调试、数据对接、成果验收等问题进行现场协调，明确各问题解决责任方及完成时限，要求各项目按计划推进，确保按期完成合作任务','2026-03-06 23:33:21',4),(5,'2026-03-06 15:33:21','2024年第四季度科研经费使用情况初审核查','科研经费报销初审','开展2024年第四季度科研经费使用情况初审核查，重点核查经费使用合规性、预算执行进度','upload/gonggaoxinxi_fengmian5.jpg,upload/gonggaoxinxi_fengmian6.jpg,upload/gonggaoxinxi_fengmian7.jpg','本次核查覆盖全校各类在研科研项目，通过查阅经费使用明细、发票、报销单据等材料，核查经费是否专款专用、是否符合预算要求、审批流程是否完整；针对预算执行进度滞后、经费使用不规范的项目，下发整改通知书，要求项目负责人于11月30日前完成整改；科研处将形成核查报告，上报校财务工作领导小组，作为后续科研经费拨付依据','2026-03-06 23:33:21',5),(6,'2026-03-06 15:33:21','2024年9-10月科研经费报销初审工作安排','科研经费报销初审','明确2024年9-10月科研经费报销初审时间、材料规范及提交方式，说明初审重点','upload/gonggaoxinxi_fengmian6.jpg,upload/gonggaoxinxi_fengmian7.jpg,upload/gonggaoxinxi_fengmian8.jpg','本次报销初审受理时间为2024年10月23日-11月3日（工作日9:00-11:30、14:30-17:00），需提交报销单据、经费使用明细、发票原件及相关佐证材料，材料需按要求粘贴并签字盖章；初审重点核查发票真实性、经费使用是否符合项目预算、审批流程是否完整，初审合格后统一报送财务处，不合格材料退回补正','2026-03-06 23:33:21',6),(7,'2026-03-06 15:33:21','关于开展校级科研创新团队评选工作的通知','科研通知发布','启动2024年度校级科研创新团队评选，明确评选条件、申报材料及评审流程','upload/gonggaoxinxi_fengmian7.jpg,upload/gonggaoxinxi_fengmian8.jpg,upload/gonggaoxinxi_fengmian1.jpg','评选面向校内从事科研工作的团队，要求团队结构合理、研究方向明确、近3年有标志性科研成果；申报需提交评选申报表、团队研究成果证明、发展规划等材料，申报时间为2024年10月25日-11月15日；评审采用材料评审+现场答辩形式，获评团队将获得专项科研经费支持及政策倾斜','2026-03-06 23:33:21',7),(8,'2026-03-06 15:33:21','关于报送2024年度科研工作年度总结的公文','公文流转','下发报送2024年度科研工作年度总结的公文，明确总结内容、报送格式及截止时间','upload/gonggaoxinxi_fengmian8.jpg,upload/gonggaoxinxi_fengmian1.jpg,upload/gonggaoxinxi_fengmian2.jpg','各院系、科研平台需围绕2024年科研项目立项/结题、成果产出、校企合作、科研经费使用、团队建设等内容撰写年度总结，需附相关数据统计表及成果清单；总结材料需按统一格式撰写，于2024年12月10日前提交电子版+纸质版至科研处；科研处将汇总全校科研工作情况，撰写学校年度科研工作总结并上报校领导','2026-03-06 23:33:21',8);
/*!40000 ALTER TABLE `gonggaoxinxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pingshenyijian`
--

DROP TABLE IF EXISTS `pingshenyijian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pingshenyijian` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `yanjiumubiao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '研究目标',
  `hexinyaosu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核心要素',
  `xiangmufengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目封面',
  `xiangmufujian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目附件',
  `pingshenyijian` longtext COLLATE utf8mb4_unicode_ci COMMENT '评审意见',
  `pingshenshijian` date DEFAULT NULL COMMENT '评审时间',
  `xuehao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='评审意见';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pingshenyijian`
--

LOCK TABLES `pingshenyijian` WRITE;
/*!40000 ALTER TABLE `pingshenyijian` DISABLE KEYS */;
INSERT INTO `pingshenyijian` VALUES (1,'2026-03-06 15:33:22','乡村直播','数字乡村','主播培训-供应链整合-直播运营','短视频算法','upload/pingshenyijian_乡村直播1.jpg,upload/pingshenyijian_乡村直播2.jpg,upload/pingshenyijian_乡村直播3.jpg','','评审意见1','2026-03-06','2023002','赵阳','文化传媒公司'),(2,'2026-03-06 15:33:22','数字文旅','旅游服务','AR内容制作-导览系统开发-景区合作','AR识别技术','upload/pingshenyijian_数字文旅1.jpg,upload/pingshenyijian_数字文旅2.jpg,upload/pingshenyijian_数字文旅3.jpg','','评审意见2','2026-03-06','2023011','林书豪','科技公司'),(3,'2026-03-06 15:33:22','合成生物','生物医药','基因编辑-蛋白表达-酶活测定','CRISPR技术','upload/pingshenyijian_合成生物1.jpg,upload/pingshenyijian_合成生物2.jpg,upload/pingshenyijian_合成生物3.jpg','','评审意见3','2026-03-06','2023006','李思远','运营管理公司'),(4,'2026-03-06 15:33:22','宠物智能','消费电子','产品设计-传感器集成-APP开发','低功耗蓝牙','upload/pingshenyijian_宠物智能1.jpg,upload/pingshenyijian_宠物智能2.jpg,upload/pingshenyijian_宠物智能3.jpg','','评审意见4','2026-03-06','2023008','周雪','互联网公司'),(5,'2026-03-06 15:33:22','教育VR','在线教育','课程开发-VR内容制作-平台上线','VR建模技术','upload/pingshenyijian_教育VR1.jpg,upload/pingshenyijian_教育VR2.jpg,upload/pingshenyijian_教育VR3.jpg','','评审意见5','2026-03-06','2023004','胡宇','销售公司'),(6,'2026-03-06 15:33:22','清洁技术','新能源','技术研发-设备制造-工程安装','催化分解技术','upload/pingshenyijian_清洁技术1.jpg,upload/pingshenyijian_清洁技术2.jpg,upload/pingshenyijian_清洁技术3.jpg','','评审意见6','2026-03-06','2023009','徐天宇','科技有限公司'),(7,'2026-03-06 15:33:22','健康餐配','餐饮服务','用户调研-菜单开发-冷链配送','营养数据库','upload/pingshenyijian_健康餐配1.jpg,upload/pingshenyijian_健康餐配2.jpg,upload/pingshenyijian_健康餐配3.jpg','','评审意见7','2026-03-06','2023012','王若曦','数据分析公司'),(8,'2026-03-06 15:33:22','智慧养老','养老服务','设备安装-数据监控-应急响应','多模态传感器','upload/pingshenyijian_智慧养老1.jpg,upload/pingshenyijian_智慧养老2.jpg,upload/pingshenyijian_智慧养老3.jpg','','评审意见8','2026-03-06','2023014','刘芳','物流公司');
/*!40000 ALTER TABLE `pingshenyijian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qiye`
--

DROP TABLE IF EXISTS `qiye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qiye` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyemingcheng` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业名称',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `fengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `fuzeren` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '负责人',
  `lianxidianhua` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `dizhi` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `qiyezizhi` longtext COLLATE utf8mb4_unicode_ci COMMENT '企业资质',
  `pquestion` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保问题',
  `panswer` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密保答案',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `qiyemingcheng` (`qiyemingcheng`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qiye`
--

LOCK TABLES `qiye` WRITE;
/*!40000 ALTER TABLE `qiye` DISABLE KEYS */;
INSERT INTO `qiye` VALUES (11,'2026-03-06 15:33:21','文化传媒公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_文案策划1.jpg,upload/qiye_文案策划2.jpg,upload/qiye_文案策划3.jpg','周宇恒','12200122000','福州市鼓楼区','','密保问题1','密保答案1',0),(12,'2026-03-06 15:33:21','科技公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_后端开发工程师1.jpg,upload/qiye_后端开发工程师2.jpg,upload/qiye_后端开发工程师3.jpg','赵思雨','13600136000','深圳市南山区','','密保问题2','密保答案2',0),(13,'2026-03-06 15:33:21','运营管理公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_运营专员1.jpg,upload/qiye_运营专员2.jpg,upload/qiye_运营专员3.jpg','林文','13100131000','西安市雁塔区','','密保问题3','密保答案3',0),(14,'2026-03-06 15:33:21','互联网公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_前端开发工程师1.jpg,upload/qiye_前端开发工程师2.jpg,upload/qiye_前端开发工程师3.jpg','梁行高','13700137000','广州市天河区','','密保问题4','密保答案4',0),(15,'2026-03-06 15:33:21','销售公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_销售代表1.jpg,upload/qiye_销售代表2.jpg,upload/qiye_销售代表3.jpg','高欣','13200132000','南京市玄武区','','密保问题5','密保答案5',0),(16,'2026-03-06 15:33:21','科技有限公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_产品经理1.jpg,upload/qiye_产品经理2.jpg,upload/qiye_产品经理3.jpg','徐行达','13800138000','北京市海淀区','','密保问题6','密保答案6',0),(17,'2026-03-06 15:33:21','数据分析公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_数据分析师1.jpg,upload/qiye_数据分析师2.jpg,upload/qiye_数据分析师3.jpg','陈然','12900129000','苏州市姑苏区','','密保问题7','密保答案7',0),(18,'2026-03-06 15:33:21','物流公司','e10adc3949ba59abbe56e057f20f883e','upload/qiye_物流专员1.jpg,upload/qiye_物流专员2.jpg,upload/qiye_物流专员3.jpg','马子轩','12100121000','宁波市鄞州区','','密保问题8','密保答案8',0);
/*!40000 ALTER TABLE `qiye` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shezhizhiwei`
--

DROP TABLE IF EXISTS `shezhizhiwei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shezhizhiwei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学号',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `xiangmubiaoti` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `zhiwei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `shenqingzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请账号',
  `shezhishijian` datetime DEFAULT NULL COMMENT '设置时间',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设置职位';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shezhizhiwei`
--

LOCK TABLES `shezhizhiwei` WRITE;
/*!40000 ALTER TABLE `shezhizhiwei` DISABLE KEYS */;
INSERT INTO `shezhizhiwei` VALUES (1,'2026-03-06 15:33:22','2023002','赵阳','项目标题1','职位1','申请账号1','2026-03-06 23:33:22',1,1),(2,'2026-03-06 15:33:22','2023011','林书豪','项目标题2','职位2','申请账号2','2026-03-06 23:33:22',2,2),(3,'2026-03-06 15:33:22','2023006','李思远','项目标题3','职位3','申请账号3','2026-03-06 23:33:22',3,3),(4,'2026-03-06 15:33:22','2023008','周雪','项目标题4','职位4','申请账号4','2026-03-06 23:33:22',4,4),(5,'2026-03-06 15:33:22','2023004','胡宇','项目标题5','职位5','申请账号5','2026-03-06 23:33:22',5,5),(6,'2026-03-06 15:33:22','2023009','徐天宇','项目标题6','职位6','申请账号6','2026-03-06 23:33:22',6,6),(7,'2026-03-06 15:33:22','2023012','王若曦','项目标题7','职位7','申请账号7','2026-03-06 23:33:22',7,7),(8,'2026-03-06 15:33:22','2023014','刘芳','项目标题8','职位8','申请账号8','2026-03-06 23:33:22',8,8);
/*!40000 ALTER TABLE `shezhizhiwei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeup`
--

DROP TABLE IF EXISTS `storeup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storeup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '表名',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `picture` longtext COLLATE utf8mb4_unicode_ci COMMENT '图片',
  `type` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '类型',
  `inteltype` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='收藏表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeup`
--

LOCK TABLES `storeup` WRITE;
/*!40000 ALTER TABLE `storeup` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(255) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  `image` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2026-03-06 15:33:22','admin','admin','管理员','upload/image1.jpg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiangmuchengguo`
--

DROP TABLE IF EXISTS `xiangmuchengguo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiangmuchengguo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shenqingbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请编号',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `chengguomingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成果名称',
  `chengguotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '成果图片',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `chengguoleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成果类型',
  `chengguoziliao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '成果资料',
  `suohuojiangxiang` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所获奖项',
  `chengguoneirong` longtext COLLATE utf8mb4_unicode_ci COMMENT '成果内容',
  `shenbaoshijian` date DEFAULT NULL COMMENT '申报时间',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目成果';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiangmuchengguo`
--

LOCK TABLES `xiangmuchengguo` WRITE;
/*!40000 ALTER TABLE `xiangmuchengguo` DISABLE KEYS */;
INSERT INTO `xiangmuchengguo` VALUES (1,'2026-03-06 15:33:22','申请编号1','乡村直播','新能源汽车充电桩智能管理系统','upload/xiangmuchengguo_chengguotupian1.jpg,upload/xiangmuchengguo_chengguotupian2.jpg,upload/xiangmuchengguo_chengguotupian3.jpg','数字乡村','成果转化','','实现充电桩高效调度与安全管理','实现充电桩高效调度与安全管理','2026-03-06','2023002','赵阳',1,1,'是',''),(2,'2026-03-06 15:33:22','申请编号2','数字文旅','工业废气净化处理技术','upload/xiangmuchengguo_chengguotupian2.jpg,upload/xiangmuchengguo_chengguotupian3.jpg,upload/xiangmuchengguo_chengguotupian4.jpg','旅游服务','成果转化','','将实验室技术转化为工业级净化设备','将实验室技术转化为工业级净化设备','2026-03-06','2023011','林书豪',2,2,'是',''),(3,'2026-03-06 15:33:22','申请编号3','合成生物','基于大数据的精准营销策略研究','upload/xiangmuchengguo_chengguotupian3.jpg,upload/xiangmuchengguo_chengguotupian4.jpg,upload/xiangmuchengguo_chengguotupian5.jpg','生物医药','学术论文','','分析用户行为数据制定精准营销方案','分析用户行为数据制定精准营销方案','2026-03-06','2023006','李思远',3,3,'是',''),(4,'2026-03-06 15:33:22','申请编号4','宠物智能','《人工智能导论实践教程》','upload/xiangmuchengguo_chengguotupian4.jpg,upload/xiangmuchengguo_chengguotupian5.jpg,upload/xiangmuchengguo_chengguotupian6.jpg','消费电子','专著/教材','','配套高校课程提供实操教学指导','配套高校课程提供实操教学指导','2026-03-06','2023008','周雪',4,4,'是',''),(5,'2026-03-06 15:33:22','申请编号5','教育VR','一种可降解塑料薄膜制备工艺','upload/xiangmuchengguo_chengguotupian5.jpg,upload/xiangmuchengguo_chengguotupian6.jpg,upload/xiangmuchengguo_chengguotupian7.jpg','在线教育','专利','','实现塑料薄膜自然降解周期缩短50%','实现塑料薄膜自然降解周期缩短50%','2026-03-06','2023004','胡宇',5,5,'是',''),(6,'2026-03-06 15:33:22','申请编号6','清洁技术','一种智能穿戴健康监测设备','upload/xiangmuchengguo_chengguotupian6.jpg,upload/xiangmuchengguo_chengguotupian7.jpg,upload/xiangmuchengguo_chengguotupian8.jpg','新能源','专利','','设计可监测心率血压的穿戴设备','设计可监测心率血压的穿戴设备','2026-03-06','2023009','徐天宇',6,6,'是',''),(7,'2026-03-06 15:33:22','申请编号7','健康餐配','老年人居家养老服务体系建设','upload/xiangmuchengguo_chengguotupian7.jpg,upload/xiangmuchengguo_chengguotupian8.jpg,upload/xiangmuchengguo_chengguotupian1.jpg','餐饮服务','科研项目','','建立多元化居家养老服务模式','建立多元化居家养老服务模式','2026-03-06','2023012','王若曦',7,7,'是',''),(8,'2026-03-06 15:33:22','申请编号8','智慧养老','儿童自闭症早期干预模式构建','upload/xiangmuchengguo_chengguotupian8.jpg,upload/xiangmuchengguo_chengguotupian1.jpg,upload/xiangmuchengguo_chengguotupian2.jpg','养老服务','科研项目','','建立多维度干预模式提高康复效果','建立多维度干预模式提高康复效果','2026-03-06','2023014','刘芳',8,8,'是','');
/*!40000 ALTER TABLE `xiangmuchengguo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiangmufenlei`
--

DROP TABLE IF EXISTS `xiangmufenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiangmufenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiangmufenlei`
--

LOCK TABLES `xiangmufenlei` WRITE;
/*!40000 ALTER TABLE `xiangmufenlei` DISABLE KEYS */;
INSERT INTO `xiangmufenlei` VALUES (1,'2026-03-06 15:33:22','数字乡村'),(2,'2026-03-06 15:33:22','旅游服务'),(3,'2026-03-06 15:33:22','生物医药'),(4,'2026-03-06 15:33:22','消费电子'),(5,'2026-03-06 15:33:22','在线教育'),(6,'2026-03-06 15:33:22','新能源'),(7,'2026-03-06 15:33:22','餐饮服务'),(8,'2026-03-06 15:33:22','养老服务');
/*!40000 ALTER TABLE `xiangmufenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiangmujianyi`
--

DROP TABLE IF EXISTS `xiangmujianyi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiangmujianyi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shenqingbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请编号',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `jianyifangan` longtext COLLATE utf8mb4_unicode_ci COMMENT '建议方案',
  `jindutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '进度图片',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `jianyixiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '建议详情',
  `jianyiriqi` date DEFAULT NULL COMMENT '建议日期',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `jiaoshigonghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教师工号',
  `jiaoshixingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教师姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目建议';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiangmujianyi`
--

LOCK TABLES `xiangmujianyi` WRITE;
/*!40000 ALTER TABLE `xiangmujianyi` DISABLE KEYS */;
INSERT INTO `xiangmujianyi` VALUES (1,'2026-03-06 15:33:22','申请编号1','乡村直播','','upload/xiangmujianyi_jindutupian1.jpg,upload/xiangmujianyi_jindutupian2.jpg,upload/xiangmujianyi_jindutupian3.jpg','数字乡村','建议详情1','2026-03-06','2023002','赵阳','005','赵阳'),(2,'2026-03-06 15:33:22','申请编号2','数字文旅','','upload/xiangmujianyi_jindutupian2.jpg,upload/xiangmujianyi_jindutupian3.jpg,upload/xiangmujianyi_jindutupian4.jpg','旅游服务','建议详情2','2026-03-06','2023011','林书豪','004','林书豪'),(3,'2026-03-06 15:33:22','申请编号3','合成生物','','upload/xiangmujianyi_jindutupian3.jpg,upload/xiangmujianyi_jindutupian4.jpg,upload/xiangmujianyi_jindutupian5.jpg','生物医药','建议详情3','2026-03-06','2023006','李思远','001','李思远'),(4,'2026-03-06 15:33:22','申请编号4','宠物智能','','upload/xiangmujianyi_jindutupian4.jpg,upload/xiangmujianyi_jindutupian5.jpg,upload/xiangmujianyi_jindutupian6.jpg','消费电子','建议详情4','2026-03-06','2023008','周雪','007','周雪'),(5,'2026-03-06 15:33:22','申请编号5','教育VR','','upload/xiangmujianyi_jindutupian5.jpg,upload/xiangmujianyi_jindutupian6.jpg,upload/xiangmujianyi_jindutupian7.jpg','在线教育','建议详情5','2026-03-06','2023004','胡宇','002','胡宇'),(6,'2026-03-06 15:33:22','申请编号6','清洁技术','','upload/xiangmujianyi_jindutupian6.jpg,upload/xiangmujianyi_jindutupian7.jpg,upload/xiangmujianyi_jindutupian8.jpg','新能源','建议详情6','2026-03-06','2023009','徐天宇','003','徐天宇'),(7,'2026-03-06 15:33:22','申请编号7','健康餐配','','upload/xiangmujianyi_jindutupian7.jpg,upload/xiangmujianyi_jindutupian8.jpg,upload/xiangmujianyi_jindutupian1.jpg','餐饮服务','建议详情7','2026-03-06','2023012','王若曦','008','王若曦'),(8,'2026-03-06 15:33:22','申请编号8','智慧养老','','upload/xiangmujianyi_jindutupian8.jpg,upload/xiangmujianyi_jindutupian1.jpg,upload/xiangmujianyi_jindutupian2.jpg','养老服务','建议详情8','2026-03-06','2023014','刘芳','006','刘芳');
/*!40000 ALTER TABLE `xiangmujianyi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiangmujindu`
--

DROP TABLE IF EXISTS `xiangmujindu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiangmujindu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shenqingbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请编号',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `yanjiufangan` longtext COLLATE utf8mb4_unicode_ci COMMENT '研究方案',
  `jindutupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '进度图片',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `jinduxiangqing` longtext COLLATE utf8mb4_unicode_ci COMMENT '进度详情',
  `shipin` longtext COLLATE utf8mb4_unicode_ci COMMENT '视频',
  `dengjiriqi` date DEFAULT NULL COMMENT '登记日期',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `jieduanjihua` longtext COLLATE utf8mb4_unicode_ci COMMENT '阶段计划',
  `jieduanmubiao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '阶段目标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目进度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiangmujindu`
--

LOCK TABLES `xiangmujindu` WRITE;
/*!40000 ALTER TABLE `xiangmujindu` DISABLE KEYS */;
INSERT INTO `xiangmujindu` VALUES (1,'2026-03-06 15:33:22','申请编号1','乡村直播','','upload/xiangmujindu_jindutupian1.jpg,upload/xiangmujindu_jindutupian2.jpg,upload/xiangmujindu_jindutupian3.jpg','数字乡村','进度详情1','','2026-03-06','2023002','赵阳','','阶段目标1'),(2,'2026-03-06 15:33:22','申请编号2','数字文旅','','upload/xiangmujindu_jindutupian2.jpg,upload/xiangmujindu_jindutupian3.jpg,upload/xiangmujindu_jindutupian4.jpg','旅游服务','进度详情2','','2026-03-06','2023011','林书豪','','阶段目标2'),(3,'2026-03-06 15:33:22','申请编号3','合成生物','','upload/xiangmujindu_jindutupian3.jpg,upload/xiangmujindu_jindutupian4.jpg,upload/xiangmujindu_jindutupian5.jpg','生物医药','进度详情3','','2026-03-06','2023006','李思远','','阶段目标3'),(4,'2026-03-06 15:33:22','申请编号4','宠物智能','','upload/xiangmujindu_jindutupian4.jpg,upload/xiangmujindu_jindutupian5.jpg,upload/xiangmujindu_jindutupian6.jpg','消费电子','进度详情4','','2026-03-06','2023008','周雪','','阶段目标4'),(5,'2026-03-06 15:33:22','申请编号5','教育VR','','upload/xiangmujindu_jindutupian5.jpg,upload/xiangmujindu_jindutupian6.jpg,upload/xiangmujindu_jindutupian7.jpg','在线教育','进度详情5','','2026-03-06','2023004','胡宇','','阶段目标5'),(6,'2026-03-06 15:33:22','申请编号6','清洁技术','','upload/xiangmujindu_jindutupian6.jpg,upload/xiangmujindu_jindutupian7.jpg,upload/xiangmujindu_jindutupian8.jpg','新能源','进度详情6','','2026-03-06','2023009','徐天宇','','阶段目标6'),(7,'2026-03-06 15:33:22','申请编号7','健康餐配','','upload/xiangmujindu_jindutupian7.jpg,upload/xiangmujindu_jindutupian8.jpg,upload/xiangmujindu_jindutupian1.jpg','餐饮服务','进度详情7','','2026-03-06','2023012','王若曦','','阶段目标7'),(8,'2026-03-06 15:33:22','申请编号8','智慧养老','','upload/xiangmujindu_jindutupian8.jpg,upload/xiangmujindu_jindutupian1.jpg,upload/xiangmujindu_jindutupian2.jpg','养老服务','进度详情8','','2026-03-06','2023014','刘芳','','阶段目标8');
/*!40000 ALTER TABLE `xiangmujindu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xiangmushenqing`
--

DROP TABLE IF EXISTS `xiangmushenqing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xiangmushenqing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shenqingbianhao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请编号',
  `xiangmubiaoti` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `xiangmufenlei` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `xiangmufengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目封面',
  `shenqingfujian` longtext COLLATE utf8mb4_unicode_ci COMMENT '申请附件',
  `shenqingyuanyin` longtext COLLATE utf8mb4_unicode_ci COMMENT '申请原因',
  `shenqingshijian` datetime DEFAULT NULL COMMENT '申请时间',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `shenqingzhanghao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请账号',
  `shenqingxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申请姓名',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shenqingbianhao` (`shenqingbianhao`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='项目申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xiangmushenqing`
--

LOCK TABLES `xiangmushenqing` WRITE;
/*!40000 ALTER TABLE `xiangmushenqing` DISABLE KEYS */;
INSERT INTO `xiangmushenqing` VALUES (1,'2026-03-06 15:33:22','1111111111','自制简易显微镜观察效果实验','物理光学类','upload/xiangmushenqing_自制简易显微镜观察效果实验1.jpg,upload/xiangmushenqing_自制简易显微镜观察效果实验2.jpg,upload/xiangmushenqing_自制简易显微镜观察效果实验3.jpg','','能清晰观察到洋葱表皮细胞，制作显微镜1台','2026-03-06 23:33:22','2023002','赵阳','2023002','赵阳',1,1,'是',''),(2,'2026-03-06 15:33:22','2222222222','导体电阻与长度、横截面积关系实验','物理电学类','upload/xiangmushenqing_导体电阻与长度、横截面积关系实验1.jpg,upload/xiangmushenqing_导体电阻与长度、横截面积关系实验2.jpg,upload/xiangmushenqing_导体电阻与长度、横截面积关系实验3.jpg','','得出电阻定律实验数据，制作实验演示课件1套','2026-03-06 23:33:22','2023011','林书豪','2023011','林书豪',2,2,'是',''),(3,'2026-03-06 15:33:22','3333333333','不同洗涤剂去污效果比较','化学应用类','upload/xiangmushenqing_不同洗涤剂去污效果比较1.jpg,upload/xiangmushenqing_不同洗涤剂去污效果比较2.jpg,upload/xiangmushenqing_不同洗涤剂去污效果比较3.jpg','','确定最佳去污洗涤剂，完成实验报告1份','2026-03-06 23:33:22','2023006','李思远','2023006','李思远',3,3,'是',''),(4,'2026-03-06 15:33:22','4444444444','不同光照时间对植物开花影响实验','生物生理类','upload/xiangmushenqing_不同光照时间对植物开花影响实验1.jpg,upload/xiangmushenqing_不同光照时间对植物开花影响实验2.jpg,upload/xiangmushenqing_不同光照时间对植物开花影响实验3.jpg','','确定菊花开花最佳光照时长，发表校园科研论文1篇','2026-03-06 23:33:22','2023008','周雪','2023008','周雪',4,4,'是',''),(5,'2026-03-06 15:33:22','5555555555','不同浓度盐水沸点变化实验','物理热学类','upload/xiangmushenqing_不同浓度盐水沸点变化实验1.jpg,upload/xiangmushenqing_不同浓度盐水沸点变化实验2.jpg,upload/xiangmushenqing_不同浓度盐水沸点变化实验3.jpg','','得出盐水浓度越高沸点越高结论，制作实验报告1份','2026-03-06 23:33:22','2023004','胡宇','2023004','胡宇',5,5,'是',''),(6,'2026-03-06 15:33:22','6666666666','藻类植物对水体富营养化净化实验','环境生物类','upload/xiangmushenqing_藻类植物对水体富营养化净化实验1.jpg,upload/xiangmushenqing_藻类植物对水体富营养化净化实验2.jpg,upload/xiangmushenqing_藻类植物对水体富营养化净化实验3.jpg','','水体氮磷去除率≥30%，形成实验报告1份','2026-03-06 23:33:22','2023009','徐天宇','2023009','徐天宇',6,6,'是',''),(7,'2026-03-06 15:33:22','7777777777','不同材质保温杯保温效果比较','物理热学类','upload/xiangmushenqing_不同材质保温杯保温效果比较1.jpg,upload/xiangmushenqing_不同材质保温杯保温效果比较2.jpg,upload/xiangmushenqing_不同材质保温杯保温效果比较3.jpg','','确定最佳保温材质，发表校园科研论文1篇','2026-03-06 23:33:22','2023012','王若曦','2023012','王若曦',7,7,'是',''),(8,'2026-03-06 15:33:22','8888888888','电磁铁磁性强弱与电流关系实验','物理电磁类','upload/xiangmushenqing_电磁铁磁性强弱与电流关系实验1.jpg,upload/xiangmushenqing_电磁铁磁性强弱与电流关系实验2.jpg,upload/xiangmushenqing_电磁铁磁性强弱与电流关系实验3.jpg','','得出电流越大磁性越强结论，制作实验模型1个','2026-03-06 23:33:22','2023014','刘芳','2023014','刘芳',8,8,'是','');
/*!40000 ALTER TABLE `xiangmushenqing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xuesheng`
--

DROP TABLE IF EXISTS `xuesheng`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xuesheng` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xuehao` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xueshengxingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `xingbie` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `shouji` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机',
  `xiangmubiaoti` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `zhiwei` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `xuehao` (`xuehao`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='学生';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xuesheng`
--

LOCK TABLES `xuesheng` WRITE;
/*!40000 ALTER TABLE `xuesheng` DISABLE KEYS */;
INSERT INTO `xuesheng` VALUES (31,'2026-03-06 15:33:21','2023002','e10adc3949ba59abbe56e057f20f883e','赵阳','女','upload/xuesheng_touxiang1.jpg','15267890123','未创建项目','未有职位','是','',0),(32,'2026-03-06 15:33:21','2023011','e10adc3949ba59abbe56e057f20f883e','林书豪','女','upload/xuesheng_touxiang2.jpg','15187654321','未创建项目','未有职位','是','',0),(33,'2026-03-06 15:33:21','2023006','e10adc3949ba59abbe56e057f20f883e','李思远','男','upload/xuesheng_touxiang3.jpg','13654321098','未创建项目','未有职位','是','',0),(34,'2026-03-06 15:33:21','2023008','e10adc3949ba59abbe56e057f20f883e','周雪','男','upload/xuesheng_touxiang4.jpg','15012345678','未创建项目','未有职位','是','',0),(35,'2026-03-06 15:33:21','2023004','e10adc3949ba59abbe56e057f20f883e','胡宇','男','upload/xuesheng_touxiang5.jpg','13765432109','未创建项目','未有职位','是','',0),(36,'2026-03-06 15:33:21','2023009','e10adc3949ba59abbe56e057f20f883e','徐天宇','女','upload/xuesheng_touxiang6.jpg','13790123456','未创建项目','未有职位','是','',0),(37,'2026-03-06 15:33:21','2023012','e10adc3949ba59abbe56e057f20f883e','王若曦','女','upload/xuesheng_touxiang7.jpg','15065432109','未创建项目','未有职位','是','',0),(38,'2026-03-06 15:33:21','2023014','e10adc3949ba59abbe56e057f20f883e','刘芳','女','upload/xuesheng_touxiang8.jpg','13987654321','未创建项目','未有职位','是','',0);
/*!40000 ALTER TABLE `xuesheng` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yaoqingpingshen`
--

DROP TABLE IF EXISTS `yaoqingpingshen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yaoqingpingshen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xiangmubiaoti` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目标题',
  `xiangmufenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '项目分类',
  `yanjiumubiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '研究目标',
  `hexinyaosu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核心要素',
  `xiangmufengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目封面',
  `xiangmufujian` longtext COLLATE utf8mb4_unicode_ci COMMENT '项目附件',
  `yaoqingneirong` longtext COLLATE utf8mb4_unicode_ci COMMENT '邀请内容',
  `yaoqingshijian` date DEFAULT NULL COMMENT '邀请时间',
  `xuehao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='邀请评审';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yaoqingpingshen`
--

LOCK TABLES `yaoqingpingshen` WRITE;
/*!40000 ALTER TABLE `yaoqingpingshen` DISABLE KEYS */;
INSERT INTO `yaoqingpingshen` VALUES (1,'2026-03-06 15:33:22','乡村直播','数字乡村','主播培训-供应链整合-直播运营','短视频算法','upload/yaoqingpingshen_乡村直播1.jpg,upload/yaoqingpingshen_乡村直播2.jpg,upload/yaoqingpingshen_乡村直播3.jpg','','邀请内容1','2026-03-06','2023002','赵阳','文化传媒公司'),(2,'2026-03-06 15:33:22','数字文旅','旅游服务','AR内容制作-导览系统开发-景区合作','AR识别技术','upload/yaoqingpingshen_数字文旅1.jpg,upload/yaoqingpingshen_数字文旅2.jpg,upload/yaoqingpingshen_数字文旅3.jpg','','邀请内容2','2026-03-06','2023011','林书豪','科技公司'),(3,'2026-03-06 15:33:22','合成生物','生物医药','基因编辑-蛋白表达-酶活测定','CRISPR技术','upload/yaoqingpingshen_合成生物1.jpg,upload/yaoqingpingshen_合成生物2.jpg,upload/yaoqingpingshen_合成生物3.jpg','','邀请内容3','2026-03-06','2023006','李思远','运营管理公司'),(4,'2026-03-06 15:33:22','宠物智能','消费电子','产品设计-传感器集成-APP开发','低功耗蓝牙','upload/yaoqingpingshen_宠物智能1.jpg,upload/yaoqingpingshen_宠物智能2.jpg,upload/yaoqingpingshen_宠物智能3.jpg','','邀请内容4','2026-03-06','2023008','周雪','互联网公司'),(5,'2026-03-06 15:33:22','教育VR','在线教育','课程开发-VR内容制作-平台上线','VR建模技术','upload/yaoqingpingshen_教育VR1.jpg,upload/yaoqingpingshen_教育VR2.jpg,upload/yaoqingpingshen_教育VR3.jpg','','邀请内容5','2026-03-06','2023004','胡宇','销售公司'),(6,'2026-03-06 15:33:22','清洁技术','新能源','技术研发-设备制造-工程安装','催化分解技术','upload/yaoqingpingshen_清洁技术1.jpg,upload/yaoqingpingshen_清洁技术2.jpg,upload/yaoqingpingshen_清洁技术3.jpg','','邀请内容6','2026-03-06','2023009','徐天宇','科技有限公司'),(7,'2026-03-06 15:33:22','健康餐配','餐饮服务','用户调研-菜单开发-冷链配送','营养数据库','upload/yaoqingpingshen_健康餐配1.jpg,upload/yaoqingpingshen_健康餐配2.jpg,upload/yaoqingpingshen_健康餐配3.jpg','','邀请内容7','2026-03-06','2023012','王若曦','数据分析公司'),(8,'2026-03-06 15:33:22','智慧养老','养老服务','设备安装-数据监控-应急响应','多模态传感器','upload/yaoqingpingshen_智慧养老1.jpg,upload/yaoqingpingshen_智慧养老2.jpg,upload/yaoqingpingshen_智慧养老3.jpg','','邀请内容8','2026-03-06','2023014','刘芳','物流公司');
/*!40000 ALTER TABLE `yaoqingpingshen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhidaojiaoshi`
--

DROP TABLE IF EXISTS `zhidaojiaoshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhidaojiaoshi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `jiaoshigonghao` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '教师工号',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `jiaoshixingming` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教师姓名',
  `xingbie` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `jiaoshidianhua` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '教师电话',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  `status` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `jiaoshigonghao` (`jiaoshigonghao`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='指导教师';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhidaojiaoshi`
--

LOCK TABLES `zhidaojiaoshi` WRITE;
/*!40000 ALTER TABLE `zhidaojiaoshi` DISABLE KEYS */;
INSERT INTO `zhidaojiaoshi` VALUES (21,'2026-03-06 15:33:21','005','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang1.jpg','赵阳','女','15267890123','是','',0),(22,'2026-03-06 15:33:21','004','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang2.jpg','林书豪','女','15187654321','是','',0),(23,'2026-03-06 15:33:21','001','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang3.jpg','李思远','男','13654321098','是','',0),(24,'2026-03-06 15:33:21','007','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang4.jpg','周雪','男','15012345678','是','',0),(25,'2026-03-06 15:33:21','002','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang5.jpg','胡宇','男','13765432109','是','',0),(26,'2026-03-06 15:33:21','003','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang6.jpg','徐天宇','女','13790123456','是','',0),(27,'2026-03-06 15:33:21','008','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang7.jpg','王若曦','女','15065432109','是','',0),(28,'2026-03-06 15:33:21','006','e10adc3949ba59abbe56e057f20f883e','upload/zhidaojiaoshi_touxiang8.jpg','刘芳','女','13987654321','是','',0);
/*!40000 ALTER TABLE `zhidaojiaoshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhishifenlei`
--

DROP TABLE IF EXISTS `zhishifenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhishifenlei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhishifenlei` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '知识分类',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhishifenlei` (`zhishifenlei`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='知识分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhishifenlei`
--

LOCK TABLES `zhishifenlei` WRITE;
/*!40000 ALTER TABLE `zhishifenlei` DISABLE KEYS */;
INSERT INTO `zhishifenlei` VALUES (1,'2026-03-06 15:33:22','技术资源'),(2,'2026-03-06 15:33:22','政策资源'),(3,'2026-03-06 15:33:22','服务资源'),(4,'2026-03-06 15:33:22','投资资源'),(5,'2026-03-06 15:33:22','知识分类5'),(6,'2026-03-06 15:33:22','知识分类6'),(7,'2026-03-06 15:33:22','知识分类7'),(8,'2026-03-06 15:33:22','知识分类8');
/*!40000 ALTER TABLE `zhishifenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zhishiku`
--

DROP TABLE IF EXISTS `zhishiku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zhishiku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `biaoti` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `zhishifenlei` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '知识分类',
  `fengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '封面',
  `zhishijianjie` longtext COLLATE utf8mb4_unicode_ci COMMENT '知识简介',
  `zhishiwenjian` longtext COLLATE utf8mb4_unicode_ci COMMENT '知识文件',
  `zhishineirong` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '知识内容',
  `fabushijian` date DEFAULT NULL COMMENT '发布时间',
  `zhuyishixiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '注意事项',
  `storeupnum` int(11) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='知识库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zhishiku`
--

LOCK TABLES `zhishiku` WRITE;
/*!40000 ALTER TABLE `zhishiku` DISABLE KEYS */;
INSERT INTO `zhishiku` VALUES (1,'2026-03-06 15:33:22','工业设计共享平台','技术资源','upload/zhishiku_fengmian1.jpg,upload/zhishiku_fengmian2.jpg,upload/zhishiku_fengmian3.jpg','明确产品定位及设计需求','','明确产品定位及设计需求','2026-03-06','明确产品定位及设计需求',1),(2,'2026-03-06 15:33:22','新能源汽车充电桩创业扶持','政策资源','upload/zhishiku_fengmian2.jpg,upload/zhishiku_fengmian3.jpg,upload/zhishiku_fengmian4.jpg','具备场地资源及运营资质','','具备场地资源及运营资质','2026-03-06','具备场地资源及运营资质',2),(3,'2026-03-06 15:33:22','数字文创版权服务平台','服务资源','upload/zhishiku_fengmian3.jpg,upload/zhishiku_fengmian4.jpg,upload/zhishiku_fengmian5.jpg','拥有原创文创作品或IP','','拥有原创文创作品或IP','2026-03-06','拥有原创文创作品或IP',3),(4,'2026-03-06 15:33:22','AI算法开源社区','技术资源','upload/zhishiku_fengmian4.jpg,upload/zhishiku_fengmian5.jpg,upload/zhishiku_fengmian6.jpg','具备基础算法研发能力','','具备基础算法研发能力','2026-03-06','具备基础算法研发能力',4),(5,'2026-03-06 15:33:22','绿色能源创业基金','投资资源','upload/zhishiku_fengmian5.jpg,upload/zhishiku_fengmian6.jpg,upload/zhishiku_fengmian7.jpg','拥有成熟技术方案及商业模式','','拥有成熟技术方案及商业模式','2026-03-06','拥有成熟技术方案及商业模式',5),(6,'2026-03-06 15:33:22','乡村振兴创业扶持计划','政策资源','upload/zhishiku_fengmian6.jpg,upload/zhishiku_fengmian7.jpg,upload/zhishiku_fengmian8.jpg','聚焦农产品种植加工或乡村旅游','','聚焦农产品种植加工或乡村旅游','2026-03-06','聚焦农产品种植加工或乡村旅游',6),(7,'2026-03-06 15:33:22','区块链技术应用平台','技术资源','upload/zhishiku_fengmian7.jpg,upload/zhishiku_fengmian8.jpg,upload/zhishiku_fengmian1.jpg','具备明确应用场景及业务需求','','具备明确应用场景及业务需求','2026-03-06','具备明确应用场景及业务需求',7),(8,'2026-03-06 15:33:22','中小企业数字化转型补贴','政策资源','upload/zhishiku_fengmian8.jpg,upload/zhishiku_fengmian1.jpg,upload/zhishiku_fengmian2.jpg','具备数字化转型需求及基础运营条件','','具备数字化转型需求及基础运营条件','2026-03-06','具备数字化转型需求及基础运营条件',8);
/*!40000 ALTER TABLE `zhishiku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziyuanleixing`
--

DROP TABLE IF EXISTS `ziyuanleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ziyuanleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ziyuanleixing` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资源类型',
  PRIMARY KEY (`id`),
  UNIQUE KEY `ziyuanleixing` (`ziyuanleixing`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资源类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziyuanleixing`
--

LOCK TABLES `ziyuanleixing` WRITE;
/*!40000 ALTER TABLE `ziyuanleixing` DISABLE KEYS */;
INSERT INTO `ziyuanleixing` VALUES (1,'2026-03-06 15:33:22','技术资源'),(2,'2026-03-06 15:33:22','政策资源'),(3,'2026-03-06 15:33:22','服务资源'),(4,'2026-03-06 15:33:22','投资资源'),(5,'2026-03-06 15:33:22','资源类型5'),(6,'2026-03-06 15:33:22','资源类型6'),(7,'2026-03-06 15:33:22','资源类型7'),(8,'2026-03-06 15:33:22','资源类型8');
/*!40000 ALTER TABLE `ziyuanleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziyuanshenqing`
--

DROP TABLE IF EXISTS `ziyuanshenqing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ziyuanshenqing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ziyuanmingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源名称',
  `ziyuanleixing` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类型',
  `ziyuanfengmian` longtext COLLATE utf8mb4_unicode_ci COMMENT '资源封面',
  `suoshuxingye` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业',
  `shenqingziliao` longtext COLLATE utf8mb4_unicode_ci COMMENT '申请资料',
  `shenqingshijian` date DEFAULT NULL COMMENT '申请时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `xuehao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `xueshengxingming` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学生姓名',
  `xiangmubiaoti` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '项目标题',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '审核回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资源申请';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziyuanshenqing`
--

LOCK TABLES `ziyuanshenqing` WRITE;
/*!40000 ALTER TABLE `ziyuanshenqing` DISABLE KEYS */;
INSERT INTO `ziyuanshenqing` VALUES (1,'2026-03-06 15:33:22','工业设计共享平台','技术资源','upload/ziyuanshenqing_工业设计共享平台1.jpg,upload/ziyuanshenqing_工业设计共享平台2.jpg,upload/ziyuanshenqing_工业设计共享平台3.jpg','工业设计','明确产品定位及设计需求','2026-03-06','文化传媒公司','2023002','赵阳','乡村直播','是',''),(2,'2026-03-06 15:33:22','新能源汽车充电桩创业扶持','政策资源','upload/ziyuanshenqing_新能源汽车充电桩创业扶持1.jpg,upload/ziyuanshenqing_新能源汽车充电桩创业扶持2.jpg,upload/ziyuanshenqing_新能源汽车充电桩创业扶持3.jpg','新能源汽车','具备场地资源及运营资质','2026-03-06','科技公司','2023011','林书豪','数字文旅','是',''),(3,'2026-03-06 15:33:22','数字文创版权服务平台','服务资源','upload/ziyuanshenqing_数字文创版权服务平台1.jpg,upload/ziyuanshenqing_数字文创版权服务平台2.jpg,upload/ziyuanshenqing_数字文创版权服务平台3.jpg','文化创意','拥有原创文创作品或IP','2026-03-06','运营管理公司','2023006','李思远','合成生物','是',''),(4,'2026-03-06 15:33:22','AI算法开源社区','技术资源','upload/ziyuanshenqing_AI算法开源社区1.jpg,upload/ziyuanshenqing_AI算法开源社区2.jpg,upload/ziyuanshenqing_AI算法开源社区3.jpg','人工智能','具备基础算法研发能力','2026-03-06','互联网公司','2023008','周雪','宠物智能','是',''),(5,'2026-03-06 15:33:22','绿色能源创业基金','投资资源','upload/ziyuanshenqing_绿色能源创业基金1.jpg,upload/ziyuanshenqing_绿色能源创业基金2.jpg,upload/ziyuanshenqing_绿色能源创业基金3.jpg','新能源','拥有成熟技术方案及商业模式','2026-03-06','销售公司','2023004','胡宇','教育VR','是',''),(6,'2026-03-06 15:33:22','乡村振兴创业扶持计划','政策资源','upload/ziyuanshenqing_乡村振兴创业扶持计划1.jpg,upload/ziyuanshenqing_乡村振兴创业扶持计划2.jpg,upload/ziyuanshenqing_乡村振兴创业扶持计划3.jpg','现代农业','聚焦农产品种植加工或乡村旅游','2026-03-06','科技有限公司','2023009','徐天宇','清洁技术','是',''),(7,'2026-03-06 15:33:22','区块链技术应用平台','技术资源','upload/ziyuanshenqing_区块链技术应用平台1.jpg,upload/ziyuanshenqing_区块链技术应用平台2.jpg,upload/ziyuanshenqing_区块链技术应用平台3.jpg','区块链','具备明确应用场景及业务需求','2026-03-06','数据分析公司','2023012','王若曦','健康餐配','是',''),(8,'2026-03-06 15:33:22','中小企业数字化转型补贴','政策资源','upload/ziyuanshenqing_中小企业数字化转型补贴1.jpg,upload/ziyuanshenqing_中小企业数字化转型补贴2.jpg,upload/ziyuanshenqing_中小企业数字化转型补贴3.jpg','全行业','具备数字化转型需求及基础运营条件','2026-03-06','物流公司','2023014','刘芳','智慧养老','是','');
/*!40000 ALTER TABLE `ziyuanshenqing` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-12 23:08:03
