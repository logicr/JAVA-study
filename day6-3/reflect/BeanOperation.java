package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Logicr
 *负责自动实现自动的VO匹配处理操作
 */
public class BeanOperation {
	private BeanOperation() {}

	
	/**
	 * @param actionObject 表示当前发出设置请求的程序的当前对象？
	 * @param msg "emp.ename:Jan|emp.job:Student"
	 * @throws Exception
	 */
	public static void setBeanvalue(Object actionObject ,String msg) throws  Exception {
		
		
		//进行拆分
		String [] result = msg.split("\\|");
		for (int i = 0; i < result.length; i++) {
			String [] tmp = result[i].split(":");
			String attribute = tmp[0];//属性名称
//			String value = tmp [1];//内容
			String [] fields = attribute.split("\\.");//
			
			
			//获取类对象，fields[0]：emp
			Object currentObject = getObject(actionObject,fields[0]);
			//调用setter方法 fields[1] = ename , tmp[1] = Jan;
			setObject(currentObject, fields[1], tmp[1]);
		}
	}
	
	/**
	 * 首字母大写操作，构造setter、getter方法的名字
	 * @param str
	 * @return
	 */
	public static String initCap(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	/**
	 * @param obj 调用方法所在的类对象
	 * @param attribute 属性名称
	 * @return
	 * @throws Exception
	 */
	public static Object getObject(Object  obj,String attribute) throws Exception{
		String methodName = "get"+initCap(attribute);
		//取得类对象
		Field field = obj.getClass().getDeclaredField(attribute);
		if (field == null) {
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			return null;
		}
		//取得getter方法
		Method method = obj.getClass().getMethod(methodName);
		//调用返回
		return method.invoke(obj);
	}
	/**
	 * 设置对象属性
	 * @param obj 对象
	 * @param attribute 属性名称
	 * @param valve 内容
	 * @throws Exception
	 */
	public static void setObject(Object obj,String attribute,String valve) throws Exception {
		Field field = obj.getClass().getDeclaredField(attribute);
		
		if (field == null) {
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			return ;
		}
		String methodName = "set"+initCap(attribute);
		//setter方法，
		Method setMethod = obj.getClass().getMethod(methodName, field.getType());
		//设置属性
		setMethod.invoke(obj, valve);
	}
}
