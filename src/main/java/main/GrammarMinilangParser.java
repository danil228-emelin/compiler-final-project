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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, LINE_COMMENT=9, 
		COMMENT=10, VAR=11, MIN=12, IF=13, THEN=14, ASSIGN=15, PRINT=16, MUL=17, 
		DIV=18, ADD=19, SUB=20, NOT=21, AND=22, OR=23, GT=24, LT=25, GE=26, LE=27, 
		EQ=28, NE=29, INT_TYPE=30, STRING_TYPE=31, NEWLINE=32, WS=33, STRING=34, 
		ESC=35, ID=36, INT=37;
	public static final int
		RULE_prog = 0, RULE_stat = 1, RULE_whileStat = 2, RULE_ifStat = 3, RULE_block = 4, 
		RULE_assignSt = 5, RULE_expr = 6, RULE_variable_decl = 7, RULE_printing = 8, 
		RULE_type_basic = 9, RULE_left_expr = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "stat", "whileStat", "ifStat", "block", "assignSt", "expr", "variable_decl", 
			"printing", "type_basic", "left_expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'else'", "'{'", "'}'", "'('", "')'", "','", "':'", 
			null, null, "'var'", "'min'", "'if'", "'then'", "'='", "'print'", "'*'", 
			"'/'", "'+'", "'-'", "'!'", "'&&'", "'||'", "'>'", "'<'", "'>='", "'<='", 
			"'=='", "'!='", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "LINE_COMMENT", 
			"COMMENT", "VAR", "MIN", "IF", "THEN", "ASSIGN", "PRINT", "MUL", "DIV", 
			"ADD", "SUB", "NOT", "AND", "OR", "GT", "LT", "GE", "LE", "EQ", "NE", 
			"INT_TYPE", "STRING_TYPE", "NEWLINE", "WS", "STRING", "ESC", "ID", "INT"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 73014521346L) != 0) );
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
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				assignSt();
				setState(28);
				match(NEWLINE);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				ifStat();
				}
				break;
			case T__0:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				whileStat();
				}
				break;
			case NEWLINE:
				_localctx = new BlankContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				match(NEWLINE);
				}
				break;
			case LINE_COMMENT:
				_localctx = new CommentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				match(LINE_COMMENT);
				}
				break;
			case COMMENT:
				_localctx = new MultipleCommentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(34);
				match(COMMENT);
				}
				break;
			case VAR:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(35);
				variable_decl();
				setState(36);
				match(NEWLINE);
				}
				break;
			case PRINT:
				_localctx = new PrintSmthContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(38);
				printing();
				setState(39);
				match(NEWLINE);
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
		enterRule(_localctx, 4, RULE_whileStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T__0);
			setState(44);
			expr(0);
			setState(45);
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
		enterRule(_localctx, 6, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(IF);
			setState(48);
			expr(0);
			setState(49);
			match(THEN);
			setState(50);
			block();
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(51);
				match(T__1);
				setState(52);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				_localctx = new Multiple_logic_blockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(T__2);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 73014521346L) != 0)) {
					{
					{
					setState(56);
					stat();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				match(T__3);
				}
				break;
			case T__0:
			case LINE_COMMENT:
			case COMMENT:
			case VAR:
			case IF:
			case PRINT:
			case NEWLINE:
			case ID:
				_localctx = new Single_logic_blockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
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
			setState(66);
			left_expr();
			setState(67);
			match(ASSIGN);
			setState(68);
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

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				match(T__4);
				setState(72);
				expr(0);
				setState(73);
				match(T__5);
				}
				break;
			case INT:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				((ValueContext)_localctx).op = match(INT);
				}
				break;
			case STRING:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				((ValueContext)_localctx).op = match(STRING);
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(ID);
				}
				break;
			case MIN:
				{
				_localctx = new MinValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				((MinValueContext)_localctx).op = match(MIN);
				setState(79);
				expr(0);
				setState(80);
				expr(4);
				}
				break;
			case NOT:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				((LogicalNotContext)_localctx).op = match(NOT);
				setState(83);
				expr(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(104);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(86);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(87);
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
						setState(88);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(90);
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
						setState(91);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(92);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(93);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(94);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(95);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(96);
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
						setState(97);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(98);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(99);
						((LogicalAndContext)_localctx).op = match(AND);
						setState(100);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(102);
						((LogicalOrContext)_localctx).op = match(OR);
						setState(103);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 14, RULE_variable_decl);
		int _la;
		try {
			_localctx = new Variable_decl_idContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(VAR);
			setState(110);
			match(ID);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(111);
				match(T__6);
				setState(112);
				match(ID);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__7);
			setState(119);
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
		enterRule(_localctx, 16, RULE_printing);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(PRINT);
				setState(122);
				expr(0);
				setState(123);
				match(NEWLINE);
				}
				break;
			case 2:
				_localctx = new PrintStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(PRINT);
				setState(126);
				match(STRING);
				setState(127);
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
			setState(130);
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
			setState(132);
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u0087\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0004\u0000\u0018"+
		"\b\u0000\u000b\u0000\f\u0000\u0019\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"*\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"6\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004:\b\u0004\n\u0004\f\u0004"+
		"=\t\u0004\u0001\u0004\u0001\u0004\u0003\u0004A\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006U\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006i\b\u0006\n\u0006\f\u0006l\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007r\b\u0007\n\u0007\f\u0007u\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u0081\b\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0000\u0001\f\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0000\u0005\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0014"+
		"\u0001\u0000\u0018\u001b\u0001\u0000\u001c\u001d\u0001\u0000\u001e\u001f"+
		"\u0093\u0000\u0017\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000\u0000"+
		"\u0004+\u0001\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b@\u0001"+
		"\u0000\u0000\u0000\nB\u0001\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000"+
		"\u000em\u0001\u0000\u0000\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012"+
		"\u0082\u0001\u0000\u0000\u0000\u0014\u0084\u0001\u0000\u0000\u0000\u0016"+
		"\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0001\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0003\n\u0005\u0000\u001c\u001d\u0005 \u0000\u0000\u001d*\u0001"+
		"\u0000\u0000\u0000\u001e*\u0003\u0006\u0003\u0000\u001f*\u0003\u0004\u0002"+
		"\u0000 *\u0005 \u0000\u0000!*\u0005\t\u0000\u0000\"*\u0005\n\u0000\u0000"+
		"#$\u0003\u000e\u0007\u0000$%\u0005 \u0000\u0000%*\u0001\u0000\u0000\u0000"+
		"&\'\u0003\u0010\b\u0000\'(\u0005 \u0000\u0000(*\u0001\u0000\u0000\u0000"+
		")\u001b\u0001\u0000\u0000\u0000)\u001e\u0001\u0000\u0000\u0000)\u001f"+
		"\u0001\u0000\u0000\u0000) \u0001\u0000\u0000\u0000)!\u0001\u0000\u0000"+
		"\u0000)\"\u0001\u0000\u0000\u0000)#\u0001\u0000\u0000\u0000)&\u0001\u0000"+
		"\u0000\u0000*\u0003\u0001\u0000\u0000\u0000+,\u0005\u0001\u0000\u0000"+
		",-\u0003\f\u0006\u0000-.\u0003\b\u0004\u0000.\u0005\u0001\u0000\u0000"+
		"\u0000/0\u0005\r\u0000\u000001\u0003\f\u0006\u000012\u0005\u000e\u0000"+
		"\u000025\u0003\b\u0004\u000034\u0005\u0002\u0000\u000046\u0003\b\u0004"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u00006\u0007\u0001"+
		"\u0000\u0000\u00007;\u0005\u0003\u0000\u00008:\u0003\u0002\u0001\u0000"+
		"98\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000"+
		"\u0000\u0000>A\u0005\u0004\u0000\u0000?A\u0003\u0002\u0001\u0000@7\u0001"+
		"\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\t\u0001\u0000\u0000\u0000"+
		"BC\u0003\u0014\n\u0000CD\u0005\u000f\u0000\u0000DE\u0003\f\u0006\u0000"+
		"E\u000b\u0001\u0000\u0000\u0000FG\u0006\u0006\uffff\uffff\u0000GH\u0005"+
		"\u0005\u0000\u0000HI\u0003\f\u0006\u0000IJ\u0005\u0006\u0000\u0000JU\u0001"+
		"\u0000\u0000\u0000KU\u0005%\u0000\u0000LU\u0005\"\u0000\u0000MU\u0005"+
		"$\u0000\u0000NO\u0005\f\u0000\u0000OP\u0003\f\u0006\u0000PQ\u0003\f\u0006"+
		"\u0004QU\u0001\u0000\u0000\u0000RS\u0005\u0015\u0000\u0000SU\u0003\f\u0006"+
		"\u0003TF\u0001\u0000\u0000\u0000TK\u0001\u0000\u0000\u0000TL\u0001\u0000"+
		"\u0000\u0000TM\u0001\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000Uj\u0001\u0000\u0000\u0000VW\n\f\u0000\u0000WX\u0007"+
		"\u0000\u0000\u0000Xi\u0003\f\u0006\rYZ\n\u000b\u0000\u0000Z[\u0007\u0001"+
		"\u0000\u0000[i\u0003\f\u0006\f\\]\n\n\u0000\u0000]^\u0007\u0002\u0000"+
		"\u0000^i\u0003\f\u0006\u000b_`\n\t\u0000\u0000`a\u0007\u0003\u0000\u0000"+
		"ai\u0003\f\u0006\nbc\n\u0002\u0000\u0000cd\u0005\u0016\u0000\u0000di\u0003"+
		"\f\u0006\u0003ef\n\u0001\u0000\u0000fg\u0005\u0017\u0000\u0000gi\u0003"+
		"\f\u0006\u0002hV\u0001\u0000\u0000\u0000hY\u0001\u0000\u0000\u0000h\\"+
		"\u0001\u0000\u0000\u0000h_\u0001\u0000\u0000\u0000hb\u0001\u0000\u0000"+
		"\u0000he\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000k\r\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000mn\u0005\u000b\u0000\u0000ns\u0005$\u0000\u0000op\u0005"+
		"\u0007\u0000\u0000pr\u0005$\u0000\u0000qo\u0001\u0000\u0000\u0000ru\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\b\u0000\u0000"+
		"wx\u0003\u0012\t\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0005\u0010\u0000"+
		"\u0000z{\u0003\f\u0006\u0000{|\u0005 \u0000\u0000|\u0081\u0001\u0000\u0000"+
		"\u0000}~\u0005\u0010\u0000\u0000~\u007f\u0005\"\u0000\u0000\u007f\u0081"+
		"\u0005 \u0000\u0000\u0080y\u0001\u0000\u0000\u0000\u0080}\u0001\u0000"+
		"\u0000\u0000\u0081\u0011\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u0004"+
		"\u0000\u0000\u0083\u0013\u0001\u0000\u0000\u0000\u0084\u0085\u0005$\u0000"+
		"\u0000\u0085\u0015\u0001\u0000\u0000\u0000\n\u0019)5;@Thjs\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}