package com.levelsbeyond.personable.main;



import com.levelsbeyond.personable.lang.PersonableGrammarLexer;
import com.levelsbeyond.personable.lang.PersonableGrammarParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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

		ANTLRInputStream input = new ANTLRInputStream(is);
		PersonableGrammarLexer lexer = new PersonableGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PersonableGrammarParser parser = new PersonableGrammarParser(tokens);
		ParseTree tree  = parser.prog();

		PersonableVistorImpl visitor = new PersonableVistorImpl();
		visitor.visit(tree);

	}
}
