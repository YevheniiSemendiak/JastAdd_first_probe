// Generated from /media/sem/B54BE5B22C0D3FA8/TUD/4thSemester/RAGAss/jastadd_task/build/tmp/preprocessParser/ExpressionParser.all
package de.tudresden.inf.st.most.jastadd.parser;
 import de.tudresden.inf.st.most.jastadd.ast.*; 
import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "ExpressionParser.beaver".
 */
public class ExpressionParser extends Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short NUMBER = 1;
		static public final short IDENTIFIER = 2;
		static public final short LP = 3;
		static public final short RP = 4;
		static public final short PLUS = 5;
		static public final short MULT = 6;
		static public final short NEWLINE = 7;
		static public final short EQUALS = 8;
		static public final short MINUS = 9;

		static public final String[] NAMES = {
			"EOF",
			"NUMBER",
			"IDENTIFIER",
			"LP",
			"RP",
			"PLUS",
			"MULT",
			"NEWLINE",
			"EQUALS",
			"MINUS"
		};
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9oLaErA0q4CHUzikxPTxLe$Au8W24AfKl1Ry8zlvakxRQqQJxAZgE0FztAIIOR9t1r9Zoe" +
		"qLiUURQckIflRCZGFBQm9BLnQrqXhRRHN5#kDw7n5MuLUGcykzJMqHZtjcTcx1gfKQqkRsj" +
		"QEf5tjq$6pGofVoNqmhuq$guJRphzZEwUYKkGkz8a39JESzUWUFCKcVgHh6CCD7C8HJE4Oh" +
		"iAHuenxFO5RgE42Bk41xk0Kxc42PpwV5sXoNddETqvoFl$iVTkR$UxzHVugtZ51mOicA71P" +
		"WlzpcKb1$G4bILXT");

	public ExpressionParser() {
		super(PARSING_TABLES);
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // goal = exp.exp
			{
					final Symbol _symbol_exp = _symbols[offset + 1];
					final Exp exp = (Exp) _symbol_exp.value;
					 return new Root(new List<Def>(), exp);
			}
			case 1: // goal = def_list.def_list exp.exp
			{
					final Symbol _symbol_def_list = _symbols[offset + 1];
					final List def_list = (List) _symbol_def_list.value;
					final Symbol _symbol_exp = _symbols[offset + 2];
					final Exp exp = (Exp) _symbol_exp.value;
					 return new Root(def_list, exp);
			}
			case 2: // def_list = def.def
			{
					final Symbol _symbol_def = _symbols[offset + 1];
					final Def def = (Def) _symbol_def.value;
					 return new List().add(def);
			}
			case 3: // def_list = def_list.def_list def.def
			{
					final Symbol _symbol_def_list = _symbols[offset + 1];
					final List def_list = (List) _symbol_def_list.value;
					final Symbol _symbol_def = _symbols[offset + 2];
					final Def def = (Def) _symbol_def.value;
					 return def_list.add(def);
			}
			case 4: // def = IDENTIFIER.IDENTIFIER EQUALS.EQUALS MINUS.MINUS NUMBER.NUMBER NEWLINE.NEWLINE
			{
					final Symbol IDENTIFIER = _symbols[offset + 1];
					final Symbol EQUALS = _symbols[offset + 2];
					final Symbol MINUS = _symbols[offset + 3];
					final Symbol NUMBER = _symbols[offset + 4];
					final Symbol NEWLINE = _symbols[offset + 5];
					 return new Def((String)IDENTIFIER.value, -Float.parseFloat((String)NUMBER.value));
			}
			case 5: // def = IDENTIFIER.IDENTIFIER EQUALS.EQUALS NUMBER.NUMBER NEWLINE.NEWLINE
			{
					final Symbol IDENTIFIER = _symbols[offset + 1];
					final Symbol EQUALS = _symbols[offset + 2];
					final Symbol NUMBER = _symbols[offset + 3];
					final Symbol NEWLINE = _symbols[offset + 4];
					 return new Def((String)IDENTIFIER.value, Float.parseFloat((String)NUMBER.value));
			}
			case 6: // exp = LP.LP exp.a PLUS.PLUS exp.b RP.RP
			{
					final Symbol LP = _symbols[offset + 1];
					final Symbol _symbol_a = _symbols[offset + 2];
					final Exp a = (Exp) _symbol_a.value;
					final Symbol PLUS = _symbols[offset + 3];
					final Symbol _symbol_b = _symbols[offset + 4];
					final Exp b = (Exp) _symbol_b.value;
					final Symbol RP = _symbols[offset + 5];
					 return new AddExp(a, b);
			}
			case 7: // exp = LP.LP exp.a MULT.MULT exp.b RP.RP
			{
					final Symbol LP = _symbols[offset + 1];
					final Symbol _symbol_a = _symbols[offset + 2];
					final Exp a = (Exp) _symbol_a.value;
					final Symbol MULT = _symbols[offset + 3];
					final Symbol _symbol_b = _symbols[offset + 4];
					final Exp b = (Exp) _symbol_b.value;
					final Symbol RP = _symbols[offset + 5];
					 return new MulExp(a, b);
			}
			case 8: // exp = NUMBER.NUMBER
			{
					final Symbol NUMBER = _symbols[offset + 1];
					 return new de.tudresden.inf.st.most.jastadd.ast.Number(Float.parseFloat((String)NUMBER.value));
			}
			case 9: // exp = IDENTIFIER.IDENTIFIER
			{
					final Symbol IDENTIFIER = _symbols[offset + 1];
					 return new Var((String)IDENTIFIER.value);
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}