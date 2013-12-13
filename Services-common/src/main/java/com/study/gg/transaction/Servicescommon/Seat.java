package com.study.gg.transaction.Servicescommon;

import java.io.Serializable;

public class Seat implements Serializable{
	private int id;
	private boolean isLock =false;
	public Seat(int num)
	{
		this.id = num;
	}
	@Override public String toString() {
		return "Place n°"+this.id;
	}
	public void LockerUnLocker()
	{
		this.isLock = !this.isLock;
	}
}
