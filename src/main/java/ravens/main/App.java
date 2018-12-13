package ravens.main;
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
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.lang.Integer;
import java.util.Collection;
import spoon.reflect.CtModelImpl;
import java.util.List;
import ravens.analyser.cfg.ControlFlowGraph;
import com.thoughtworks.qdox.*;
import com.thoughtworks.qdox.model.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {

JavaProjectBuilder builder = new JavaProjectBuilder();

//builder.addSourceFolder(new File("/root/repository/javapoet-master/src/main/java"));
builder.addSourceTree(new File("/root/sim/lang/lang_16_buggy/src/main/java"));
Collection<JavaClass> colljava= builder.getClasses();
System.out.println(colljava.size());

for(JavaClass jc : colljava)
{
     List<JavaMethod> methods = jc.getMethods();
     for(JavaMethod m : methods)
     if(m.getComment()!=null)
     {       System.out.println("---"+jc.getSource().getPackageName()+"---"+jc.getName()+"---"+m.getName());
             System.out.println(m.getComment());
     }

 }



//String code="/root/sim/lang/lang_16_buggy/src/main/java/org/apache/commons/lang3/math/NumberUtils.java";
//JavaSource src = builder.addSource(new FileReader(code));
//JavaPackage pkg      = src.getPackage();
//Collection<JavaClass> classes  = pkg.getClasses(); // BarClas
//classes.get(0).
//JavaClass cls     = src.getClasses().get(0);

//List<JavaMethod> methods = cls.getMethods();
//for(JavaMethod m : methods)
//	if(m.getName().equals("createNumber"))
//            System.out.println(m.getComment());

//String comment = methods.get(0).getComment();
//String nName = methods.get(0).getName(); // "n"
//System.out.println(nName);
//System.out.println(comment);
//builder.addSource(myReader);


      /*  Launcher l = new Launcher();
       //String tmpPath ="/root/Workspace/genesis-0.21/src/test/resources/rewrite/basic/__tmp13478/";
        String tmpPath = "/root/backSourcerer/SourcererCC-master/tokenizers/block-level/antlr/";
        //UntarDir tmpDir = new UntarDir(path);
	//String tmpPath = tmpDir.untar();
        //System.out.println(tmpPath);
		
		String[] spoonargs = {"-i", "", "--output-type", "nooutput", "-o", "spooned", "--source-classpath", ""};
		spoonargs[1] = tmpPath + "tool/src/org/antlr/v4/automata/TailEpsilonRemover.java";
                spoonargs[7] = tmpPath + "tool/src";		
		l.run(spoonargs);
                l.getModelBuilder().compile();
		CtModel cml=  l.getModel();
		
		boolean inst=cml instanceof CtModelImpl;
                
		List<CtMethod> cls = cml.getElements(new TypeFilter<>(CtMethod.class));
		
		ImportScanner importContext = new ImportScannerImpl();
		importContext.computeImports(cml.getRootPackage());
		Collection<CtImport> imports = importContext.getAllImports();
                for(CtImport ci : imports)
		System.out.println(ci.toString());


                //for(int i=0;i<cls.size();i++)
		//		System.out.println(cls.get(i).getImportKind());
		System.exit(0);
		ControlFlowGraph cfg = new ControlFlowGraph(cls.get(0));

		cfg.writeDotGraph(".","gf");
		assert(cml!=null);
		System.out.println(cml.getAllTypes().size());
		File ff = new File(spoonargs[1]);
		System.out.println(ff.exists());
		Factory f = l.getFactory();
		DefaultJavaPrettyPrinter dp= new DefaultJavaPrettyPrinter(f.getEnvironment());
		System.out.println(dp.getResult());
                Map<Integer,Integer> mii =dp.getLineNumberMapping();
		System.out.println(mii.size());

   */


    }
}
