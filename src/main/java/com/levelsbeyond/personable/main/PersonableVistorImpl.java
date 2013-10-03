package com.levelsbeyond.personable.main;

import com.levelsbeyond.personable.lang.PersonableGrammarBaseVisitor;
import com.levelsbeyond.personable.lang.PersonableGrammarParser;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: ericcobb
 * Date: 10/3/13
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonableVistorImpl extends PersonableGrammarBaseVisitor{

	ArrayList<String> personList = new ArrayList<String>();

	@Override
	public String visitPrintExpr(@NotNull PersonableGrammarParser.PrintExprContext ctx) {
		String value = String.valueOf(visit(ctx.expr()));
		System.out.println(value);
		return value;
	}

	@Override
	public String visitDefinePerson(@NotNull PersonableGrammarParser.DefinePersonContext ctx) {
		String value = String.valueOf(ctx.ID());
		System.out.println("++ Defining "+value);

		personList.add(value);
		return personList.toString();
	}

	@Override
	public Object visitRemovePerson(@NotNull PersonableGrammarParser.RemovePersonContext ctx) {
		String value = String.valueOf(ctx.ID());
		personList.remove(value);
		return personList.toString();
	}

	@Override
	public String visitBlamePerson(@NotNull PersonableGrammarParser.BlamePersonContext ctx) {
		String value = String.valueOf(ctx.ID());
		if (!personList.contains(value)){
			System.out.println("++ You must define a person before blaming him or her.");
			return personList.toString();
		}

		//do something to blame person
		System.out.println("++ It's all "+value+"'s fault.");
		return personList.toString();

	}

	@Override
	public String visitHugPerson(@NotNull PersonableGrammarParser.HugPersonContext ctx) {
		String value = String.valueOf(ctx.ID());
		if (!personList.contains(value)){
			System.out.println("++ You must define a person before Hugging him or her.");
			return personList.toString();
		}

		//do something to hug person
		System.out.println("Giving " +value +" a hug.");
		return personList.toString();
	}
}
