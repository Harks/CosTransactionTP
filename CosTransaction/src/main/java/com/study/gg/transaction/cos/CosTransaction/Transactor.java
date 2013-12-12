package com.study.gg.transaction.cos.CosTransaction;

public class Transactor {
	private LockerSeatHandler lockhandler;
	private SideBySideHandler sidehandler;
	private AvailableHandler availhandler;
	public void begin(){}
	public void commit(){}
	public void rollback(){}
	public LockerSeatHandler getLockhandler() {
		lockhandler = new LockerSeatHandler();
		return lockhandler;
	}
	public SideBySideHandler getSidehandler() {
		sidehandler = new SideBySideHandler();
		return sidehandler;
	}
	public AvailableHandler getAvailhandler() {
		availhandler = new AvailableHandler();
		return availhandler;
	}
}
