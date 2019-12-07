package p4_group_8_repo;

public class LogFactory {

	public static Log getLog(String type, int xpos, int ypos, double s){
		if("LogBig".equalsIgnoreCase(type)) return new LogBig(xpos,ypos,s);
		return null;
	}
	
	
}
