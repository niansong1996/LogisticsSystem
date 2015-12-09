package simpletest;

public class ClassInfo {
	String name;
	double complexity;
	int lineOfCode;
	int lineOfExlanation;
	double CBO;
	double DAC;
	double NOC;
	double DIT;
	double LCOM;
	public ClassInfo(String name, double complexity, int lineOfCode, int lineOfExlanation, double cBO, double dAC,
			double nOC, double dIT, double lCOM) {
		this.name = name;
		this.complexity = complexity;
		this.lineOfCode = lineOfCode;
		this.lineOfExlanation = lineOfExlanation;
		CBO = cBO;
		DAC = dAC;
		NOC = nOC;
		DIT = dIT;
		LCOM = lCOM;
	}


}
