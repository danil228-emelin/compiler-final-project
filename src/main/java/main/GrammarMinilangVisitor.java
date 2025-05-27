// Generated from ./GrammarMinilang.g4 by ANTLR 4.13.2
package main;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarMinilangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarMinilangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GrammarMinilangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(GrammarMinilangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(GrammarMinilangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(GrammarMinilangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(GrammarMinilangParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comment}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(GrammarMinilangParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multipleComment}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleComment(GrammarMinilangParser.MultipleCommentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declaration}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GrammarMinilangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printSmth}
	 * labeled alternative in {@link GrammarMinilangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSmth(GrammarMinilangParser.PrintSmthContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#whileStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(GrammarMinilangParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(GrammarMinilangParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiple_logic_block}
	 * labeled alternative in {@link GrammarMinilangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_logic_block(GrammarMinilangParser.Multiple_logic_blockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code single_logic_block}
	 * labeled alternative in {@link GrammarMinilangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_logic_block(GrammarMinilangParser.Single_logic_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#assignSt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSt(GrammarMinilangParser.AssignStContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(GrammarMinilangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code minValue}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinValue(GrammarMinilangParser.MinValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNot(GrammarMinilangParser.LogicalNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAnd}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(GrammarMinilangParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSub}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(GrammarMinilangParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relational}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(GrammarMinilangParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(GrammarMinilangParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalOr}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(GrammarMinilangParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code value}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(GrammarMinilangParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(GrammarMinilangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDiv}
	 * labeled alternative in {@link GrammarMinilangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(GrammarMinilangParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable_decl_id}
	 * labeled alternative in {@link GrammarMinilangParser#variable_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_decl_id(GrammarMinilangParser.Variable_decl_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link GrammarMinilangParser#printing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(GrammarMinilangParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link GrammarMinilangParser#printing}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintString(GrammarMinilangParser.PrintStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#type_basic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_basic(GrammarMinilangParser.Type_basicContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarMinilangParser#left_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeft_expr(GrammarMinilangParser.Left_exprContext ctx);
}