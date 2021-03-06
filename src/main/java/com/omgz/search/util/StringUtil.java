
package com.omgz.search.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * 
 * @author 詹昌高
 * @version 2016-12-7 
 */
public class StringUtil {
    
    /** 页面端换行标识 */
    private static final String _BR = "<br/>";
    
    
    /**
	 * 将字符串有某种编码转变成另一种编码
	 * @param string 编码的字符串
	 * @param originCharset 原始编码格式
	 * @param targetCharset 目标编码格式
	 * @return String 编码后的字符串
	 */
	public static String encodeString(String string,Charset originCharset,Charset targetCharset){
		return string=new String(string.getBytes(originCharset),targetCharset);
	}
	
	/**
	 * URL编码
	 * @param string 编码字符串
	 * @param charset 编码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String encodeUrl(String string,String charset){
		if(null!=charset&&!charset.isEmpty()){
			try {
				return URLEncoder.encode(string,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return URLEncoder.encode(string);
	}
	
	/**
	 * URL编码
	 * @param string 解码字符串
	 * @param charset 解码格式
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String decodeUrl(String string,String charset){
		if(null!=charset&&!charset.isEmpty()){
			try {
				return URLDecoder.decode(string,charset);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return URLDecoder.decode(string);
	}
	/**
	 * 判断字符串是否是空的
	 * 方法摘自commons.lang
	 * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
	
	 /**
     * <p>判断字符串是否是""," ",null,注意和isEmpty的区别</p>
     * 方法摘自commons.lang
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * 判断字符串是否不为空（不截取前后空格）
     * 
     * @param str 判断字符串
     * @return 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    
    
    /**
     * 判断字符串是否不为空（截取前后空格）
     * 
     * @param str 判断字符串
     * @return 是否不为空
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
    
    /**
     * 功能描述：分割字符串
     * 
     * @param param String 原始字符串
     * @param sign String 分隔符
     * @return String[] 分割后的字符串数组
     */
    public static String[] split(String param, String sign) {
        String result = "";
        int index;
        if (param == null || sign == null) {
            return null;
        }
        ArrayList<String> al = new ArrayList<String>();
        while ((index = param.indexOf(sign)) != -1) {
            al.add(param.substring(0, index));
            result = param.substring(index + sign.length());
        }
        al.add(result);
        return al.toArray(new String[0]);
    }
    
    /**
     * 功能描述：替换字符串
     * 
     * @param from String 原始字符串
     * @param to String 目标字符串
     * @param source String 母字符串
     * @return String 替换后的字符串
     */
    public static String replace(String from, String to, String source) {
        String result = "";
        if (source == null || from == null || to == null) {
            return null;
        }
        StringBuffer str = new StringBuffer("");
        int index = -1;
        while ((index = source.indexOf(from)) != -1) {
            str.append(source.substring(0, index) + to);
            result = source.substring(index + from.length());
            index = result.indexOf(from);
        }
        str.append(result);
        return str.toString();
    }
    
    /**
     * 替换字符串，能能够在HTML页面上直接显示(替换双引号和小于号)
     * 
     * @param str String 原始字符串
     * @return String 替换后的字符串
     */
    public static String htmlencode(String str) {
        if (str == null) {
            return null;
        }
        return replace("\"", "&quot;", replace("<", "&lt;", str));
    }
    
    /**
     * 替换字符串，将被编码的转换成原始码（替换成双引号和小于号）
     * 
     * @param str String
     * @return String
     */
    public static String htmldecode(String str) {
        if (str == null) {
            return null;
        }
        return replace("&quot;", "\"", replace("&lt;", "<", str));
    }
    
    /**
     * 功能描述：在页面上直接显示文本内容，替换小于号，空格，回车，TAB
     * 
     * @param param String 原始字符串
     * @return String 替换后的字符串
     */
    public static String htmlshow(String param) {
        String result = "";
        if (param == null) {
            return null;
        }
        
        result = replace("<", "&lt;", result);
        result = replace(" ", "&nbsp;", result);
        result = replace("\r\n", _BR, result);
        result = replace("\n", _BR, result);
        result = replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;", result);
        return result;
    }
    
    /**
     * 功能描述：返回指定字节长度的字符串
     * 
     * @param str String 字符串
     * @param length int 指定长度
     * @return String 返回的字符串
     */
    public static String toLength(String str, int length) {
        if (str == null) {
            return null;
        }
        if (length <= 0) {
            return "";
        }
        try {
            if (str.getBytes("GBK").length <= length) {
                return str;
            }
        } catch (Exception e) {
        }
        StringBuffer buff = new StringBuffer();
        
        int index = 0;
        char c;
        int iLength = length - 3;
        while (iLength > 0) {
            c = str.charAt(index);
            if (c < 128) {
                iLength--;
            } else {
                iLength--;
                iLength--;
            }
            buff.append(c);
            index++;
        }
        buff.append("...");
        return buff.toString();
    }
    
