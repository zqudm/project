package ravens.diff;
import spoon.Launcher;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.CtModel;
import spoon.reflect.code.CtLoop;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.code.CtIf;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtImport;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.reflect.visitor.ImportScanner;
import spoon.reflect.visitor.ImportScannerImpl;
import java.io.File;
import java.util.Map;
import java.lang.Integer;
import java.util.Collection;
import spoon.reflect.CtModelImpl;
import java.util.List;
import ravens.analyser.cfg.ControlFlowGraph;
import gumtree.spoon.diff.Diff;
import gumtree.spoon.diff.operations.MoveOperation;
import gumtree.spoon.diff.operations.Operation;
import gumtree.spoon.diff.operations.OperationKind;
import gumtree.spoon.AstComparator;

/**
 * Hello world!
 *
 */
public class Differ 
{
    public static void main( String[] args ) throws Exception
    {
       
        AstComparator ac = new AstComparator();
        Diff result = ac.compare(new File(args[0]), new File(args[1]));
	CtElement ancestor = result.commonAncestor();
	List<Operation> actions = result.getRootOperations();
        System.out.println(result.getAllOperations().size());
        if(ancestor instanceof CtClass)
	    System.out.println("CtClass");
	if(ancestor instanceof CtIf)
            System.out.println("CtIf");
        System.out.println(ancestor.getShortRepresentation());	
       

    }
}
