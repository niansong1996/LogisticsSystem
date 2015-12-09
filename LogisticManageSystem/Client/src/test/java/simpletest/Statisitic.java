package simpletest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Statisitic {
	
	private Element root;
	private List<Element> packages;
	private ArrayList<ClassInfo> infos;
	
	public static final String CLIENT = "F:/Github/LogisticsSystem/Documentations/Metrics_Client.xml";
	public static final String COMMON = "F:/Github/LogisticsSystem/Documentations/Metrics_Common.xml";
	public static final String SERVER = "F:/Github/LogisticsSystem/Documentations/Metrics_Server.xml";
	
	public Statisitic(String path) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			root = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		infos = new ArrayList<ClassInfo>();
		getPackageRoots();
	}
	
	public Iterator<ClassInfo> startStatistic(){
		Iterator<Element> iterator = packages.iterator();
		while(iterator.hasNext()) {
			
			Element packageElement = iterator.next();
			List<?> classes = packageElement.elements("CompilationUnit");
			Iterator<?> classIterater = classes.iterator();
			List<?> cace = packageElement.elements("Metrics");
			Iterator<?> cacei = cace.iterator();
			
			double CA=0,CE=0,NOC=0;
			while(cacei.hasNext()) {
				Element caceElement = (Element) cacei.next();
				List<?> metrix = caceElement.elements("Metric");
				Iterator<?> me = metrix.iterator();
				while(me.hasNext()) {
					Element meMetrix = (Element) me.next();
					if(meMetrix.attributeValue("id").equals("CA")) {
						CA = Double.parseDouble(meMetrix.attributeValue("value"));
					}
					if(meMetrix.attributeValue("id").equals("CE")) {
						CE = Double.parseDouble(meMetrix.attributeValue("value"));
					}
					if(meMetrix.attributeValue("id").equals("NOC")) {
						NOC = Double.parseDouble(meMetrix.attributeValue("value"));
					}
				}
			}
			
			while(classIterater.hasNext()) {
				Element classElement = (Element) classIterater.next();
				List<?> classInters = classElement.elements("Type");
				Iterator<?> classInterInterater = classInters.iterator();
				while(classInterInterater.hasNext()) {
					Element singleClass = (Element) classInterInterater.next();
					String name = singleClass.attributeValue("handle");
					int lineOfCode = 0;
					double LCOM = 0;
					double VG = 0;
					double DIT = 0;
					List<?> metrixs = singleClass.elements("Metrics");
					Iterator<?> metrixsIterator = metrixs.iterator();
					while(metrixsIterator.hasNext()) {
						Element metrix = (Element) metrixsIterator.next();
						List<?> metrixList = metrix.elements("Metric");
						Iterator<?> metrixi = metrixList.iterator();
						while(metrixi.hasNext()) {
							Element m = (Element) metrixi.next();
							String id = m.attributeValue("id");
							if(id.equals("MLOC")) {
								lineOfCode = Integer.parseInt(m.attributeValue("value"));
							}
							if(id.equals("LCOM")) {
								LCOM = Double.parseDouble(m.attributeValue("value"));
							}
							if(id.equals("VG")) {
								VG = Double.parseDouble(m.attributeValue("avg"));
							}
							if(id.equals("MLOC")) {
								DIT = Double.parseDouble(m.attributeValue("value"));
							}
						}
					}
					
					ClassInfo info = new ClassInfo(name, lineOfCode, CA, CE, NOC, DIT, LCOM, VG);
					infos.add(info);
				}
			}
		}
		return infos.iterator();
	}
	
	@SuppressWarnings("unchecked")
	private void getPackageRoots(){
		Element project = root.element("Project");
		List<?> packageRs = project.elements("PackageRoot");
		Iterator<?> i = packageRs.iterator();
		while(i.hasNext()) {
			Element element = (Element) i.next();
			if(element.attributeValue("name").equals("java")) {
				packages = element.elements("Package");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		Statisitic s = new Statisitic(Statisitic.CLIENT);
		Iterator<ClassInfo> i = s.startStatistic();
		while(i.hasNext()) {
			ClassInfo info = i.next();
			System.out.println(info.name);
		}
	}
	

}
