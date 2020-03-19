/**
 * 文件名：OrgInfoService.java
 * 创建日期： 2012-5-9
 * Copyright (c) 2011-2011 广电运通
 * All rights reserved.
 
 * 修改记录：
 * 1.修改时间, 修改
 *   修改内容：
 */
package com.grgbanking.platform.module.org.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.grgbanking.platform.common.Constants.AppConstants;
import com.grgbanking.platform.core.dao.Page;
import com.grgbanking.platform.core.dao.PropertyFilter;
import com.grgbanking.platform.core.exception.AppException;
import com.grgbanking.platform.core.exception.SysException;
import com.grgbanking.platform.core.service.BaseService;
import com.grgbanking.platform.core.utils.ImportExcelUtil;
import com.grgbanking.platform.core.utils.XmlUtil;
import com.grgbanking.platform.module.common.MessageKeyConstants;
import com.grgbanking.platform.module.datadir.entity.SysDatadir;
import com.grgbanking.platform.module.datadir.service.SysDatadirService;
import com.grgbanking.platform.module.exproperty.dao.ExtendPropertyDao;
import com.grgbanking.platform.module.exproperty.entity.ExtendProperty;
import com.grgbanking.platform.module.exproperty.service.ExPropertyService;
import com.grgbanking.platform.module.org.dao.OrgInfoDao;
import com.grgbanking.platform.module.org.entity.OrgInfo;
import com.grgbanking.platform.module.org.entity.OrgInfoVO;
import com.grgbanking.platform.module.org.util.OrgInitUtil;
import com.grgbanking.platform.module.param.dao.ParamDao;
import com.grgbanking.sent.utils.S2005Msg;
import com.grgbanking.sent.utils.Transfer;

import flex.messaging.FlexContext;

/**
 * sys_org management<br>
 * 机构管理服务类
 * 
 * @author lzyang
 * 
 */
@Service
@Transactional
public class OrgInfoService extends BaseService {

	/** 扩展属性 */
	public static Map<String, String> exPropertyMap = new HashMap<String, String>();

	@Autowired
	OrgInfoDao orgInfoDao;

	@Autowired
	private ParamDao paramDao;

	@Autowired
	private SysDatadirService sysDatadirService;

	// 导出机构信息
	public String exportOrgInfo(String orgid) {

		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		HttpServletRequest request = FlexContext.getHttpRequest();

		String fileName = UUID.randomUUID() + "Org.xls";
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ File.separator + "exportFile" + File.separator + fileName;// 导出文件路径
		String modelName = request.getSession().getServletContext()
				.getRealPath("")
				+ File.separator + "exportFile" + File.separator + "org1.xls";// 文件模板路径

		ArrayList<Object[]> orglist = new ArrayList<Object[]>();
		orglist = (ArrayList<Object[]>) orgInfoDao
				.getFatherIdAndChildrenIdByParentId(orgid);
		Object[] row;
		int no = 0;
		for (int i = 0; i < orglist.size(); i++) {
			row = new Object[10];
			OrgInfo orgInfo = new OrgInfo();
			// orgInfo = orglist.get(i);
			Object[] org = orglist.get(i);
			row[0] = org[9];
			row[1] = org[0];
			row[2] = org[1];
			row[3] = org[2] == null ? "" : org[2];
			row[4] = org[3] == null ? "" : org[3];
			row[5] = org[4] == null ? "" : org[4];
			row[6] = org[5] == null ? "" : org[5];
			row[7] = org[6] == null ? "" : org[6];
			String orgStatu = org[7] != null ? org[7].toString() : null;
			if (orgStatu != null && orgStatu.equals("Y")) {
				row[8] = "启用";

			} else {
				row[8] = "禁用";

			}

			row[9] = org[8] == null ? "" : org[8];
			dataList.add(row);
		}
		String fileUrl = makeExcelFile(dataList, modelName, filePath);
		return fileName;
	}