    /**
     * 功能描述：判断是否为整数
     * 
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");
        return pattern.matcher(str).matches();
    }
    
    /**
     * 判断是否为浮点数，包括double和float
     * 
     * @param str 传入的字符串
     * @return 是浮点数返回true,否则返回false
     */
    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?\\d+\\.\\d+$");
        return pattern.matcher(str).matches();
    }
    
    /**
     * 判断是不是合法字符
     * 
     * @param param 要判断的字符
     * @return 是否为合法字符串
     */
    public static boolean isLetter(String param) {
        if (param == null || param.length() < 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\w\\.-_]*");
        return pattern.matcher(param).matches();
    }
    
    /**
     * 从指定的字符串中提取Email
     * 
     * @param param content指定的字符串
     * @return 字符串中的Email
     */
    public static String parse(String param) {
        String email = null;
        if (param == null || param.length() < 1) {
            return email;
        }
        // 找出含有@
        int beginPos;
        int i;
        String token = "@";
        String preHalf = "";
        String sufHalf = "";
        
        beginPos = param.indexOf(token);
        if (beginPos > -1) {
            // 前项扫描
            String s = null;
            i = beginPos;
            while (i > 0) {
                s = param.substring(i - 1, i);
                if (isLetter(s)) {
                    preHalf = s + preHalf;
                } else {
                    break;
                }
                i--;
            }
            // 后项扫描
            i = beginPos + 1;
            while (i < param.length()) {
                s = param.substring(i, i + 1);
                if (isLetter(s)) {
                    sufHalf = sufHalf + s;
                } else {
                    break;
                }
                i++;
            }
            // 判断合法性
            email = preHalf + "@" + sufHalf;
            if (isEmail(email)) {
                return email;
            }
        }
        return null;
    }
    
    /**
     * 判断输入的字符串是否符合Email样式.
     * 
     * @param emailParam 传入的字符串
     * @return 是Email样式返回true,否则返回false
     */
    public static boolean isEmail(String emailParam) {
        if (emailParam == null || emailParam.length() < 1 || emailParam.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(emailParam).matches();
    }
    
    /**
     * 功能描述：判断输入的字符串是否为纯汉字
     * 
     * @param str 传入的字符串
     * @return 如果是纯汉字返回true,否则返回false
     */
    public static boolean isChinese(String str) {
        Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
        return pattern.matcher(str).matches();
    }
    
    /**
     * 判断是否为质数
     * 
     * @param param 要判断的数字
     * @return 数字是否为质数
     */
    public static boolean isPrime(int param) {
        if (param <= 7) {
            if (param == 2 || param == 3 || param == 5 || param == 7) {
                return true;
            }
        }
        int c = 7;
        if (param % 2 == 0) {
            return false;
        }
        if (param % 3 == 0) {
            return false;
        }
        if (param % 5 == 0) {
            return false;
        }
        int end = (int) Math.sqrt(param);
        while (c <= end) {
            if (param % c == 0) {
                return false;
            }
            c += 4;
            if (param % c == 0) {
                return false;
            }
            c += 2;
            if (param % c == 0) {
                return false;
            }
            c += 4;
            if (param % c == 0) {
                return false;
            }
            c += 2;
            if (param % c == 0) {
                return false;
            }
            c += 4;
            if (param % c == 0) {
                return false;
            }
            c += 6;
            if (param % c == 0) {
                return false;
            }
            c += 2;
            if (param % c == 0) {
                return false;
            }
            c += 6;
        }
        return true;
    }
    
    /**
     * 人民币转成大写
     * 
     * @param param 数字字符串
     * @return 人民币转换成大写后的字符串
     */
    public static String hangeToBig(String param) {
        double value;
        try {
            value = Double.parseDouble(param.trim());
        } catch (Exception e) {
            return null;
        }
        char[] hunit = { '拾', '佰', '仟' }; // 段内位置表示
        char[] vunit = { '万', '亿' }; // 段名表示
        char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' }; // 数字表示
        long midVal = (long) (value * 100); // 转化成整形
        String valStr = String.valueOf(midVal); // 转化成字符串
        
        String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
        String rail = valStr.substring(valStr.length() - 2); // 取小数部分
        
        String prefix = ""; // 整数部分转化的结果
        String suffix = ""; // 小数部分转化的结果
        // 处理小数点后面的数
        if (rail.equals("00")) { // 如果小数部分为0
            suffix = "整";
        } else {
            suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
        }
        // 处理小数点前面的数
        char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
        char zero = '0'; // 标志'0'表示出现过0
        byte zeroSerNum = 0; // 连续出现0的次数
        for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
            int idx = (chDig.length - i - 1) % 4; // 取段内位置
            int vidx = (chDig.length - i - 1) / 4; // 取段位置
            if (chDig[i] == '0') { // 如果当前字符是0
                zeroSerNum++; // 连续0次数递增
                if (zero == '0') { // 标志
                    zero = digit[0];
                } else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
                    prefix += vunit[vidx - 1];
                    zero = '0';
                }
                continue;
            }
            zeroSerNum = 0; // 连续0次数清零
            if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
                prefix += zero;
                zero = '0';
            }
            prefix += digit[chDig[i] - '0']; // 转化该数字表示
            if (idx > 0) {
                prefix += hunit[idx - 1];
            }
            if (idx == 0 && vidx > 0) {
                prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
            }
        }
        
        if (prefix.length() > 0) {
            prefix += '圆'; // 如果整数部分存在,则有圆的字样
        }
        return prefix + suffix; // 返回正确表示
    }
    
    /**
     * 功能描述：去掉字符串中重复的子字符串
     * 
     * @param str 原字符串，如果有子字符串则用空格隔开以表示子字符串
     * @return String 返回去掉重复子字符串后的字符串
     */
    private static String removeSameString(String str) {
        Set<String> mLinkedSet = new LinkedHashSet<String>();// set集合的特征：其子集不可以重复
        String[] strArray = str.split(" ");// 根据空格(正则表达式)分割字符串
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < strArray.length; i++) {
            if (!mLinkedSet.contains(strArray[i])) {
                mLinkedSet.add(strArray[i]);
                sb.append(strArray[i] + " ");
            }
        }
        System.out.println(mLinkedSet);
        return sb.toString();
    }
    
    /**
     * 过滤特殊字符
     * 
     * @param param 要过滤的字符
     * @return 过滤特殊字符后的字符串
     */
    public static String encoding(String param) {
        if (param == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String strParam = "";
        if (param != null) {
            strParam = param.trim();
            for (int pos = 0; pos < strParam.length(); pos++) {
                switch (strParam.charAt(pos)) {
                    case '\"':
                        result.append("&quot;");
                        break;
                    case '<':
                        result.append("&lt;");
                        break;
                    case '>':
                        result.append("&gt;");
                        break;
                    case '\'':
                        result.append("&apos;");
                        break;
                    case '&':
                        result.append("&amp;");
                        break;
                    case '%':
                        result.append("&pc;");
                        break;
                    case '_':
                        result.append("&ul;");
                        break;
                    case '#':
                        result.append("&shap;");
                        break;
                    case '?':
                        result.append("&ques;");
                        break;
                    default:
                        result.append(strParam.charAt(pos));
                        break;
                }
            }
        }
        return result.toString();
    }
    
    /**
     * 判断是不是合法的手机号码
     * 
     * @param param 要判断的字符串
     * @return 是否为合法手机号码
     */
    public static boolean isHandset(String param) {
        try {
            String regex = "^1[\\d]{10}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(param);
            return matcher.matches();
        } catch (RuntimeException e) {
            return false;
        }
    }
    
    /**
     * 反过滤特殊字符
     * 
     * @param param 要过滤的字符串
     * @return 过滤后的字符串
     */
    public static String decoding(String param) {
        if (param == null) {
            return "";
        }
        String result = param;
        result = result.replace("&quot;", "\"").replace("&apos;", "\'");
        result = result.replace("&lt;", "<").replace("&gt;", ">");
        result = result.replace("&amp;", "&");
        result = result.replace("&pc;", "%").replace("&ul", "_");
        result = result.replace("&shap;", "#").replace("&ques", "?");
        return result;
    }
    
    /**
     * 字符串IOS转UTF
     * 
     * @param param 待转换的字符串
     * @return utf-8格式的字符串
     * @throws UnsupportedEncodingException 异常信息
     */
    public static String getChineseName(String param) throws UnsupportedEncodingException {
        return new String(param.toString().getBytes("iso-8859-1"), "UTF-8");
    }
    
    /**
     * 测试方法
     * 
     * @param args 参数
     */
    public static void main(String[] args) {
        // String source = "abcdefgabcdefgabcdefgabcdefgabcdefgabcdefg";
        // String from = "efg";
        // String to = "房贺威";
        // System.out.println("在字符串source中，用to替换from，替换结果为："
        // + replace(from, to, source));
        // System.out.println("返回指定字节长度的字符串："
        // + toLength("abcdefgabcdefgabcdefgabcdefgabcdefgabcdefg", 9));
        // System.out.println("判断是否为整数：" + isInteger("+0"));
        // System.out.println("判断是否为浮点数，包括double和float：" + isDouble("+0.36"));
        // System.out.println("判断输入的字符串是否符合Email样式：" +
        // isEmail("fhwbj@163.com"));
        // System.out.println("判断输入的字符串是否为纯汉字：" + isChinese("你好！"));
        // System.out.println("判断输入的数据是否是质数：" + isPrime(12));
        // System.out.println("人民币转换成大写：" + hangeToBig("10019658"));
        System.out.println("去掉字符串中重复的子字符串：" + removeSameString("100 100 9658"));
        // System.out.println("过滤特殊字符：" + encoding("100\"s<>fdsd100 9658"));
        // System.out.println("判断是不是合法的手机号码：" + isHandset("15981807340"));
        
        // System.out.println("从字符串中取值Email：" + parse("159818 fwhbj@163.com
        // 07340"));
    }
}
