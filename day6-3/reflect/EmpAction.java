package reflect;

/**
 * @author Logicr
 *
 */
public class EmpAction {
	private Emp emp = new Emp();
	public void setValue(String value) throws Exception {
		//this «±æ¿‡
		BeanOperation.setBeanvalue(this, value);
	}
	public Emp getEmp() {
		return emp;
	}
}
