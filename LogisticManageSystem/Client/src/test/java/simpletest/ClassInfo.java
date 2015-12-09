package simpletest;

public class ClassInfo {
	String name;
	int lineOfCode;
	double CA;
	double CE;
	double NOC;
	double DIT;
	double LCOM;	
	double VG;
	public ClassInfo(String name, int lineOfCode,  double cA, double cE,
			 double nOC, double dIT, double lCOM, double vG) {
		super();
		this.name = name;
		this.lineOfCode = lineOfCode;
		CA = cA;
		CE = cE;
		NOC = nOC;
		DIT = dIT;
		LCOM = lCOM;
		VG = vG;
	}	
}
