package bean;

import java.io.Serializable;

/**
 * ������ΪjavaBean����JSP�ļ�����
 * @author E-Kunt
 *
 */
public class Count implements Serializable {

	private static final long serialVersionUID = 1L;
	private int count = 0;
	
	public int getCount() {
		count++;
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
}
