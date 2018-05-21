package CalcTDDTests;

import calctdd.controller.FXMLDocumentController;
import calctdd.model.Entry;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alexandre
 */
public class CalcTDDTests {
    
    private static FXMLDocumentController controller;
    
    @BeforeClass
    public static void setUpClass() {
        controller = new FXMLDocumentController();
    }
    
    @Test
    public void testNewEntry() {
        Entry operando = new Entry(10);
        assertEquals(10, operando.getValor());
    }
    
    @Test
    public void testNewLeftExpression() {
        Entry operando = new Entry(9);
        
    }
}
