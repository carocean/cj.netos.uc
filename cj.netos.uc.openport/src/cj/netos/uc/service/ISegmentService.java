package cj.netos.uc.service;

import java.util.List;

import cj.netos.uc.bo.Attribute;
import cj.netos.uc.bo.Segment;

public interface ISegmentService {
	void addSegment(Segment seg);
	void removeSegment(String segCode);
	Segment getSegment(String segCode);
	long getSegmentCount();
	List<Segment> getPage(int currPage, int pageSize);
	List<Attribute> getAttributesOfSegment(String segCode);
	void emptyAttributesOfSegment(String segCode);
	void removeAttribute(String segCode,String attrCode);
	void addAttribute(Attribute attr);
}
