package com.buntoy.wallet.util;

import android.util.Log;


/**
 * 类描述：Log打印工具类
 *
 */

public class LogUtil {
	private final boolean logFlag=true; // 控制所有的log 是否显示，true 显示 false 不显示,
	private static final String tag = "app";
	private final static int logLevel = Log.VERBOSE;
	private final String mClassName;
	private static LogUtil klog;
	private static final String KESEN = "Daniel";

	private LogUtil() {
		mClassName = KESEN;
	}

	public static LogUtil getInstance() {
		if (klog == null) {
			klog = new LogUtil();
			Log.i(tag, log);
		}
		return klog;
	}

	private String getFunctionName() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		if (sts == null) {
			return null;
		}
		for (StackTraceElement st : sts) {
			if (st.isNativeMethod()) {
				continue;
			}
			if (st.getClassName().equals(Thread.class.getName())) {
				continue;
			}
			if (st.getClassName().equals(this.getClass().getName())) {
				continue;
			}
			return mClassName + "[" + Thread.currentThread().getName() + "--thread--" + st.getFileName() + "--file--" + st.getLineNumber() + "--line--" + st.getMethodName() + "--function--]";
		}
		return null;
	}

	public void i(Object str) {
		if (logFlag) { // 判断是否显示log
			if (logLevel <= Log.INFO) {
				String name = getFunctionName();
				if (name != null) {
					Log.i(tag, name + " - " + str);
				} else {
					Log.i(tag, str.toString());
				}
			}
		}
	}

	public void d(Object str) {
		if (logFlag) {
			if (logLevel <= Log.DEBUG) {
				String name = getFunctionName();
				if (name != null) {
					Log.d(tag, name + " - " + str);
				} else {
					Log.d(tag, str.toString());
				}
			}
		}
	}

	public void v(Object str) {
		if (logFlag) {
			if (logLevel <= Log.VERBOSE) {
				String name = getFunctionName();
				if (name != null) {
					Log.v(tag, name + " - " + str);
				} else {
					Log.v(tag, str.toString());
				}
			}
		}
	}

	public void w(Object str) {
		if (logFlag) {
			if (logLevel <= Log.WARN) {
				String name = getFunctionName();
				if (name != null) {
					Log.w(tag, name + " - " + str);
				} else {
					Log.w(tag, str.toString());
				}
			}
		}
	}

	public void e(Object str) {
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				String name = getFunctionName();
				if (name != null) {
					Log.e(tag, name + " - " + str);
				} else {
					Log.e(tag, str.toString());
				}
			}
		}
	}

	public void e(Exception ex) {
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				Log.e(tag, "error", ex);
			}
		}
	}

	public void e(String log, Throwable tr) {
		if (logFlag) {
			String line = getFunctionName();
			Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + mClassName + line + ":] " + log + "\n", tr);
		}
	}

	private static String log="" +
			"/** \n" +
			" *                             _ooOoo_ \n" +
			" *                            o8888888o \n" +
			" *                            88\" . \"88 \n" +
			" *                            (| -_- |) \n" +
			" *                            O\\  =  /O \n" +
			" *                         ____/`---'\\____ \n" +
			" *                       .'  \\\\|     |//  `. \n" +
			" *                      /  \\\\|||  :  |||//  \\ \n" +
			" *                     /  _||||| -:- |||||-  \\ \n" +
			" *                     |   | \\\\\\  -  /// |   | \n" +
			" *                     | \\_|  ''\\---/''  |   | \n" +
			" *                     \\  .-\\__  `-`  ___/-. / \n" +
			" *                   ___`. .'  /--.--\\  `. . __ \n" +
			" *                .\"\" '<  `.___\\_<|>_/___.'  >'\"\". \n" +
			" *               | | :  `- \\`.;`\\ _ /`;.`/ - ` : | | \n" +
			" *               \\  \\ `-.   \\_ __\\ /__ _/   .-` /  / \n" +
			" *          ======`-.____`-.___\\_____/___.-`____.-'====== \n" +
			" *                             `=---=' \n" +
			" *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ \n" +
			" *                     佛祖保佑        永无BUG \n" +
			" *            佛曰: \n" +
			" *                   写字楼里写字间，写字间里程序员； \n" +
			" *                   程序人员写程序，又拿程序换酒钱。 \n" +
			" *                   酒醒只在网上坐，酒醉还来网下眠； \n" +
			" *                   酒醉酒醒日复日，网上网下年复年。 \n" +
			" *                   但愿老死电脑间，不愿鞠躬老板前； \n" +
			" *                   奔驰宝马贵者趣，公交自行程序员。 \n" +
			" *                   别人笑我忒疯癫，我笑自己命太贱； \n" +
			" *                   不见满街漂亮妹，哪个归得程序员？ \n" +
			"*/  ";
}