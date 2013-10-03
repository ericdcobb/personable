package com.levelsbeyond.personable.main;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ericcobb
 * Date: 10/3/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Personable {
	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if ( args.length>0 ) inputFile = args[0];
		InputStream is = System.in;
		if ( inputFile!=null ) is = new FileInputStream(inputFile);
		System.out.println(is);
	}
}
