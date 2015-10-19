package com.bruce.common;

import com.bruce.common.json.JsonUtil;
import com.bruce.util.Base64Util;
import com.bruce.util.ClassScanUtil;
import com.bruce.util.CookieUtil;
import com.bruce.util.DESPlusUtil;
import com.bruce.util.DateUtils;
import com.bruce.util.FileUtil;
import com.bruce.util.GB2AlphaUtil;
import com.bruce.util.HTMLParserUtil;
import com.bruce.util.IOUtil;
import com.bruce.util.ObjectUtils;
import com.bruce.util.ParamUtils;
import com.bruce.util.PinyinUtil;
import com.bruce.util.ReflectUtil;
import com.bruce.util.SessionUtil;
import com.bruce.util.StringUtil;
import com.bruce.util.TokenUtil;

/**
 * 公用工具汇总类，汇总了系统中可外放的所有Utils工具类。 其他模块工具类，必须要实现该类
 * 
 * @author wqtan
 * @create 2012-04-20
 */
public interface CommonUtils {
	/**
	 * 日期操作
	 */
	public static final DateUtils dateUtils = new DateUtils();
	/**
	 * 字符串操作
	 */
	public static final StringUtil stringUtil = new StringUtil();
	/**
	 * 对象操作
	 */
	public static final ObjectUtils objectUtils = new ObjectUtils();
	/**
	 * request获取参数操作
	 */
	public static final ParamUtils paramUtils = new ParamUtils();
	/**
	 * session操作
	 */
	public static final SessionUtil sessionUtil = new SessionUtil();
	/**
	 * cookie操作
	 */
	public static final CookieUtil cookieUtil = new CookieUtil();
	/**
	 * json操作
	 */
	public static final JsonUtil jsonUtil = new JsonUtil();
	/**
	 * IO操作
	 */
	public static final IOUtil ioUtil = new IOUtil();
	/**
	 * 文件操作
	 */
	public static final FileUtil fileUtil = new FileUtil();
	/**
	 * Base64加密
	 */
	public static final Base64Util base64Util = new Base64Util();
	/**
	 * 拼音操作
	 */
	public static final PinyinUtil pinyinUtil = new PinyinUtil();
	/**
	 * 获得汉语字符串拼音首字母
	 */
	public static final GB2AlphaUtil gb2AlphaUtil = new GB2AlphaUtil();
	/**
	 * html处理
	 */
	public static final HTMLParserUtil htmlParserUtil = new HTMLParserUtil();
	/**
	 * 加密操作
	 */
	public static final DESPlusUtil desPlus = new DESPlusUtil();
	/**
	 * 类扫描
	 */
	public static final ClassScanUtil classScanUtil = new ClassScanUtil();
	/**
	 * 反射
	 */
	public static final ReflectUtil reflectUtil = new ReflectUtil();
	/**
	 * Token工具（防止重复提交）
	 */
	public static final TokenUtil tokenUtil = TokenUtil.getInstance();

}
