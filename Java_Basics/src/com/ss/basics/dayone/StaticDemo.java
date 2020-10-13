/**
 * 
 */
package com.ss.basics.dayone;

/**
 * @author ppradhan
 *
 */
public class StaticDemo {
	
	public static void main(String[] args) {
		Static stClassOne = new Static();
		stClassOne.printInstanceCount();
		
		Static stClassTwo = new Static();
		stClassTwo.printInstanceCount();
		
		Static stClassThree = new Static();
		stClassThree.printInstanceCount();
	}
}
