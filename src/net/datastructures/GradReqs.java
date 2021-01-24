package net.datastructures;

public class GradReqs {

	private int numCS;
	private int num4000;
	private boolean sys;
	private boolean theory;
	private boolean design;
	private boolean imps;
	
	public GradReqs(int nCS, int n4000, boolean s, boolean t, boolean d, boolean i) {
		numCS = nCS;
		num4000 = n4000;
		sys = s;
		theory = t;
		design = d;
		imps = i;
	}
	
	public int getCS() {
		return numCS;
	}
	public int get4000() {
		return num4000;
	}
	public boolean getSys() {
		return sys;
	}
	public boolean getTheory() {
		return theory;
	}
	public boolean getDesign() {
		return design;
	}
	public boolean getImps() {
		return imps;
	}
	
}
