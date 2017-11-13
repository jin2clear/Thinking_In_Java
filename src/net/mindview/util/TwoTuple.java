package net.mindview.util;

public class TwoTuple<A,B> {
	public final A first;
	public final B second;
	public TwoTuple(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}
	public String toString(){
		return "(" + first + ", " + second + ")";
	}
}
