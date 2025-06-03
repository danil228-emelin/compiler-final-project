// Generated from ./GrammarMinilang.g4 by ANTLR 4.13.2
package main;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarMinilangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, LINE_COMMENT=7, COMMENT=8, 
		VAR=9, MIN=10, COND_WHILE=11, IF=12, THEN=13, ELSE=14, WHILE=15, ASSIGN=16, 
		PRINT=17, MUL=18, DIV=19, ADD=20, SUB=21, NOT=22, AND=23, OR=24, GT=25, 
		LT=26, GE=27, LE=28, EQ=29, NE=30, INT_TYPE=31, STRING_TYPE=32, NEWLINE=33, 
		WS=34, STRING=35, ESC_SEQ=36, ID=37, INT=38;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_block = 2, RULE_whileStat = 3, RULE_ifStat = 4, 
		RULE_assignSt = 5, RULE_printing = 6, RULE_expr = 7, RULE_variable_decl = 8, 
		RULE_type_basic = 9, RULE_left_expr = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "block", "whileStat", "ifStat", "assignSt", "printing", 
			"expr", "variable_decl", "type_basic", "left_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "','", "':'", null, null, "'var'", 
			"'min'", "'__cond'", "'if'", "'then'", "'else'", "'while'", "'='", "'print'", 
			"'*'", "'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'>'", "'<'", "'>='", 
			"'<='", "'=='", "'!='", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "LINE_COMMENT", "COMMENT", 
			"VAR", "MIN", "COND_WHILE", "IF", "THEN", "ELSE", "WHILE", "ASSIGN", 
			"PRINT", "MUL", "DIV", "ADD", "SUB", "NOT", "AND", "OR", "GT", "LT", 
			"GE", "LE", "EQ", "NE", "INT_TYPE", "STRING_TYPE", "NEWLINE", "WS", "STRING", 
			"ESC_SEQ", "ID", "INT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GrammarMinilang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarMinilangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				stat();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 455270899592L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends StatContext {
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public WhileStatementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlankContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public BlankContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitBlank(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintSmthContext extends StatContext {
		public PrintingContext printing() {
			return getRuleContext(PrintingContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public PrintSmthContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitPrintSmth(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends StatContext {
		public TerminalNode LINE_COMMENT() { return getToken(GrammarMinilangParser.LINE_COMMENT, 0); }
		public CommentContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public IfStatementContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends StatContext {
		public Variable_declContext variable_decl() {
			return getRuleContext(Variable_declContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public DeclarationContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_actionContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public Expr_actionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitExpr_action(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultipleCommentContext extends StatContext {
		public TerminalNode COMMENT() { return getToken(GrammarMinilangParser.COMMENT, 0); }
		public MultipleCommentContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitMultipleComment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StatContext {
		public AssignStContext assignSt() {
			return getRuleContext(AssignStContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				assignSt();
				setState(29);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(28);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				ifStat();
				}
				break;
			case 3:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				whileStat();
				}
				break;
			case 4:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				match(NEWLINE);
				}
				break;
			case 5:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(34);
				match(LINE_COMMENT);
				}
				break;
			case 6:
				_localctx = new MultipleCommentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(35);
				match(COMMENT);
				}
				break;
			case 7:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(36);
				variable_decl();
				setState(38);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(37);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 8:
				_localctx = new PrintSmthContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(40);
				printing();
				setState(42);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(41);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 9:
				_localctx = new Expr_actionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				expr(0);
				setState(46);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(45);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Single_logic_blockContext extends BlockContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Single_logic_blockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitSingle_logic_block(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_logic_blockContext extends BlockContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Multiple_logic_blockContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitMultiple_logic_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new Multiple_logic_blockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__0);
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(51);
					stat();
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 455270899592L) != 0) );
				setState(56);
				match(T__1);
				}
				break;
			case T__2:
			case LINE_COMMENT:
			case COMMENT:
			case VAR:
			case MIN:
			case COND_WHILE:
			case IF:
			case WHILE:
			case PRINT:
			case NOT:
			case NEWLINE:
			case STRING:
			case ID:
			case INT:
				_localctx = new Single_logic_blockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GrammarMinilangParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(WHILE);
			setState(62);
			expr(0);
			setState(63);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GrammarMinilangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(GrammarMinilangParser.THEN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(GrammarMinilangParser.ELSE, 0); }
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(IF);
			setState(66);
			expr(0);
			setState(67);
			match(THEN);
			setState(68);
			block();
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(69);
				match(ELSE);
				setState(70);
				block();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStContext extends ParserRuleContext {
		public Left_exprContext left_expr() {
			return getRuleContext(Left_exprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(GrammarMinilangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignSt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitAssignSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignStContext assignSt() throws RecognitionException {
		AssignStContext _localctx = new AssignStContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			left_expr();
			setState(74);
			match(ASSIGN);
			setState(75);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintingContext extends ParserRuleContext {
		public PrintingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printing; }
	 
		public PrintingContext() { }
		public void copyFrom(PrintingContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStringContext extends PrintingContext {
		public TerminalNode PRINT() { return getToken(GrammarMinilangParser.PRINT, 0); }
		public TerminalNode STRING() { return getToken(GrammarMinilangParser.STRING, 0); }
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public PrintStringContext(PrintingContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitPrintString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintExprContext extends PrintingContext {
		public TerminalNode PRINT() { return getToken(GrammarMinilangParser.PRINT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(GrammarMinilangParser.NEWLINE, 0); }
		public PrintExprContext(PrintingContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintingContext printing() throws RecognitionException {
		PrintingContext _localctx = new PrintingContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printing);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new PrintStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(PRINT);
				setState(78);
				match(STRING);
				setState(79);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(PRINT);
				setState(81);
				expr(0);
				setState(82);
				match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalNotContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GrammarMinilangParser.NOT, 0); }
		public LogicalNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(GrammarMinilangParser.AND, 0); }
		public LogicalAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitLogicalAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(GrammarMinilangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(GrammarMinilangParser.SUB, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(GrammarMinilangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(GrammarMinilangParser.DIV, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitMulDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinValueContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MIN() { return getToken(GrammarMinilangParser.MIN, 0); }
		public MinValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitMinValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Cond_valueContext extends ExprContext {
		public TerminalNode COND_WHILE() { return getToken(GrammarMinilangParser.COND_WHILE, 0); }
		public Cond_valueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitCond_value(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Cond_value_exprContext extends ExprContext {
		public TerminalNode COND_WHILE() { return getToken(GrammarMinilangParser.COND_WHILE, 0); }
		public TerminalNode ASSIGN() { return getToken(GrammarMinilangParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Cond_value_exprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitCond_value_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(GrammarMinilangParser.LT, 0); }
		public TerminalNode GT() { return getToken(GrammarMinilangParser.GT, 0); }
		public TerminalNode LE() { return getToken(GrammarMinilangParser.LE, 0); }
		public TerminalNode GE() { return getToken(GrammarMinilangParser.GE, 0); }
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(GrammarMinilangParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(GrammarMinilangParser.OR, 0); }
		public LogicalOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitLogicalOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ExprContext {
		public Token op;
		public TerminalNode INT() { return getToken(GrammarMinilangParser.INT, 0); }
		public TerminalNode STRING() { return getToken(GrammarMinilangParser.STRING, 0); }
		public ValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(GrammarMinilangParser.EQ, 0); }
		public TerminalNode NE() { return getToken(GrammarMinilangParser.NE, 0); }
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(87);
				match(T__2);
				setState(88);
				expr(0);
				setState(89);
				match(T__3);
				}
				break;
			case 2:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				((ValueContext)_localctx).op = match(INT);
				}
				break;
			case 3:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				((ValueContext)_localctx).op = match(STRING);
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new MinValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				((MinValueContext)_localctx).op = match(MIN);
				setState(95);
				expr(0);
				setState(96);
				expr(6);
				}
				break;
			case 6:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				((LogicalNotContext)_localctx).op = match(NOT);
				setState(99);
				expr(5);
				}
				break;
			case 7:
				{
				_localctx = new Cond_valueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(COND_WHILE);
				}
				break;
			case 8:
				{
				_localctx = new Cond_value_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(COND_WHILE);
				setState(102);
				match(ASSIGN);
				setState(103);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(107);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(108);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(110);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(111);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(112);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(113);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 503316480L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(114);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(116);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(119);
						((LogicalAndContext)_localctx).op = match(AND);
						setState(120);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(122);
						((LogicalOrContext)_localctx).op = match(OR);
						setState(123);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_declContext extends ParserRuleContext {
		public Variable_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_decl; }
	 
		public Variable_declContext() { }
		public void copyFrom(Variable_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Variable_decl_idContext extends Variable_declContext {
		public TerminalNode VAR() { return getToken(GrammarMinilangParser.VAR, 0); }
		public List<TerminalNode> ID() { return getTokens(GrammarMinilangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarMinilangParser.ID, i);
		}
		public Type_basicContext type_basic() {
			return getRuleContext(Type_basicContext.class,0);
		}
		public Variable_decl_idContext(Variable_declContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitVariable_decl_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declContext variable_decl() throws RecognitionException {
		Variable_declContext _localctx = new Variable_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable_decl);
		int _la;
		try {
			_localctx = new Variable_decl_idContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(VAR);
			setState(130);
			match(ID);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(131);
				match(T__4);
				setState(132);
				match(ID);
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			match(T__5);
			setState(139);
			type_basic();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_basicContext extends ParserRuleContext {
		public TerminalNode INT_TYPE() { return getToken(GrammarMinilangParser.INT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(GrammarMinilangParser.STRING_TYPE, 0); }
		public Type_basicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_basic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitType_basic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_basicContext type_basic() throws RecognitionException {
		Type_basicContext _localctx = new Type_basicContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_basic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==INT_TYPE || _la==STRING_TYPE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Left_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarMinilangParser.ID, 0); }
		public Left_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarMinilangVisitor ) return ((GrammarMinilangVisitor<? extends T>)visitor).visitLeft_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Left_exprContext left_expr() throws RecognitionException {
		Left_exprContext _localctx = new Left_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_left_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u0092\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0004\u0000\u0018"+
		"\b\u0000\u000b\u0000\f\u0000\u0019\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u001e\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001+\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0003"+
		"\u00011\b\u0001\u0001\u0002\u0001\u0002\u0004\u00025\b\u0002\u000b\u0002"+
		"\f\u00026\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002<\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004H\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006U\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007i\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007}\b\u0007\n\u0007\f\u0007\u0080"+
		"\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0086\b\b\n\b\f\b\u0089"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0000"+
		"\u0001\u000e\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0005\u0001\u0000\u0012\u0013\u0001\u0000\u0014\u0015\u0001\u0000"+
		"\u0019\u001c\u0001\u0000\u001d\u001e\u0001\u0000\u001f \u00a5\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004;\u0001\u0000"+
		"\u0000\u0000\u0006=\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000"+
		"\nI\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000eh\u0001\u0000"+
		"\u0000\u0000\u0010\u0081\u0001\u0000\u0000\u0000\u0012\u008d\u0001\u0000"+
		"\u0000\u0000\u0014\u008f\u0001\u0000\u0000\u0000\u0016\u0018\u0003\u0002"+
		"\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b\u001d\u0003\n\u0005"+
		"\u0000\u001c\u001e\u0005!\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e1\u0001\u0000\u0000\u0000\u001f"+
		"1\u0003\b\u0004\u0000 1\u0003\u0006\u0003\u0000!1\u0005!\u0000\u0000\""+
		"1\u0005\u0007\u0000\u0000#1\u0005\b\u0000\u0000$&\u0003\u0010\b\u0000"+
		"%\'\u0005!\u0000\u0000&%\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\'1\u0001\u0000\u0000\u0000(*\u0003\f\u0006\u0000)+\u0005!\u0000"+
		"\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+1\u0001\u0000"+
		"\u0000\u0000,.\u0003\u000e\u0007\u0000-/\u0005!\u0000\u0000.-\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000\u001b"+
		"\u0001\u0000\u0000\u00000\u001f\u0001\u0000\u0000\u00000 \u0001\u0000"+
		"\u0000\u00000!\u0001\u0000\u0000\u00000\"\u0001\u0000\u0000\u00000#\u0001"+
		"\u0000\u0000\u00000$\u0001\u0000\u0000\u00000(\u0001\u0000\u0000\u0000"+
		"0,\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0005\u0001"+
		"\u0000\u000035\u0003\u0002\u0001\u000043\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000089\u0005\u0002\u0000\u00009<\u0001\u0000\u0000"+
		"\u0000:<\u0003\u0002\u0001\u0000;2\u0001\u0000\u0000\u0000;:\u0001\u0000"+
		"\u0000\u0000<\u0005\u0001\u0000\u0000\u0000=>\u0005\u000f\u0000\u0000"+
		">?\u0003\u000e\u0007\u0000?@\u0003\u0004\u0002\u0000@\u0007\u0001\u0000"+
		"\u0000\u0000AB\u0005\f\u0000\u0000BC\u0003\u000e\u0007\u0000CD\u0005\r"+
		"\u0000\u0000DG\u0003\u0004\u0002\u0000EF\u0005\u000e\u0000\u0000FH\u0003"+
		"\u0004\u0002\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"H\t\u0001\u0000\u0000\u0000IJ\u0003\u0014\n\u0000JK\u0005\u0010\u0000"+
		"\u0000KL\u0003\u000e\u0007\u0000L\u000b\u0001\u0000\u0000\u0000MN\u0005"+
		"\u0011\u0000\u0000NO\u0005#\u0000\u0000OU\u0005!\u0000\u0000PQ\u0005\u0011"+
		"\u0000\u0000QR\u0003\u000e\u0007\u0000RS\u0005!\u0000\u0000SU\u0001\u0000"+
		"\u0000\u0000TM\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000U\r\u0001"+
		"\u0000\u0000\u0000VW\u0006\u0007\uffff\uffff\u0000WX\u0005\u0003\u0000"+
		"\u0000XY\u0003\u000e\u0007\u0000YZ\u0005\u0004\u0000\u0000Zi\u0001\u0000"+
		"\u0000\u0000[i\u0005&\u0000\u0000\\i\u0005#\u0000\u0000]i\u0005%\u0000"+
		"\u0000^_\u0005\n\u0000\u0000_`\u0003\u000e\u0007\u0000`a\u0003\u000e\u0007"+
		"\u0006ai\u0001\u0000\u0000\u0000bc\u0005\u0016\u0000\u0000ci\u0003\u000e"+
		"\u0007\u0005di\u0005\u000b\u0000\u0000ef\u0005\u000b\u0000\u0000fg\u0005"+
		"\u0010\u0000\u0000gi\u0003\u000e\u0007\u0001hV\u0001\u0000\u0000\u0000"+
		"h[\u0001\u0000\u0000\u0000h\\\u0001\u0000\u0000\u0000h]\u0001\u0000\u0000"+
		"\u0000h^\u0001\u0000\u0000\u0000hb\u0001\u0000\u0000\u0000hd\u0001\u0000"+
		"\u0000\u0000he\u0001\u0000\u0000\u0000i~\u0001\u0000\u0000\u0000jk\n\u000e"+
		"\u0000\u0000kl\u0007\u0000\u0000\u0000l}\u0003\u000e\u0007\u000fmn\n\r"+
		"\u0000\u0000no\u0007\u0001\u0000\u0000o}\u0003\u000e\u0007\u000epq\n\f"+
		"\u0000\u0000qr\u0007\u0002\u0000\u0000r}\u0003\u000e\u0007\rst\n\u000b"+
		"\u0000\u0000tu\u0007\u0003\u0000\u0000u}\u0003\u000e\u0007\fvw\n\u0004"+
		"\u0000\u0000wx\u0005\u0017\u0000\u0000x}\u0003\u000e\u0007\u0005yz\n\u0003"+
		"\u0000\u0000z{\u0005\u0018\u0000\u0000{}\u0003\u000e\u0007\u0004|j\u0001"+
		"\u0000\u0000\u0000|m\u0001\u0000\u0000\u0000|p\u0001\u0000\u0000\u0000"+
		"|s\u0001\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|y\u0001\u0000\u0000"+
		"\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u000f\u0001\u0000\u0000\u0000\u0080~\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0005\t\u0000\u0000\u0082\u0087\u0005%"+
		"\u0000\u0000\u0083\u0084\u0005\u0005\u0000\u0000\u0084\u0086\u0005%\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005\u0006\u0000\u0000\u008b\u008c\u0003\u0012\t\u0000"+
		"\u008c\u0011\u0001\u0000\u0000\u0000\u008d\u008e\u0007\u0004\u0000\u0000"+
		"\u008e\u0013\u0001\u0000\u0000\u0000\u008f\u0090\u0005%\u0000\u0000\u0090"+
		"\u0015\u0001\u0000\u0000\u0000\u000e\u0019\u001d&*.06;GTh|~\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}