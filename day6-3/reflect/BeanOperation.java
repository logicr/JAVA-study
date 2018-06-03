package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Logicr
 *�����Զ�ʵ���Զ���VOƥ�䴦�����
 */
public class BeanOperation {
	private BeanOperation() {}

	
	/**
	 * @param actionObject ��ʾ��ǰ������������ĳ���ĵ�ǰ����
	 * @param msg "emp.ename:Jan|emp.job:Student"
	 * @throws Exception
	 */
	public static void setBeanvalue(Object actionObject ,String msg) throws  Exception {
		
		
		//���в��
		String [] result = msg.split("\\|");
		for (int i = 0; i < result.length; i++) {
			String [] tmp = result[i].split(":");
			String attribute = tmp[0];//��������
//			String value = tmp [1];//����
			String [] fields = attribute.split("\\.");//
			
			
			//��ȡ�����fields[0]��emp
			Object currentObject = getObject(actionObject,fields[0]);
			//����setter���� fields[1] = ename , tmp[1] = Jan;
			setObject(currentObject, fields[1], tmp[1]);
		}
	}
	
	/**
	 * ����ĸ��д����������setter��getter����������
	 * @param str
	 * @return
	 */
	public static String initCap(String str) {
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	/**
	 * @param obj ���÷������ڵ������
	 * @param attribute ��������
	 * @return
	 * @throws Exception
	 */
	public static Object getObject(Object  obj,String attribute) throws Exception{
		String methodName = "get"+initCap(attribute);
		//ȡ�������
		Field field = obj.getClass().getDeclaredField(attribute);
		if (field == null) {
			field = obj.getClass().getField(attribute);
		}
		if (field == null) {
			return null;
		}
		//ȡ��getter����
		Method method = obj.getClass().getMethod(methodName);
		//���÷���
		return method.invoke(obj);
	}
	/**
	 * ���ö�������
	 * @param obj ����
	 * @param attribute ��������
	 * @param valve ����
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
		//setter������
		Method setMethod = obj.getClass().getMethod(methodName, field.getType());
		//��������
		setMethod.invoke(obj, valve);
	}
}