	public String makeExcelFile(ArrayList dataList, String modelName,
			String filePath) {
		HSSFWorkbook templatewb = null;
		int perSize = 7000;
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					modelName));
			templatewb = new HSSFWorkbook(fs);
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		try {
			int sheetNo = dataList.size() % perSize > 0 ? dataList.size()
					/ perSize + 1 : dataList.size() / perSize;
			for (int sheet = 0; sheet < sheetNo; sheet++) {
				HSSFSheet tosheet = templatewb.getSheetAt(sheet);

				// data row
				int size = dataList.size();
				HSSFRow templateRow = tosheet.getRow(2);
				HSSFCellStyle[] styles = new HSSFCellStyle[templateRow
						.getPhysicalNumberOfCells()];
				for (int i = 0; i < templateRow.getPhysicalNumberOfCells(); i++) {
					styles[i] = templateRow.getCell(i).getCellStyle();
				}
				int rowSize = (sheet + 1) * perSize > size ? size : (sheet + 1)
						* perSize;
				for (int rowId = sheet * perSize; rowId < rowSize; rowId++) {

					Object[] valueList = (Object[]) dataList.get(rowId);
					HSSFRow hssfRow = tosheet.createRow(rowId + 2);
					for (int columnId = 0; columnId < (0 + valueList.length); columnId++) {
						String dataValue = String.valueOf(valueList[columnId]);

						HSSFCell cell = hssfRow.createCell(columnId);

						cell.setCellValue(dataValue);

					}
				}
			}
			// write data to new file
			OutputStream os = new FileOutputStream(new File(filePath));
			templatewb.write(os);
			os.flush();
			os.close();
		} catch (OutOfMemoryError e) {
			logger.error("Data Exceeded!", e);
			return null;
		} catch (Exception ex) {
			logger.error("", ex);
			return null;
		}
		return filePath;

	}

	@Autowired
	public void loadExproperty(ExPropertyService service,
			ExtendPropertyDao exPropertyDao) {
		List<ExtendProperty> exPropertyList = service
				.getExtendPropertyList(OrgInfo.TABLE_NAME);
		for (ExtendProperty ex : exPropertyList) {
			exPropertyMap
					.put(ex.getPropertyName(), ex.getEntityClassProperty());
		}
	}

	/**
	 * get org xml tree<br>
	 * 此方法提供机构树从根节点开始的树形XML
	 * 
	 * @param rootId
	 * @return String
	 */
	public String getOrgTree(String rootId) {
		OrgInfo root = new OrgInfo();
		List<OrgInfo> orgInfos = new ArrayList<OrgInfo>();
		if (rootId == null) {
			root = orgInfoDao.getRootOrg();
			rootId = root.getId();
		} else {
			root = orgInfoDao.get(rootId);
		}
		orgInfos = orgInfoDao.getLeavesByParentId(rootId);
		String[] fields = { "id", "orgName", "orgFullName", "contact", "tel",
				"address", "status", "level", "orgCode", "order", "pathCode" };
		String srt = XmlUtil.genreatorTreeXml(root, "id", "orgName",
				"parentId", fields, orgInfos);
		return srt;
	}

	/**
	 * get org xml tree<br>
	 * 此方法提供机构树从根节点开始的树形XML（只查询未禁用机构）
	 * 
	 * @param rootId
	 * @return String
	 */
	public String getEnabledOrgTree(String rootId)
	{
		WebApplicationContext webApplicationContext 
			= ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext();
		if ("0000100001".equals(rootId)) {
			return (String) servletContext.getAttribute("orgInfoEnableTreeXmlStr");
		}else{
			String content = (String) servletContext.getAttribute("orgInfoEnableTreeXmlStr");
			return OrgInitUtil.getTreeXmlStrById(rootId,content);
		}
	}

	public String initEnabledOrgTree(String rootId) {
		OrgInfo root = new OrgInfo();
		List<OrgInfo> orgInfos = new ArrayList<OrgInfo>();
		if (rootId == null) {
			root = orgInfoDao.getRootOrg();
			rootId = root.getId();
		} else {
			root = orgInfoDao.get(rootId);
		}
		orgInfos = orgInfoDao.getEnabledLeavesByParentId(rootId);
		String[] fields = { "id", "orgName", "orgFullName", "contact", "tel",
				"address", "status", "level", "orgCode", "order", "pathCode" };
		String srt = XmlUtil.genreatorTreeXml(root, "id", "label", "parentId",
				fields, orgInfos);

		return srt;
	}

	/**
	 * newOrg Create a new Organization <br>
	 * 新增一个机构
	 * 
	 * @param entity
	 * @return -1: Already existed. 0: Success
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String newOrg(OrgInfo entity) {
		String result = "0";

		validateOrg(entity);

		if (entity.getId() != null) {
			entity.setId(null);
		}

		OrgInfo orgInfo = orgInfoDao.getByOrgCode(entity.getOrgCode());

		if (orgInfo != null) {
			result = "-1";
			throw new AppException(
					MessageKeyConstants.ORG_EXISTED_ORGID,
					"The OrgCode has already existed. Please change the OrgCode and submit again.  ");
		} else {
			String pid = entity.getParentId();
			OrgInfo parentOrg = orgInfoDao.get(pid);
			if (parentOrg != null) {
				int levelCodeLength = 5;
				try {
					String strLevelCodeLength = paramDao
							.getValueByPath(AppConstants.ORG_LEVELCODE_LENGTH_PATH);
					levelCodeLength = Integer.parseInt(strLevelCodeLength);
				} catch (NumberFormatException e) {
					logger.error("Param {} is setting error!",
							AppConstants.ORG_LEVELCODE_LENGTH_PATH);
				}

				String maxPathCode = orgInfoDao.getMaxPathCodeByParentId(pid,
						parentOrg.getPathCode().length() + 1);
				if (maxPathCode == null) {
					maxPathCode = "1";
				}
				maxPathCode = org.apache.commons.lang.StringUtils.leftPad(
						maxPathCode, levelCodeLength, '0');
				entity.setPathCode(parentOrg.getPathCode() + maxPathCode);
			} else {
				logger.error("can not find parent organization!");
			}
			orgInfoDao.save(entity);
			orgInfoDao.getSession().flush();
			
			new Thread(new OrgInitUtil()).start();
		}
		
		// 同步SeNTServer
		syncSendToSentServerRightNow(2);
		return result;
	}

	/**
	 * update a existed org <br>
	 * 修改机构返回0表示成功，-1表示重复当orgid重复不能添加 <br>
	 * 
	 * @param entity
	 * @return String -2: No change is made. -1: Already existed. 0: Success
	 */

	public String update(OrgInfo entity) {

		String result = "0";

		validateOrg(entity);
		validateId(entity.getId());

		OrgInfo existedOrgInfo = orgInfoDao.getByOrgCode(entity.getOrgCode());

		if (existedOrgInfo != null
				&& !existedOrgInfo.getId().equals(entity.getId())) {
			result = "-1";
			throw new AppException(MessageKeyConstants.ORG_EXISTED_ORGID,
					"The OrgId has already existed. Please change the OrgId and submit again.  ");
		}
		orgInfoDao.copyUpdate(entity);

		orgInfoDao.getSession().flush();
		
		new Thread(new OrgInitUtil()).start();
		
		// 同步SeNTServer
		syncSendToSentServerRightNow(2);

		return result;
	}

	/**
	 * 日期：2011-5-16<br>
	 * 版本：V1.0<br>
	 * 描述：validateId Validate the Org Id <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-5-16 上午11:10:20 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-16<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateId(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param id
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateId(String id) {
		if (!StringUtils.hasText(id))
			throw new AppException(MessageKeyConstants.NO_SELECTED_RECORD,
					"No record is selected. ");

		return true;
	}

	/**
	 * 日期：2011-5-16<br>
	 * 版本：V1.0<br>
	 * 描述：validateOrg Validate the Org submit form <br>
	 * 主要方法：<br>
	 * ===============================================<br>
	 * 创建日期：2011-5-16 上午11:10:15 <br>
	 * 创建人 Vinson<br>
	 * ===============================================<br>
	 * 修改日期：2011-5-16<br>
	 * 修改人 Vinson<br>
	 * 修改描述 validateOrg(这里用一句话描述这个方法修改原因和作用) <br>
	 * ===============================================<br>
	 * 
	 * @param orgInfo
	 * @return boolean
	 * @Exception 异常对象 <br>
	 */
	private boolean validateOrg(OrgInfo orgInfo) {
		if (orgInfo == null)
			throw new AppException(MessageKeyConstants.INPUT_NOT_NULL,
					"The Input is null. Please check and submit again. ");

		if (!StringUtils.hasText(orgInfo.getOrgCode()))
			throw new AppException(MessageKeyConstants.ORG_CODE_NOT_NULL,
					"The Org Code is null. Please input the Org Code and submit again.");
		if (!StringUtils.hasText(orgInfo.getOrgName()))
			throw new AppException(MessageKeyConstants.ORG_NAME_NOT_NULL,
					"The Org Name is null. Please input the Org Name and submit again.");

		return true;
	}

	/**
	 * 
	 * destroy some orginfos by ids <br>
	 * 根据返回的ID数组批量注销ORGINFO（stauts='N'表示注销） )
	 * 
	 * @param args
	 */
	public void deleteSelected(String[] args) {
		if (null != args && args.length > 0) {
			for (String arg : args) {
				// VZ 20110516 Warn user to delete the children organizations
				// before delete the parent
				Collection<OrgInfo> childOrgList = orgInfoDao
						.getByParentId(arg);
				if (childOrgList != null && childOrgList.size() > 0) {
					throw new AppException(
							MessageKeyConstants.ORG_CHILDREN_NOT_NULL,
							"This Organization contain children organization. Please delete all the children organization first. ");
				}

				OrgInfo org = orgInfoDao.get(arg);
				org.setStatus("N");
				orgInfoDao.save(org);
			}
			
			orgInfoDao.getSession().flush();
			
			new Thread(new OrgInitUtil()).start();
		}
		// 同步SeNTServer
		syncSendToSentServerRightNow(2);
	}

	/**
	 * get orginfos by page object and filter<br>
	 * 根据分页对象和过滤条件对机构进行查询<br>
	 * 
	 * @param page
	 * @param property
	 * @return Page<OrgInfo>
	 */
	@Transactional(readOnly = true)
	public Page<OrgInfo> getByCondition(final Page<OrgInfo> page,
			final List<PropertyFilter> property) {
		return orgInfoDao.findPage(page, property);
	}

	/**
	 * 根据机构ID查询对应的机构信息
	 * 
	 * @param p_orgId
	 * @return
	 */
	public OrgInfo getOrgById(final String p_orgId) {
		List<OrgInfo> ls = orgInfoDao.findBy("id", p_orgId);
		if (ls.isEmpty())
			return null;
		return ls.get(0);
	}

	/**
	 * get orginfos by page object、filter and parent id<br>
	 * 根据分页对象、过滤条件和父id对机构进行分页查询
	 * 
	 * @param page
	 * @param filterParamMap
	 * @param parentId
	 * @return Page<OrgInfo>
	 */
	public Page<OrgInfo> getOrgPage(final Page<OrgInfo> page,
			Map<String, Object> propertyFilterMap, String parentId) {
		if (propertyFilterMap == null) {
			propertyFilterMap = new HashMap<String, Object>();
		}
		propertyFilterMap.put("EQS_parentId", parentId);
		page.setOrderBy("order");
		Page<OrgInfo> ret = orgInfoDao.findPageNew(page, propertyFilterMap);
		return ret;
	}

	/**
	 * 
	 * get max order+1<br>
	 * 根据父id查询子机构中最大顺序编号,然后加1
	 * 
	 * @param parentId
	 * @return Integer
	 */
	public Integer getMaxOrderValue(String parentId) {
		Integer maxOrder = orgInfoDao.findUnique(
				"select max(m.order) from OrgInfo m where m.parentId = ? ",
				parentId);
		if (maxOrder != null)
			return maxOrder + 1;
		else
			return null;
	}

	/**
	 * 
	 * get all orginfo <br>
	 * 获取全部机构
	 * 
	 * @return List<OrgInfo>
	 */
	public List<OrgInfo> getAllOrg() {
		return orgInfoDao.getAll();
	}

	/**
	 * @param file
	 *            文件字节
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public String importOrgInfoExcel(byte[] file) {
		StringBuffer errBuf = new StringBuffer(); // 错误信息

		List<OrgInfoVO> errorList = new ArrayList<OrgInfoVO>();
		List<OrgInfoVO> importList = null;
		InputStream is = new ByteArrayInputStream(file);

		try {
			HSSFWorkbook wb = new HSSFWorkbook(is);
			importList = ImportExcelUtil.importExcel(wb, 0, OrgInfoVO.class);
		} catch (IOException e) {
			logger.error("", e);
			throw new AppException(MessageKeyConstants.ORG_IMPORT_EXCEL_ERROR,
					"Import Excel error!");
		} catch (Exception e) {
			logger.error("", e);
			throw new AppException(MessageKeyConstants.ORG_IMPORT_EXCEL_ERROR,
					"Import Excel error!");
		}

		// 做检查

		// 检查机构号
		for (OrgInfoVO obj : importList) {
			if (obj.getOrgCode() == null
					|| obj.getOrgCode().trim().length() <= 0)
				return errBuf.append("机构代码必须输入").toString();

			if (obj.getParentOrgCode() == null
					|| obj.getParentOrgCode().trim().length() <= 0)
				return errBuf
						.append("机构代码【" + obj.getOrgCode() + "】的父机构代码必须输入")
						.toString();
		}

		// 检查重复性
		Set<String> orgCodeSet = new HashSet<String>();
		for (OrgInfoVO obj : importList) {
			if (!orgCodeSet.contains(obj.getOrgCode())) {
				orgCodeSet.add(obj.getOrgCode());
			} else {
				errBuf.append("机构代码【" + obj.getOrgCode() + "】重复\r\n");
			}
			OrgInfo oi = this.orgInfoDao.getByOrgCode(obj.getOrgCode());
			if (null != oi) {
				errBuf.append("机构代码【" + obj.getOrgCode()
						+ "】在系统中已存在，请重新录入。\r\n");
			}

		}
		if (errBuf.length() > 0)
			return errBuf.toString();

		// 检查机构简称
		for (OrgInfoVO obj : importList) {
			if (org.apache.commons.lang.StringUtils.isBlank(obj.getOrgName()))
				return errBuf.append("机构代码【" + obj.getOrgCode() + "】的简称必须输入")
						.toString();

			if (org.apache.commons.lang.StringUtils.isBlank(obj
					.getOrgFullName()))
				return errBuf.append("机构代码【" + obj.getOrgCode() + "】的全称必须输入")
						.toString();
		}

		// // 检查是否为数字类型
		// for (OrgInfoVO obj : importList) {
		//
		// String orderStr = obj.getOrder();
		// try {
		// Integer iOrder = Integer.valueOf(orderStr);
		// } catch (NumberFormatException e2) {
		// return errBuf.append("机构：" + obj.getOrgCode() + "的顺序必须为数字")
		// .toString();
		// }
		//
		// }

		// 数据字典范围内检查
		List enableOrDisableListTemp = sysDatadirService
				.getDatadirChildrenByPath(
						"SysDatadirMgr.javapt.common.enableOrDisable", "zh_CN");

		Map<String, String> statusMap = new HashMap<String, String>();

		for (Object object : enableOrDisableListTemp) {
			SysDatadir sdd = (SysDatadir) object;
			String key = sdd.getValue();
			String value = sdd.getKey();
			statusMap.put(key, value);
		}

		for (OrgInfoVO obj : importList) {

			String status = obj.getStatus();
			if (false == org.apache.commons.lang.StringUtils.isBlank(status)) {
				if (!statusMap.containsKey(status))
					return errBuf.append(
							"机构代码【" + obj.getOrgCode() + "】的状态必须是“启用”或“禁用”")
							.toString();
				else {
					obj.setStatus(statusMap.get(status));
				}
			} else {
				obj.setStatus("Y");// 默认启用
			}
		}

		if (errBuf.length() > 0)
			return errBuf.toString();

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (OrgInfoVO obj : importList) {
			OrgInfo parentOrg = this.orgInfoDao.getByOrgCode(obj
					.getParentOrgCode());

			// this.orgInfoDao.getSession().flush();

			if (null == parentOrg)
				return errBuf.append(
						"机构代码【" + obj.getOrgCode() + "】的父机构代码【"
								+ obj.getParentOrgCode()
								+ "】不存在。\r\n提示：可将上级机构放在下级机构之前以完成导入。")
						.toString();// 先录上级，后录下级时可规避此问题.

			obj.setParentId(parentOrg.getId());
			obj.setLevel(String
					.valueOf(Integer.valueOf(parentOrg.getLevel()) + 1));
			try {
				String parentId = obj.getParentId();
				if (parentId != null && parentId.length() > 0) {
					Integer order = map.get(parentId);
					if (order != null) {
						order++;
					} else {
						order = getMaxOrderValue(obj.getParentId());
					}
					if (order == null) {
						order = 1;
					}
					obj.setOrder(String.valueOf(order));
					OrgInfo oi = new OrgInfo();
					BeanUtils.copyProperties(oi, obj);
					newOrg(oi); // 务传播属性用于不同的类之间的业务方法调用中的事务的控制，此处传播属性设置不起作用啊！！

					map.put(parentId, order);
				} else
					throw new SysException(
							"parentId can not be empty when import from excel!");

			} catch (Exception ex) {

				// 保存出错需要继续处理其他的记录
				errorList.add(obj);
				logger.info("The org with orgCode is " + obj.getOrgCode()
						+ " import error!", ex);
			}
		}

		String codeStr = "";
		for (OrgInfoVO org : errorList) {
			codeStr = codeStr + "," + org.getOrgCode();
		}
		if (codeStr.length() > 0) {
			codeStr = codeStr.substring(1);
		}
		
		orgInfoDao.getSession().flush();
		
		new Thread(new OrgInitUtil()).start();
		
		return codeStr;
	}

	public void syncSendToSentServerRightNow(int synchType) {
		S2005Msg smsg = new S2005Msg();
		String messageNo = String.valueOf(new Date().getTime())
				.substring(1, 13);
		smsg.setType(17);
		smsg.setMessageno(Integer.parseInt(messageNo.substring(0, 9)));
		smsg.setDevidLen(0);
		smsg.setLength(4);
		smsg.setSynchInfoLen(0);
		smsg.setSynchType(synchType);

		byte[] sendpack = smsg.packMessage();

		Transfer transfer = new Transfer();
		transfer.initByService(paramDao);
		SyncThread syncThread = new SyncThread();
		syncThread.transfer = transfer;
		syncThread.sendpack = sendpack;
		syncThread.start();

	}

	class SyncThread extends Thread {
		private Transfer transfer;
		private byte[] sendpack;

		public void run() {
			try {
				transfer.sendPack(sendpack);
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

}// endclass
