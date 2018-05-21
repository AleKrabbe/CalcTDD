package calctdd.model;

import calctdd.controller.FXMLDocumentController.Operadores;
import calctdd.exceptions.ExpressionNotCompleteException;

/**
 * @author Alexandre
 */
public class Expression {
    
    private Entry left, right;
    private Operadores operador;

    public Expression() {
        this.left = null;
        this.operador = null;
        this.right = null;
    }
    
    public Expression(Entry left) {
        this.left = left;
        this.operador = null;
        this.right = null;
    }
    
    public Expression(Entry left, Operadores op) {
        this.left = left;
        this.operador = op;
        this.right = null;
    }
    
    public Expression(Entry left, Operadores op, Entry right) {
        this.left = left;
        this.operador = op;
        this.right = right;
    }
    
    public double execute() throws ExpressionNotCompleteException{
        double result = 0;
        if (left == null || right == null || operador == null) {
            throw new ExpressionNotCompleteException("Expressao incompleta");
        } else {
            switch(operador) {
                case SUM:
                    result = left.getValor() + right.getValor();
                    break;
                case SUB:
                    result = left.getValor() - right.getValor();
                    break;
                case DIV:
                    result = left.getValor() / right.getValor();
                    break;
                case MUL:
                    result = left.getValor() * right.getValor();
                    break;
            }
        }
        return result;
    }
    
    public boolean isComplete() {
        if (left == null || right == null || operador == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean hasLeft() {
        if (left == null) {
            return false;
        } else {
            return true;
        }
    }

    public void setLeft(Entry left) {
        this.left = left;
    }

    public void setRight(Entry right) {
        this.right = right;
    }

    public void setOperador(Operadores operador) {
        this.operador = operador;
    }
    
    
}
